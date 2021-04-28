package com.z7.legal.dao.impl;

import com.z7.legal.bean.User;
import com.z7.legal.common.Page;
import com.z7.legal.common.RequestPram;
import com.z7.legal.common.Result;
import com.z7.legal.dao.UserIndexDao;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery.Builder;
import org.apache.lucene.search.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository(value = "userIndexDao")
public class UserIndexDaoImpl implements UserIndexDao {

    @Autowired(required = false)
    private IndexWriter indexWriter;

    @Autowired
    private Analyzer analyzer;

    @Autowired
    private SearcherManager searcherManager;

    @Override
    public void createUserIndex(List<User> userList) throws IOException {
        List<Document> docs = new ArrayList<>();
        for (User user : userList) {
            Document doc = new Document();
            doc.add(new StringField("id", user.getId().toString(), Field.Store.YES));
            doc.add(new TextField("name", user.getName(), Field.Store.YES));
            doc.add(new StringField("sex", user.getSex(), Field.Store.YES));
            doc.add(new StringField("email", user.getEmail(), Field.Store.YES));
            doc.add(new StringField("phone", user.getPhone(), Field.Store.YES));
            doc.add(new TextField("describe", user.getDescribe(), Field.Store.YES));
            docs.add(doc);
        }
        indexWriter.addDocuments(docs);
        indexWriter.commit();
    }

    @Override
    public Result searchUser(RequestPram<User> pageQuery) throws IOException, ParseException {
        searcherManager.maybeRefresh();
        IndexSearcher indexSearcher = searcherManager.acquire();

        User params = pageQuery.getQueryPram();
        Map<String, Object> maps = pageQuery.getQueryMaps();

        Builder builder = new Builder();
        Sort sort = new Sort();
        // 排序规则
        com.z7.legal.common.Sort sort1 = pageQuery.getSort();
        if (sort1 != null && sort1.getOrder() != null) {
            if ("ASC".equals((sort1.getOrder()).toUpperCase())) {
                sort.setSort(new SortField(sort1.getField(), SortField.Type.FLOAT, false));
            } else if ("DESC".equals((sort1.getOrder()).toUpperCase())) {
                sort.setSort(new SortField(sort1.getField(), SortField.Type.FLOAT, true));
            }
        }

        // 多条件查询：模糊匹配,匹配词
        if (null != maps) {
            String keyStr = (String) maps.get("searchKeyStr");
            if (keyStr != null) {
                // 输入空格,不进行模糊查询
                if (!"".equals(keyStr.replaceAll(" ", ""))) {
                    builder.add(new QueryParser("name", analyzer).parse(keyStr), Occur.MUST);
                }
            }
        }

        // 精确查询:new TermQuery();
        // 范围查询:FloatPoint.newRangeQuery();
        if (!ObjectUtils.isEmpty(params)) {
            if (params.getName() != null) {
                builder.add(new TermQuery(new Term("name", params.getName())), Occur.MUST);
            }
            if (params.getSex() != null) {
                builder.add(new TermQuery(new Term("sex", params.getSex())), Occur.MUST);
            }
            if (params.getDescribe() != null) {
                builder.add(new TermQuery(new Term("describe", params.getDescribe())), Occur.MUST);
            }
        }

        TopDocs topDocs = indexSearcher.search(builder.build(), pageQuery.getPageNum() * pageQuery.getPageSize(), sort);

        Page page = handlePageData(pageQuery, topDocs);

        ScoreDoc[] hits = topDocs.scoreDocs;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < hits.length; i++) {
            Document doc = indexSearcher.doc(hits[i].doc);
            User user = new User();
            user.setId(doc.get("id"));
            user.setName(doc.get("name"));
            user.setSex(doc.get("sex"));
            user.setPhone(doc.get("phone"));
            user.setDescribe(doc.get("describe"));
            userList.add(user);
        }

        Result<Object> result = new Result<>();
        result.setPage(page);
        result.setData(userList);
        return result;
    }

    @Override
    public List<User> searchUser(String pram) throws IOException, ParseException {
        List<User> products = new ArrayList<>();
        searcherManager.maybeRefresh();
        IndexSearcher indexSearcher = searcherManager.acquire();
        QueryParser parser = new QueryParser("describe", new IKAnalyzer());
        Query query = parser.parse(pram);
        TopDocs topDocs = indexSearcher.search(query, 10);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        for (ScoreDoc doc : scoreDocs) {
            int id = doc.doc;
            Document document = indexSearcher.doc(id);
            User user = new User();
            user.setId(document.get("id"));
            user.setName(document.get("name"));
            user.setSex(document.get("sex"));
            user.setPhone(document.get("phone"));
            user.setDescribe(document.get("describe"));
            products.add(user);
        }
        return products;
    }

    @Override
    public void addUserIndex(User user) throws IOException {
        Document doc = new Document();
        doc.add(new StringField("id", user.getId().toString(), Field.Store.YES));
        doc.add(new TextField("name", user.getName(), Field.Store.YES));
        doc.add(new StringField("sex", user.getSex(), Field.Store.YES));
        doc.add(new StringField("email", user.getEmail(), Field.Store.YES));
        doc.add(new StringField("phone", user.getPhone(), Field.Store.YES));
        doc.add(new TextField("describe", user.getDescribe(), Field.Store.YES));
        indexWriter.addDocument(doc);
        indexWriter.commit();
    }

    @Override
    public void deleteUserIndexById(String id) throws IOException {
        indexWriter.deleteDocuments(new Term("id", id));
        indexWriter.commit();
    }

    /**
     * 处理返回给前端的分页参数
     *
     * @param pageQuery
     * @param topDocs
     */
    public Page handlePageData(RequestPram<User> pageQuery, TopDocs topDocs) {
        //总记录数
        Long total = topDocs.totalHits.value;
        //第几页
        int pageNum = (pageQuery.getPageNum() - 1) * pageQuery.getPageSize();
        //每页显示数
        Integer pageSize = pageQuery.getPageNum() * pageQuery.getPageSize();
        //总页数
        Double ceil = Math.ceil(total.floatValue() / pageSize.floatValue());
        int totalPages = ceil.intValue();
        return Page.builder()
                .total(total)
                .pageSize(pageSize)
                .pageNum(pageNum)
                .totalPages(totalPages)
                .build();
    }
}
