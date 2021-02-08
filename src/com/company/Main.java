package com.company;

import com.company.DI.ObjectFactory;
import com.company.Lecturer.Lecturer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ReflectiveOperationException, IOException {
	    Lecturer lecturer = new ObjectFactory().createObject(Lecturer.class);
	    lecturer.lecture();
    }
}
