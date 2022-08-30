package ru.geekbrains.patterns.memento;

public class Editor {

    protected String content = "";

    public void type(String words)    {
        content = content + "" + words;
    }

    public String getContent()
    {
        return content;
    }

    public EditorMemento save()    {
        return new EditorMemento(content);
    }

    public void restore(EditorMemento memento)    {
        content = memento.getContent();
    }
}
