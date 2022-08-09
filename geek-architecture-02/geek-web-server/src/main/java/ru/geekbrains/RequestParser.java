package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    private HttpRequest httpRequest;

    public HttpRequest parse(Deque<String> rawRequest) {

        String firstLine = rawRequest.pollFirst();
        String firstLine1;
        String[] parts = firstLine.split(" ");
        String[] partsTemp1;

        httpRequest = new HttpRequest();
        httpRequest.setMethod(parts[0]);
        httpRequest.setPath(parts[1]);
        httpRequest.setHttpVers(parts[2]);

        Map<String, String> mapReq = new HashMap<>();
        while (rawRequest.size() > 1){
            firstLine1 = rawRequest.pollFirst();
            partsTemp1 = firstLine1.split(" ", 2);
            mapReq.put(partsTemp1[0], partsTemp1[1]);
        }

        httpRequest.setHeaders(mapReq);

        if (httpRequest.getMethod().equals("GET")){
            httpRequest.setBody("");
        }else{
            httpRequest.setBody("");   // todo
        }

        return httpRequest;
    }
}
