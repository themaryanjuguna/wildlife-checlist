import dao.Sql2oAnimalsDao;
import dao.Sql2oLocationDao;
import dao.Sql2oRangerDao;
import dao.Sql2oSightingsDao;
import models.Animals;
import models.Location;
import models.Ranger;
import models.Sightings;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

   /*     Sightings first = new Sightings("animaltype", "animaltype","location","rangername");

       Animals goat = new Animals("Goat",15,"sleeping","sick","none");

       Sql2oAnimalsDao sheep = new Sql2oAnimalsDao();
       sheep.addAnimal(goat);
       sheep.deleteAnimalById(1);
        System.out.println(sheep.getAllAnimals());
        sheep.deleteAllAnimals();
        System.out.println(sheep.getAllAnimals());*/



        //Show all rangers, animals and location
        get("/", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

         post("/endangered/new", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("name");
            String animalType = request.queryParams("risk");
            String animalAge = request.queryParams("age");
            String animalBehaviour = request.queryParams("behaviour");
            String animalHealth = request.queryParams("health");
            String rangerName = request.queryParams("rangername");
            String location = request.queryParams("location");

            Animals goat = new Animals(animalName, animalAge, animalBehaviour, animalHealth, animalType );
            Sql2oAnimalsDao hen = new Sql2oAnimalsDao();
            hen.addAnimal(goat);
            Sightings first = new Sightings(animalName, animalType, location, rangerName);
            Sql2oSightingsDao sql2oSightingsDao = new Sql2oSightingsDao();
            sql2oSightingsDao.addSightings(first);

             List<Sightings> allSightings = sql2oSightingsDao.getAllSightings();
             model.put("sightings", allSightings);

             return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());


        get("/animals", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings", (request, response) ->{
            Map<String, Object> model = new HashMap<>();

            Sql2oSightingsDao sql2oSightingsDao = new Sql2oSightingsDao();
            List<Sightings> allSightings = sql2oSightingsDao.getAllSightings();
            model.put("sightings", allSightings);

            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/about", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "about.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
