package ru.geekbrains.patterns.state;

public class TextEditor {

    protected WritingState state;

    public TextEditor(WritingState state) {
        this.state = state;
    }

    public void setState(WritingState state1)    {
        state = state1;
    }

    public void type(String words)    {
        state.write(words);
    }
}
