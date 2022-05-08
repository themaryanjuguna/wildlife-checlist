package dao;

import models.Location;
import models.Ranger;

import java.util.List;

public class Sql2oLocationDao implements LocationDao {
    @Override
    public List<Location> getAllLocations() {
        return null;
    }

    @Override
    public List<Ranger> getAllRangersByBadgeNumber(int badgeNumber) {
        return null;
    }

    @Override
    public void addLocation(Location location) {

    }

    @Override
    public void findLocationById(int id) {

    }

    @Override
    public void deleteLocationById(int id) {

    }

    @Override
    public void deleteAllLocations() {

    }
}
