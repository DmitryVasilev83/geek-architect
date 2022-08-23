package ru.geekbrains.patterns.bridge;

public class Careers implements WebPage{

    protected Theme theme;

    public Careers(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "Careers page in " + theme.getColor();
    }
}
