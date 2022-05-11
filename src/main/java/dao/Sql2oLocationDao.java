package dao;

import models.Location;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oLocationDao implements LocationDao {

    private final Sql2o sql2o;

    public Sql2oLocationDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void getDrivers(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Location> getAllLocations() {

        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery(" SELECT * FROM location")
                    .executeAndFetch(Location.class);
        }
    }

    @Override
    public void addLocation(Location location) {

        getDrivers();
        String sql = "INSERT INTO animals(id, type, time) VALUES (:id, :type, :time)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(location)
                    .executeUpdate()
                    .getKey();
            location.setId(id);
        } catch (Sql2oException e){
            System.out.println(e);
        }

    }

    @Override
    public Location findLocationByType(String type) {

        getDrivers();
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM location WHERE type = :type")
                    .addParameter("type", type)
                    .executeAndFetchFirst(Location.class);
        }

    }

    @Override
    public Location findLocationById(int id) {

        getDrivers();
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM location WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Location.class);
        }

    }

    @Override
    public void deleteLocationById(int id) {


        getDrivers();
        String sql = "DELETE FROM location WHERE id -:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e);
        }


    }

    @Override
    public void deleteAllLocations() {

        getDrivers();
        String sql = "DELETE FROM location";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();

        } catch (Sql2oException e){
            System.out.println(e);
        }

    }
}
