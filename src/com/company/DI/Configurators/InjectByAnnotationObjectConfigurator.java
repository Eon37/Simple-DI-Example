package com.company.DI.Configurators;

import com.company.DI.Annotations.InjectByType;
import com.company.DI.ObjectFactory;

import java.lang.reflect.Field;

public class InjectByAnnotationObjectConfigurator implements ObjectConfigurator {
    private final ObjectFactory factory;

    public InjectByAnnotationObjectConfigurator(ObjectFactory factory) {
        this.factory = factory;
    }

    @Override
    public void configure(Object t) throws ReflectiveOperationException {

        Field[] fields = t.getClass().getDeclaredFields();
        for (var field: fields) {
            if(field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                field.set(t, factory.createObject(field.getType()));
            }
        }
    }
}
