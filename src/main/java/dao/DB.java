package dao;

import org.sql2o.Sql2o;

public class DB {
    public static Sql2o myDb = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker","postgres","m");
}
