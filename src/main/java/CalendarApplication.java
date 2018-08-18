class CalendarApplication {
    public static void main(String[] args) {
        PropertiesLoader properties = new PropertiesLoader();
        EventLineParser parser = new EventLineParser();
        EventRepository eventRepository = new EventTxtRepository(properties, parser);
        LocalDateParser localDateParser = new LocalDateParser(properties);
        EventService eventService = new EventService(eventRepository, localDateParser);
        eventService.printAllEvents();
    }
}
