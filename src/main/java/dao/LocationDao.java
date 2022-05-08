package dao;

import models.Location;
import models.Ranger;

import java.util.List;

public interface LocationDao {

    List<Location> getAllLocations();

    List<Ranger>getAllRangersByBadgeNumber(int badgeNumber);

    void addLocation(Location location);

    void findLocationById(int id);

    void deleteLocationById(int id);

    void deleteAllLocations();

}
