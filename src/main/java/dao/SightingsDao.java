package dao;

import models.Sightings;
import java.util.List;


public interface SightingsDao {
    //CRUD
    List<Sightings> getAllSightings();
    void addSightings(Sightings sightings);
    Sightings findSightingsById(int id);
    void deleteSightingsById(int id);
    void deleteAllSightings();



}
