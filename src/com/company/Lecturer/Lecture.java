package com.company.Lecturer;

import java.util.List;

public class Lecture {
    private final List<Slide> slides = List.of(new Slide("slide1", "dhkwsjd gfkq"),
                                            new Slide("slide2", "hdfqsyu hjkw"),
                                            new Slide("slide3 (with picture)", "fklshd wke"));

    public List<Slide> getSlides() {
        return slides;
    }
}
