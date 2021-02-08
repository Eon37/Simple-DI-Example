package com.company.DI;

import com.company.DI.Configurators.ObjectConfigurator;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectFactory {
    private static final Path path = Paths.get(Paths.get("").toAbsolutePath().toString() +
                                                    "\\src\\com\\company\\DI\\Configurators");
    private static List<ObjectConfigurator> configurators;

    public ObjectFactory() throws IOException {
        getObjectConfigurators();
    }

    public void getObjectConfigurators() throws IOException {
        configurators = Files.list(path)
                .map(this::mapPathToObjectConfigurator)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private ObjectConfigurator mapPathToObjectConfigurator(Path path) {
        ObjectConfigurator objConf = null;

        try {
            objConf = (ObjectConfigurator) Class.forName(path
                    .toString()
                    .replaceFirst(".+(com\\\\company\\\\.*)\\.java", "$1")
                    .replace('\\', '.'))
                    .getDeclaredConstructor(ObjectFactory.class) //constructor argument type
                    .newInstance(this);
        } catch (InstantiationException | NoSuchMethodException e) {
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return objConf;
    }

    public <T> T createObject(Class<? extends T> type) throws ReflectiveOperationException {
        T obj = type.getConstructor().newInstance();
        configure(obj);

        return obj;
    }

    private <T> void configure(T t) throws ReflectiveOperationException {
        for(ObjectConfigurator configurator: configurators) {
            configurator.configure(t);
        }
    }
}
