package dao;

import models.Location;

import java.util.List;

public interface LocationDao {

    List<Location> getAllLocations();

    Location findLocationByType(String type);

    void addLocation(Location location);

    Location findLocationById(int id);

    void deleteLocationById(int id);

    void deleteAllLocations();

}
