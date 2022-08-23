package ru.geekbrains.patterns.httpDecorator;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestSimpl implements HttpRequest{


    private String url;

    private Map<String, String> headers = new HashMap<>();

    private String body;

    public HttpRequestSimpl(String url, Map<String, String> headers, String body) {
        this.url = url;
        this.headers = headers;
        this.body = body;
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
