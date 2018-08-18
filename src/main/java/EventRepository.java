import java.util.List;
import java.util.Optional;

interface EventRepository {
        List<Event> getAll();
        Optional<Event> getCloserEvent();
}
