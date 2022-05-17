package dao;

import models.Location;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oLocationDao implements LocationDao {

         @Override
    public List<Location> getAllLocations() {

             try(Connection con = DB.sql2o.open()){
            return con.createQuery(" SELECT * FROM location")
                    .executeAndFetch(Location.class);
        }
    }

    @Override
    public void addLocation(Location location) {

        String sql = "INSERT INTO animals(id, type, time) VALUES (:id, :type, :time)";
        try(Connection con = DB.sql2o.open()){
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


        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM location WHERE type = :type")
                    .addParameter("type", type)
                    .executeAndFetchFirst(Location.class);
        }

    }

    @Override
    public Location findLocationById(int id) {


        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM location WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Location.class);
        }

    }

    @Override
    public void deleteLocationById(int id) {



        String sql = "DELETE FROM location WHERE id -:id";
        try(Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e);
        }


    }

    @Override
    public void deleteAllLocations() {

        String sql = "DELETE FROM location";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();

        } catch (Sql2oException e){
            System.out.println(e);
        }

    }
}
