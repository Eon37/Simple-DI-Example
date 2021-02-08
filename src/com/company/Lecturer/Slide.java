package com.company.Lecturer;

public class Slide {
    private final String text;
    private final String comment;

    public Slide(String text, String comment) {
        this.text = text;
        this.comment = comment;
    }

    public String getText() {
        return text;
    }

    public String getComment() {
        return comment;
    }

}
