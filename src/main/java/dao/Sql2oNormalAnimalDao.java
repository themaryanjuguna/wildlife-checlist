package dao;

import models.NormalAnimal;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNormalAnimalDao implements NormalAnimalDao {

    public List<NormalAnimal> getAllNormalAnimal() {

        try(Connection con = DB.myDb.open()) {
            return con.createQuery(" SELECT * FROM animals")
                    .executeAndFetch(NormalAnimal.class);
        }
    }

   public void addNormalAnimal(NormalAnimal normalAnimal) {

        String sql = "INSERT INTO animals(id, rangerName, radioTelephoneFrequency, avatarUrl, badgeNumber) VALUES (:id, :rangerName, :radioTelephoneFrequency, :avatarUrl, :badgeNumber)";
        try(Connection con = DB.myDb.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(normalAnimal)
                    .executeUpdate()
                    .getKey();
            normalAnimal.setId(id);
        } catch (Sql2oException e){
            System.out.println(e);
        }

    }

    public void deleteNormalAnimalById(int id){

        String sql = "DELETE FROM animals WHERE id = :id";
        try (Connection con = DB.myDb.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e);
        }

    }

    public void deleteAllNormalAnimal() {

        String sql = "DELETE FROM animals";
        try(Connection con = DB.myDb.open()){
            con.createQuery(sql)
                    .executeUpdate();

        } catch (Sql2oException e){
            System.out.println(e);
        }


    }
}
