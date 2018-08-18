import java.util.Optional;


class EventService {
    private final EventRepository repository;
    private final LocalDateParser localDateParser;

    EventService(EventRepository repository,
                 LocalDateParser localDateParser) {
        this.repository = repository;
        this.localDateParser = localDateParser;
    }

    void printAllEvents() {
//        for (Event event : repository.getAll()) {
//            printEvent(event);
//        }
        repository.getAll().forEach(this::printEvent);
    }

    void printCloserEvent() {
        Optional<Event> event = repository.getCloserEvent();
        String display = event.map(this::getDisplayEvent)
                .orElse("Nie ma najblizszego wydarzenia");
        System.out.println(display);
    }



    private void printEvent(Event event) {
        System.out.println("Event name:" + event.getName());
        String string = localDateParser.toDisplayString(event.getDate());
        System.out.println("date: " + string);
    }


    private String getDisplayEvent(Event event) {
        String displayString = localDateParser.toDisplayString(event.getDate());
        return "Event name:"
                + event.getName()
                +"\ndate: "
                + displayString;
    }


}
