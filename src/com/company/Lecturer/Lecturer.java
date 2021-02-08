package com.company.Lecturer;

import com.company.DI.Annotations.InjectByType;

public class Lecturer {
    @InjectByType
    private Lecture lecture;
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private SlideShow slideShow;

    public void lecture() {
        lecture.getSlides().forEach(slide -> {
            slideShow.show(slide.getText());
            speaker.speak(slide.getComment());
            System.out.println();
        });
    }

}
