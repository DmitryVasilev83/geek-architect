package ru.geekbrains.patterns.visitor;

public interface AnimalOperation {

    public void visitMonkey(Monkey monkey);
    public void visitLion(Lion lion);
    public void visitDolphin(Dolphin dolphin);
}
