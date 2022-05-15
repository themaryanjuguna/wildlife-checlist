package dao;

import models.Animals;
import models.Location;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

import static java.lang.Class.forName;

public class Sql2oAnimalsDao implements AnimalsDao {


    @Override
    public List<Animals> getAllAnimals() {
        try(Connection con = DB.myDb.open()) {
            return con.createQuery(" SELECT * FROM animals")
                    .executeAndFetch(Animals.class);
        }
    }

    @Override
    public List<Location> getAllLocation() {

        try(Connection con = DB.myDb.open()){
            return con.createQuery(" SELECT * FROM Location")
                    .executeAndFetch(Location.class);
        }

    }

    @Override
    public void addAnimal(Animals animals) {

        String sql = "INSERT INTO animals(name, age, behaviour, health, risk) VALUES (:name, :age, :behaviour, :health, :risk)";
        try(Connection con = DB.myDb.open()){
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
    public void deleteAnimalById(int id) {
        String sql = "DELETE FROM animals WHERE id = :id";
        try(Connection con = DB.myDb.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e);
        }

    }

    @Override
    public void deleteAllAnimals() {
        String sql = "DELETE FROM animals";
        try(Connection con = DB.myDb.open()){
            con.createQuery(sql)
                    .executeUpdate();

        } catch (Sql2oException e){
            System.out.println(e);
        }

    }
}
