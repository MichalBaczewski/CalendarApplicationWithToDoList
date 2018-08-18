import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LocalDateParser {
    private final PropertiesLoader propertiesLoader;

    LocalDateParser(PropertiesLoader propertiesLoader) {
        this.propertiesLoader = propertiesLoader;

    }
    String toDisplayString(String dateInRawString){
        LocalDateTime localDateTime = toLocalDateTime(dateInRawString);
        return toDisplayString(localDateTime);
    }

    String toDisplayString(LocalDateTime localDateTime){
        String outputDateFormat = propertiesLoader.getOutputDateFormat();
        DateTimeFormatter formatter = DateTimeFormatter.
                ofPattern(outputDateFormat);
        return localDateTime.format(formatter);
    }
    LocalDateTime toLocalDateTime(String string){
        String inputDateFormat = propertiesLoader.getInputDateFormat();
        DateTimeFormatter formatter = DateTimeFormatter.
                ofPattern(inputDateFormat);
        return LocalDateTime.parse(string, formatter);
    }
}
