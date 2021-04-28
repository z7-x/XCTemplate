package com.z7.legal.common;

import io.swagger.annotations.ApiModel;

/**
 * @Classname UserService
 * @Description TODO 返回状态设置
 * @Date 2021/4/23 11:33 上午
 * @Author z7-x
 */
@ApiModel("返回码信息")
public enum ResultCode {

    /**
     * 消息
     */
    CONTINUE(100, "客户端应当继续发送请求。"),
    SWITCHING_PROTOCOLS(101, "服务器已经理解了客户端的请求，并将通过Upgrade 消息头通知客户端采用不同的协议来完成这个请求。"),
    PROCESSING(102, "由WebDAV（RFC 2518）扩展的状态码，代表处理将被继续执行。"),

    /**
     * 成功
     */
    OK(200, "请求已成功。"),
    CREATED(201, "请求已经被实现。"),
    ACCEPTED(202, "服务器已接受请求，但尚未处理。"),
    NON_AUTHORITATIVE_INFORMATION(203, "服务器已成功处理了请求，但返回的实体头部元信息不是在原始服务器上有效的确定集合，而是来自本地或者第三方的拷贝。当前的信息可能是原始版本的子集或者超集。"),
    NO_CONTENT(204, "服务器成功处理了请求，但不需要返回任何实体内容，并且希望返回更新了的元信息。"),
    RESET_CONTENT(205, "服务器成功处理了请求，且没有返回任何内容。"),
    PARTIAL_CONTENT(206, "服务器已经成功处理了部分 GET 请求。"),
    MULTI_STATUS(207, "由WebDAV(RFC 2518)扩展的状态码，代表之后的消息体将是一个XML消息，并且可能依照之前子请求数量的不同，包含一系列独立的响应代码。"),

    /**
     * 重定向
     */
    MULTIPLE_CHOICES(300, "被请求的资源有一系列可供选择的回馈信息，每个都有自己特定的地址和浏览器驱动的商议信息。用户或浏览器能够自行选择一个首选的地址进行重定向。"),
    MOVED_PERMANENTLY(301, "被请求的资源已永久移动到新位置，并且将来任何对此资源的引用都应该使用本响应返回的若干个 URI 之一。"),
    MOVE_TEMPORARILY(302, "请求的资源临时从不同的 URI响应请求。"),
    SEE_OTHER(303, "对应当前请求的响应可以在另一个 URL 上被找到，而且客户端应当采用 GET 的方式访问那个资源。"),
    NOT_MODIFIED(304, "304响应禁止包含消息体，因此始终以消息头后的第一个空行结尾。"),
    USE_PROXY(305, "只有原始服务器才能建立305响应。"),
    SWITCH_PROXY(306, "在最新版的规范中，306状态码已经不再被使用。"),
    TEMPORARY_REDIRECT(307, "请求的资源临时从不同的URI 响应请求"),

