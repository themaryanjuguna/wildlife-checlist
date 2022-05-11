import dao.Sql2oAnimalsDao;
import dao.Sql2oLocationDao;
import dao.Sql2oRangerDao;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;
import static spark.route.HttpMethod.get;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";
        Sql2o sql2o = new Sql2o(connectionString, "maryanne", "myPassword");
        Sql2oRangerDao RangerDao  = new Sql2oRangerDao(sql2o);
        Sql2oLocationDao LocationDao  = new Sql2oLocationDao(sql2o);
        Sql2oAnimalsDao AnimalDao  = new Sql2oAnimalsDao(sql2o);


        get("/", (request, response) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
