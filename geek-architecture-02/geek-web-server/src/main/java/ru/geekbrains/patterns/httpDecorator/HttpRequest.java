package ru.geekbrains.patterns.httpDecorator;

import java.util.Map;

public interface HttpRequest {


    public String getUrl();

    public void setUrl(String url) ;

    public Map<String, String> getHeaders();

    public void setHeaders(Map<String, String> headers);

    public String getBody();

    public void setBody(String body);
}
