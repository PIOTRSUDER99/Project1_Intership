package com.trail1.demo1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class DataItem {

    private final String name;


    public DataItem(@JsonProperty("name")  String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

}
