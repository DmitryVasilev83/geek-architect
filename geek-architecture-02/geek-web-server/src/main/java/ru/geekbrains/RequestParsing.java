package ru.geekbrains;


public class RequestParsing {

    private String firstLine;
    private String requestAfterParsing;

    public RequestParsing(String firstLine) {
        this.firstLine = firstLine;
    }

    public String requestPars(){

            String[] parts = firstLine.split(" ");
            System.out.println(firstLine);
            requestAfterParsing = parts[1];

        return requestAfterParsing;

    }


}
