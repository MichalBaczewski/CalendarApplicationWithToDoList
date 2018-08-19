package com.baczewski.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public String getEventPath() {
        return eventPath;
    }

    public String getTodoPath() {
        return todoPath;
    }

    public String getInputDateFormat() {
        return inputDateFormat;
    }

    public String getOutputDateFormat() {
        return outputDateFormat;
    }

    private String eventPath;
    private String todoPath;
    private String inputDateFormat;
    private String outputDateFormat;

    public PropertiesLoader() {
        try (InputStream resourceAsStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream("app.properties")){
//            Stream<String> lines = Files.lines(Paths.get(eventPath));
//            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get())
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            eventPath = properties.getProperty("path.event");
            todoPath = properties.getProperty("path.todo");
            inputDateFormat = properties.getProperty("dateInput");
            outputDateFormat = properties.getProperty("dateOutput");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
