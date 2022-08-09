package ru.geekbrains.domain;

import java.util.Map;

public class HttpResponse {

    private String statusCode;

    private Map<String, String> headers;

    private String body;

    private String httpVers;

    public String getHttpVers() {
        return httpVers;
    }

    public void setHttpVers(String httpVers) {
        this.httpVers = httpVers;
    }

    public HttpResponse() {
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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
