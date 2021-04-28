package com.z7.legal.config;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.ControlledRealTimeReopenThread;
import org.apache.lucene.search.SearcherFactory;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Classname LuceneConfig
 * @Description TODO 切面配置类
 * @Date 2021/4/26 9:56 上午
 * @Author z7-x
 */
@Configuration
public class LuceneConfig {
    /**
     * lucene索引库,存放位置
     */
    private static final String LUCENE_INDEX_PATH = "index_database";

    /**
     * 1、索引位置:创建一个Directory对象，指定索引库保存的位置
     *
     * @return
     * @throws IOException
     */
    @Bean
    public Directory directory() throws IOException {

        Path path = Paths.get(LUCENE_INDEX_PATH);
        File file = path.toFile();
        if (!file.exists()) {
            //如果文件夹不存在,则创建
            file.mkdirs();
        }
        return FSDirectory.open(path);
    }

    /**
     * 创建一个 Analyzer 实例
     * IK分词器
     *
     * @return
     */
    @Bean
    public Analyzer analyzer() {
        return new IKAnalyzer();
    }

    /**
     * 2、基于Directory创建一个indexWriter对象
     *
     * @param directory
     * @param analyzer
     * @return
     * @throws IOException
     */
    @Bean
    public IndexWriter indexWriter(Directory directory, Analyzer analyzer) throws IOException {
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        // 清空索引
        indexWriter.deleteAll();
        indexWriter.commit();
        return indexWriter;
    }

    /**
     * SearcherManager管理
     *
     * @return
     * @throws IOException
     */
    @Bean
    public SearcherManager searcherManager(IndexWriter indexWriter) throws IOException {
        SearcherManager searcherManager = new SearcherManager(indexWriter, false, false, new SearcherFactory());
        ControlledRealTimeReopenThread cRTReopenThead = new ControlledRealTimeReopenThread(indexWriter, searcherManager,
                5.0, 0.025);
        cRTReopenThead.setDaemon(true);
        //线程名称
        cRTReopenThead.setName("更新IndexReader线程");
        // 开启线程
        cRTReopenThead.start();
        return searcherManager;
    }

}
