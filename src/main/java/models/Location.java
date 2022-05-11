package models;

import jdk.jfr.Timestamp;

import java.lang.reflect.Type;
import java.util.Objects;

public class Location {

    private String type;
    private int id;
    private Timestamp timestamp;

    public Location(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if( o == null || getClass() !=o.getClass()) return false;
        Location location =(Location) o;
        return timestamp == location.timestamp && type.equals(location.type);
    }

    @Override
    public int hashCode() {return Objects.hash(type, timestamp); }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  /*  public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }*/
}

