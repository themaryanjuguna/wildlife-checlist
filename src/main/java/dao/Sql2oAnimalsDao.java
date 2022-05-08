package dao;

import models.Animals;
import models.Location;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static com.google.common.net.HttpHeaders.FROM;
import static java.lang.Class.forName;
import static org.h2.command.CommandInterface.SELECT;

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

    }

    @Override
    public void findAnimalByName(String name) {

    }

    @Override
    public void findAnimalByRisk(String risk) {

    }

    @Override
    public void findAnimalByHealth(String health) {

    }

    @Override
    public void findAnimalByAge(int age) {

    }

    @Override
    public void deleteAnimalById(int id) {

    }

    @Override
    public void deleteAllAnimals() {

    }
}
