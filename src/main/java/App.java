import dao.*;
import models.*;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


       //Show all rangers, animals and location
        // Form is filled in the front page and displayed in the sightings menu
      get("/", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/endangeredanimal", (request, response) ->{
            Map<String, Object> model = new HashMap<>();

            String animalName = request.queryParams("name");
            String animalType = request.queryParams("risk");
            String animalAge = request.queryParams("age");
            String animalBehaviour = request.queryParams("behaviour");
            String animalHealth = request.queryParams("health");
            String rangerName = request.queryParams("rangerName");
            String location = request.queryParams("location");
            String radioTelephoneFrequency = request.queryParams("radioTelephoneFrequency");
            int badgeNumber = Integer.parseInt(request.queryParams("badgeNumber"));

            //calling Sql2oAnimalsDao to display its methods
            Animals lion = new Animals(animalName, animalAge, animalBehaviour, animalHealth, animalType );
            Sql2oAnimalsDao cheetah = new Sql2oAnimalsDao();
            cheetah.addAnimal(lion);

             //calling Sql2oSightingsDao display its methods
            Sightings first = new Sightings(animalname, animaltype, location, rangername);
            Sql2oSightingsDao sql2oSightingsDao = new Sql2oSightingsDao();
            sql2oSightingsDao.addSightings(first);

           //calling Sql2oRangerDao to display its methods
             Ranger rodger = new Ranger(rangerName, radioTelephoneFrequency, badgeNumber);
             Sql2oRangerDao sql2oRangerDao = new Sql2oRangerDao();
             sql2oRangerDao.addRanger(rodger);

             List<Sightings> allSightings = sql2oSightingsDao.getAllSightings();
             model.put("sightings", allSightings);

             return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());



         //new sightings with ranger information
        post("/normalanimal", (request, response) ->{
            Map<String, Object> model = new HashMap<>();

            String animalName = request.queryParams("name");
            String animalType = request.queryParams("risk");
            String rangerName = request.queryParams("rangerName");
            String location = request.queryParams("location");
            int badgeNumber =  Integer.parseInt(request.queryParams("badgeNumber"));
            String radiotelephone = request.queryParams("radiotelephone");

            System.out.println(badgeNumber);

            NormalAnimal lion = new NormalAnimal(animalName, animalType);
            Sql2oNormalAnimalDao cheetah = new Sql2oNormalAnimalDao();
            cheetah.addNormalAnimal(lion);

            Sightings first = new Sightings(animalname, animatype, location, rangername);
            Sql2oSightingsDao sql2oSightingsDao = new Sql2oSightingsDao();
            sql2oSightingsDao.addSightings(first);

            Ranger oscar = new Ranger(rangerName, radiotelephone, badgeNumber);
            Sql2oRangerDao sql2oRangerDao = new Sql2oRangerDao();
            sql2oRangerDao.addRanger(oscar);


            List<Sightings> allSightings = sql2oSightingsDao.getAllSightings();
            model.put("sightings", allSightings);

            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());




        get("/about", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get all rangers
        get("/rangers", (request, response) ->{
            Map<String, Object> model = new HashMap<>();

            Sql2oRangerDao mike = new Sql2oRangerDao();

            List<Ranger> rangers = mike.getAllRangers();
            model.put("rangers", rangers);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //get all sightings
        get("/sightings", (request, response) ->{
            Map<String, Object> model = new HashMap<>();

            Sql2oSightingsDao sql2oSightingsDao = new Sql2oSightingsDao();
            List<Sightings> allSightings = sql2oSightingsDao.getAllSightings();
            model.put("sightings", allSightings);

            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        //Get all animals
        get("/animals", (request, response) ->{
            Map<String, Object> model = new HashMap<>();

            Sql2oAnimalsDao sql2oAnimalsDao = new Sql2oAnimalsDao();
            List<Animals> allRangers = sql2oAnimalsDao.getAllAnimals();
            model.put("animal", allRangers);

            Sql2oRangerDao mike = new Sql2oRangerDao();
            List<Ranger> rangers = mike.getAllRangers();
            model.put("rangers", rangers);

            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());


      /* Sql2oRangerDao mike = new Sql2oRangerDao();
        List<Ranger> rangers = mike.getAllRangers();
        System.out.println(rangers);

        Ranger tom = new Ranger("Alex", "",8);
        mike.addRanger(tom);
        Sightings first = new Sightings(animalname, animaltype, location, rangername);
        Sql2oSightingsDao sql2oSightingsDao = new Sql2oSightingsDao();
        sql2oSightingsDao.addSightings(first);*/



    }

}
