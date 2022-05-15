package models;

import java.sql.Timestamp;
import java.util.Objects;

public class Sightings {

   public int id;
   private String animalname;
   private String animaltype;
   private String location;
   private String rangername;
   private String time;
   private Timestamp timestamp;

 public Sightings(String animalname, String animaltype, String location, String rangername) {
  this.animalname = animalname;
  this.animaltype = animaltype;
  this.location = location;
  this.rangername = rangername;
 }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalname() {
        return animalname;
    }

    public void setAnimalname(String animalname) {
        this.animalname = animalname;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRangername() {
        return rangername;
    }

    public void setRangername(String rangername) {
        this.rangername = rangername;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sightings = (Sightings) o;
        return id == sightings.id && animalname.equals(sightings.animalname) && animaltype.equals(sightings.animaltype) && location.equals(sightings.location) && rangername.equals(sightings.rangername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animalname, animaltype, location, rangername);
    }
}
