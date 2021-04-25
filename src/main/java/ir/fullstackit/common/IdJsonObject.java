package ir.fullstackit.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IdJsonObject {

    @JsonProperty(value = "id")
    private final String id;

    public IdJsonObject(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
