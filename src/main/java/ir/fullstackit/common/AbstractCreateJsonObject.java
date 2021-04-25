package ir.fullstackit.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class AbstractCreateJsonObject {

    @JsonIgnore
    public abstract boolean isValid();

}
