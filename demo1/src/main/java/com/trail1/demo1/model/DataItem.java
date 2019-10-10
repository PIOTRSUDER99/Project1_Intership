package com.trail1.demo1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class DataItem {

    private final String name;
  //  private final UUID id;

    public DataItem(@JsonProperty("name")  String name, @JsonProperty("id") UUID id)
    {
        this.name = name;
    //    this.id = id;
    }

  //  public UUID getId()
  //  {
  //      return id;
  //  }

    public String getName()
    {
        return name;
    }

}
