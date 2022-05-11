package dao;

import models.Animals;
import models.Location;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

import static java.lang.Class.forName;

public class Sql2oAnimalsDao implements AnimalsDao {


    private final Sql2o sql2o;

    public Sql2oAnimalsDao(Sql2o sql2o) {
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
    public List<Animals> getAllAnimals() {
        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery(" SELECT * FROM Animals")
                    .executeAndFetch(Animals.class);
        }
    }

    @Override
    public List<Location> getAllLocation() {

        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery(" SELECT * FROM Location")
                    .executeAndFetch(Location.class);
        }

    }

    @Override
    public void addAnimal(Animals animals) {
        getDrivers();
        String sql = "INSERT INTO animals(name, age, behaviour, health, risk) VALUES (:name, :age, :behaviour, :health, :risk)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(animals)
                    .executeUpdate()
                    .getKey();
            animals.setId(id);
        } catch (Sql2oException e){
            System.out.println(e);
        }

    }

    @Override
    public Animals findAnimalByName(String name) {
        getDrivers();
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE name = :name")
                    .addParameter("name", name)
                    .executeAndFetchFirst(Animals.class);
        }

    }

    @Override
    public Animals findAnimalByRisk(String risk) {

        getDrivers();
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE risk = :risk")
                    .addParameter("risk", risk)
                    .executeAndFetchFirst(Animals.class);
        }

    }

    @Override
    public Animals findAnimalByHealth(String health) {

        getDrivers();
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE health = :health")
                    .addParameter("health", health)
                    .executeAndFetchFirst(Animals.class);
        }

    }

    @Override
    public Animals findAnimalByAge(int age) {

        getDrivers();
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE age = :age")
                    .addParameter("age", age)
                    .executeAndFetchFirst(Animals.class);
        }



    }

    @Override
    public void deleteAnimalById(int id) {
        getDrivers();
        String sql = "DELETE FROM animals WHERE id -:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e);
        }

    }

    @Override
    public void deleteAllAnimals() {
        getDrivers();
        String sql = "DELETE FROM animals";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();

        } catch (Sql2oException e){
            System.out.println(e);
        }


    }
}
