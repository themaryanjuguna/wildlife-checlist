import dao.Sql2oAnimalsDao;
import dao.Sql2oLocationDao;
import dao.Sql2oRangerDao;
import models.Animals;
import models.Location;
import models.Ranger;
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

        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "m");
        Sql2oRangerDao RangerDao  = new Sql2oRangerDao(sql2o);
        Sql2oLocationDao LocationDao  = new Sql2oLocationDao(sql2o);
        Sql2oAnimalsDao AnimalsDao  = new Sql2oAnimalsDao(sql2o);

        //Show all rangers, animals and location
        get("/", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            List<Ranger>allranger = RangerDao.getAllRangers();
            List<Location>alllocation = LocationDao.getAllLocations();
            List<Animals>allanimals = AnimalsDao.getAllAnimals();

            model.put("ranger", allranger);
            model.put("location", alllocation);
            model.put("animals", allanimals);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

          //Display form to add content
     /*   get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animals> animals = AnimalsDao.getAllAnimals();
            model.put("animals", animals);
            return  new ModelAndView(model, "new-animal.hbs");
        }, new HandlebarsTemplateEngine());*/


        post("/animals/new", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());


        get("/animals", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/about", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "about.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
