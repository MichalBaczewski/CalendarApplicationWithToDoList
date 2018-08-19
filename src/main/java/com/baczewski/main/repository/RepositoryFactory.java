package com.baczewski.main.repository;

import com.baczewski.main.EventLineParser;
import com.baczewski.main.LocalDateParser;
import com.baczewski.main.PropertiesLoader;

public class RepositoryFactory {
    private final PropertiesLoader propertiesLoader;
    private final LocalDateParser localDateParser;
    private  final EventLineParser eventLineParser;

    public RepositoryFactory(PropertiesLoader propertiesLoader, LocalDateParser localDateParser, EventLineParser eventLineParser) {
        this.propertiesLoader = propertiesLoader;
        this.localDateParser = localDateParser;
        this.eventLineParser = eventLineParser;
    }

    public EventRepository getRepository() {
        String filePath = propertiesLoader.getEventPath();
        boolean endsWithXml = filePath.endsWith("xml");

        if (filePath.endsWith("xml")) {
            return new EventXmlRepository(propertiesLoader, localDateParser, eventLineParser);
        }
        return new EventTxtRepository(propertiesLoader, eventLineParser, localDateParser);
    }
}
