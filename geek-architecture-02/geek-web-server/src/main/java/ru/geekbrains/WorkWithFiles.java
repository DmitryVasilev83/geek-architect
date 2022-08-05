package ru.geekbrains;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkWithFiles {

    Path path;

    public WorkWithFiles(Path path) {
        this.path = path;
    }

    public boolean checkingFileExist(){
        return Files.exists(path);
    }

    public BufferedReader getFile() throws IOException {

        return Files.newBufferedReader(path);

    }









}
