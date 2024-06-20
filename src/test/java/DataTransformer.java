import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;

import java.lang.reflect.Type;

public class DataTransformer {
    // Set spring.jackson.serialization.write-dates-as-timestamps=false
    // in application.properties
    // This is required to convert ISO 8601 Date String to LocalDate and
    // many other java.time package use cases
    private final ObjectMapper objectMapper;

    // Spring will auto wire the ObjectMapper
    public DataTransformer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public Object transformer(Object fromValue, Type toValueType) {
        return objectMapper.convertValue(fromValue,
                objectMapper.constructType(toValueType));
    }
}
