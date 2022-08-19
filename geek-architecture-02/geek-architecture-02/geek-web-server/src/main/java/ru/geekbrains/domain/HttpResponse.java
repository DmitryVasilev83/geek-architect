package ru.geekbrains.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private int statusCode;

    private String statusCodeName;

    private Map<String, String> headers = new HashMap<>();

    private String body;

    public HttpResponse() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
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

    public String getStatusCodeName() {
        return statusCodeName;
    }

    public void setStatusCodeName(String statusCodeName) {
        this.statusCodeName = statusCodeName;
    }


    //DZ les 3
    public static HttpResponse.HttpResponseBuilder createBuilder() {
        return new HttpResponse.HttpResponseBuilder();
    }

    public static class HttpResponseBuilder{

        private final HttpResponse httpResponse;

        public HttpResponseBuilder() {
            this.httpResponse = new HttpResponse();
        }

        public HttpResponse.HttpResponseBuilder withStatusCode(int statusCode) {
            this.httpResponse.statusCode = statusCode;
            return this;
        }

        public HttpResponse.HttpResponseBuilder withStatusCodeName(String statusCodeName) {
            this.httpResponse.statusCodeName = statusCodeName;
            return this;
        }

        public HttpResponse.HttpResponseBuilder withHeaders(Map<String, String> headers) {
            this.httpResponse.headers = headers;
            return this;
        }

        public HttpResponse.HttpResponseBuilder withBody(String body) {
            this.httpResponse.body = body;
            return this;
        }

        public HttpResponse build() {
            return httpResponse;
        }
    }
}
