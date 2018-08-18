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

    private void printEvent(Event event) {
        System.out.println("Event name:" + event.getName());
        String string = localDateParser.toDisplayString(event.getDate());
        System.out.println("date: " + string);
    }
}
