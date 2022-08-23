package ru.geekbrains.patterns.httpDecorator;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestGet implements HttpRequest{

    private String method = "GET";

    protected HttpRequestSimpl httpRequestSimpl;

    private String url;

    private Map<String, String> headers = new HashMap<>();

    private String body;

    public HttpRequestGet() {
    }

    public HttpRequestGet( HttpRequestSimpl httpRequestSimpl) {

        this.httpRequestSimpl = httpRequestSimpl;
    }

    public String getMethod() {
        return method;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }
}
