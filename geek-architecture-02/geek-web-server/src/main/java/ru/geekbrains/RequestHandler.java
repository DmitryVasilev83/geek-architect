package ru.geekbrains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RequestHandler implements Runnable {

    private final Socket socket;

    private final String folder;

    public RequestHandler(Socket socket, String folder) {
        this.socket = socket;
        this.folder = folder;
    }

    @Override
    public void run() {
        try (BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter output = new PrintWriter(socket.getOutputStream())
        ) {
            while (!input.ready());
            String firstLine = input.readLine();
            String requestAfterParsing = new RequestParsing(firstLine).requestPars();

            while (input.ready()) {
                System.out.println(input.readLine());
            }

            Path path = Paths.get(folder, requestAfterParsing);

            WorkWithFiles workWithFiles = new WorkWithFiles(path);

            if (workWithFiles.checkingFileExist()){
                new ResponceHandler(workWithFiles, socket, output).responce_200();
            }else {
                new ResponceHandler(workWithFiles, socket, output).responce_404();
//                return;
            }

            System.out.println("Client disconnected!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
