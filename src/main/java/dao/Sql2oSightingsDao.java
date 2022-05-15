package dao;

import models.Ranger;
import models.Sightings;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oSightingsDao implements SightingsDao {

   public List<Sightings> getAllSightings() {
        try(Connection con = DB.myDb.open()) {
            return con.createQuery(" SELECT * FROM sightings")
                    .executeAndFetch(Sightings.class);
        }
    }

    public void addSightings(Sightings sightings){
        String sql = "INSERT INTO sightings(animalname,  animaltype, location, rangername, time) VALUES ( :animalname, :animaltype, :location, :rangername, now())";
            try(Connection con = DB.myDb.open()){
                int id = (int) con.createQuery(sql, true)
                        .bind(sightings)
                        .executeUpdate()
                        .getKey();
                sightings.setId(id);
            } catch (Sql2oException e){
                System.out.println(e);
            }


        }

    public Sightings findSightingsById(int id) {
        try(Connection con = DB.myDb.open()){
            return con.createQuery("SELECT * FROM sightings WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);
        }

    }

    public void deleteSightingsById(int id) {

        String sql = "DELETE FROM sightings WHERE id = :id";
        try (Connection con = DB.myDb.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    public void deleteAllSightings() {
        String sql = "DELETE FROM sightings";
        try(Connection con = DB.myDb.open()){
            con.createQuery(sql)
                    .executeUpdate();

        } catch (Sql2oException e){
            System.out.println(e);
        }


    }


}
