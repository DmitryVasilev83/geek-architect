package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestParser implements RequestParserInt{

    public HttpRequest parse(Deque<String> rawRequest) {
//        HttpRequest httpRequest = new HttpRequest();
//        String[] firstLine = rawRequest.pollFirst().split(" ");
//        httpRequest.setMethod(firstLine[0]);
//        httpRequest.setUrl(firstLine[1]);
//
//        while (!rawRequest.isEmpty()) {
//            String line = rawRequest.pollFirst();
//            if (line.isBlank()) {
//                break;
//            }
//            String[] header = line.split(": ");
//            httpRequest.getHeaders().put(header[0], header[1]);
//
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!rawRequest.isEmpty()) {
//            sb.append(rawRequest.pollFirst());
//        }
//        httpRequest.setBody(sb.toString());




// dz les 3
        String[] firstLine = rawRequest.pollFirst().split(" ");
        Map<String, String> headers = new HashMap<>();
        while (!rawRequest.isEmpty()) {
            String line = rawRequest.pollFirst();
            if (line.isBlank()) {
                break;
            }
            String[] header = line.split(": ");
            headers.put(header[0], header[1]);
        }
        StringBuilder sb = new StringBuilder();
        while (!rawRequest.isEmpty()) {
            sb.append(rawRequest.pollFirst());
        }
        HttpRequest httpRequest = HttpRequest.createBuilder()
                .withMethod(firstLine[0])
                .withUrl(firstLine[1])
                .withHeaders(headers)
                .withBody(sb.toString())
                .build();




        return httpRequest;
    }
}
