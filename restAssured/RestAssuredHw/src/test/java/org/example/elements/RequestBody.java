package org.example.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestBody {

    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;
    @JsonProperty("userId")
    private int id;

    public void setId(int i) {
    }

    public void setTitle(String title) {
    }

    public void setBody(String body) {
    }

    public int setUserId(int i) {
        return i;
    }
}
