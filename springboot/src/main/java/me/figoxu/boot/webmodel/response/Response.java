package me.figoxu.boot.webmodel.response;

/**
 * Created by figo on 2/22/17.
 */
public class Response {
    private Integer code;
    private Object content;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
