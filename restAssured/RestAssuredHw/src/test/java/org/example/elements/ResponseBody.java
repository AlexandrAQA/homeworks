package org.example.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseBody {

    @JsonProperty("id")
    private int id;

    public int getId() {
        return id;
    }
}
