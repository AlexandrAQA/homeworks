package org.example.elements;

import lombok.Data;

@Data
public class RequestBody {
    private String title;
    private String body;
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
