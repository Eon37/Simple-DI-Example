package com.company.Lecturer;

public class Slide {
    private String text;
    private String comment;

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
