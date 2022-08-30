package ru.geekbrains.patterns.command;

public interface Command {

    public void execute();
    public void undo();
    public void redo();
}
