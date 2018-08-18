import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class EventTxtRepository implements EventRepository {
    private PropertiesLoader propertiesLoader;
    private final EventLineParser parser;

    public EventTxtRepository(PropertiesLoader propertiesLoader,
                              EventLineParser parser) {
        this.propertiesLoader = propertiesLoader;
        this.parser = parser;
    }

    @Override
    public List<Event> getAll() {
        try {
            Path path = Paths.get(propertiesLoader.getEventPath());
            Stream<Event> eventStream = Files.lines(path)
                    .map(parser::toEvent)
                    .filter(Optional::isPresent)
                    .map(Optional::get);
            return eventStream
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


}