    /**
     * 请求错误
     */
    BAD_REQUEST(400, "1.语义有误，当前请求无法被服务器理解。除非进行修改，否则客户端不应该重复提交这个请求。2、请求参数有误。"),
    UNAUTHORIZED(401, "当前请求需要用户验证。"),
    PAYMENT_REQUIRED(402, "该状态码是为了将来可能的需求而预留的。"),
    FORBIDDEN(403, "服务器已经理解请求，但是拒绝执行它。"),
    NOT_FOUND(404, "请求失败，请求所希望得到的资源未被在服务器上发现。"),
    METHOD_NOT_ALLOWED(405, "请求行中指定的请求方法不能被用于请求相应的资源。"),
    NOT_ACCEPTABLE(406, "请求的资源的内容特性无法满足请求头中的条件，因而无法生成响应实体。"),
    PROXY_AUTHENTICATION_REQUIRED(407, "代理服务器必须返回一个 Proxy-Authenticate 用以进行身份询问。"),
    REQUEST_TIMEOUT(408, "请求超时。"),
    CONFLICT(409, "由于和被请求的资源的当前状态之间存在冲突，请求无法完成。"),
    GONE(410, "被请求的资源在服务器上已经不再可用，而且没有任何已知的转发地址。"),
    LENGTH_REQUIRED(411, "服务器拒绝在没有定义 Content-Length 头的情况下接受请求。"),
    PRECONDITION_FAILED(412, "服务器在验证在请求的头字段中给出先决条件时，没能满足其中的一个或多个。"),
    REQUEST_ENTITY_TOO_LARGE(413, "服务器拒绝处理当前请求，因为该请求提交的实体数据大小超过了服务器愿意或者能够处理的范围。"),
    REQUEST_URI_TOO_LONG(414, "请求的URI 长度超过了服务器能够解释的长度，因此服务器拒绝对该请求提供服务。"),
    UNSUPPORTED_MEDIA_TYPE(415, "对于当前请求的方法和所请求的资源，请求中提交的实体并不是服务器中所支持的格式，因此请求被拒绝。"),
    REQUESTED_RANGE_NOT_SATISFIABLE(416, "如果请求中包含了 Range 请求头，并且 Range 中指定的任何数据范围都与当前资源的可用范围不重合，同时请求中又没有定义 If-Range 请求头，那么服务器就应当返回416状态码。"),
    EXPECTATION_FAILED(417, "在请求头 Expect 中指定的预期内容无法被服务器满足，或者这个服务器是一个代理服务器，它有明显的证据证明在当前路由的下一个节点上，Expect 的内容无法被满足。"),
    MISDIRECTED_REQUEST(421, "请求被指向到无法生成响应的服务器（比如由于连接重复使用）"),
    UNPROCESSABLE_ENTITY(422, "请求格式正确，但是由于含有语义错误，无法响应。"),
    LOCKED(423, "当前资源被锁定。"),
    FAILED_DEPENDENCY(424, "由于之前的某个请求发生的错误，导致当前请求失败。"),
    TOO_EARLY(425, "状态码 425 Too Early 代表服务器不愿意冒风险来处理该请求，原因是处理该请求可能会被“重放”，从而造成潜在的重放攻击。"),

    /**
     * 服务器错误
     */
    INTERNAL_SERVER_ERROR(500, "服务器遇到了一个未曾预料的状况，导致了它无法完成对请求的处理。"),
    NOT_IMPLEMENTED(501, "服务器不支持当前请求所需要的某个功能。当服务器无法识别请求的方法，并且无法支持其对任何资源的请求。"),
    BAD_GATEWAY(502, "作为网关或者代理工作的服务器尝试执行请求时，从上游服务器接收到无效的响应。"),
    SERVICE_UNAVAILABLE(503, "由于临时的服务器维护或者过载，服务器当前无法处理请求。"),
    GATEWAY_TIMEOUT(504, "作为网关或者代理工作的服务器尝试执行请求时，未能及时从上游服务器（URI标识出的服务器，例如HTTP、FTP、LDAP）或者辅助服务器（例如DNS）收到响应。"),
    HTTP_VERSION_NOT_SUPPORTED(505, "服务器不支持，或者拒绝支持在请求中使用的 HTTP 版本。"),

    /**
     * 自定义错误
     */
    ERROR_VALIDATION(700, "字段校验不通过"),
    ERROR_NAME_OR_PASSWORD(701, "用户名或密码错误"),
    ERROR_CAPTCHA(702, "验证码错误"),

    INVALID_SESSION(711, "session已失效"),
    INVALID_TOKEN(712, "token已失效"),

    ERROR_THIRD_PARTY_FORWARD(721, "第三方接口无法访问"),
    ERROR_THIRD_PARTY_AUTH(722, "第三方接口授权失败"),
    ERROR_THIRD_PARTY_DATA(723, "第三方接口获取数据错误"),

    ERROR_FILE_TYPE(731, "文件类型错误"),

    DELETE_UNSUCCESSFUL(740, "删除失败"),

    EMPTY(741, "无数据"),
    OTHER(742, "未知异常");

    private Integer code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
