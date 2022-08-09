package ru.geekbrains.domain;

import java.util.Map;

public class HttpRequest {

    private String method;

    private String path;

    private Map<String, String> headers;

    private String body;

    private String httpVers;

    public HttpRequest() {
    }

    public String getHttpVers() {
        return httpVers;
    }

    public void setHttpVers(String httpVers) {
        this.httpVers = httpVers;
    }

    public HttpRequest(String method, String path, Map<String, String> headers, String body, String httpVers) {
        this.method = method;
        this.path = path;
        this.headers = headers;
        this.body = body;
        this.httpVers = httpVers;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
