package com.company.DI.Configurators;

//Object configurators deal with annotations
public interface ObjectConfigurator {
    void configure(Object t) throws ReflectiveOperationException;
}
