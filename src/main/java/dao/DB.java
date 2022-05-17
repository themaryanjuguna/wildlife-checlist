package dao;

import org.sql2o.Sql2o;

public class DB {
    //public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker","postgres","m");

    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-3-224-164-189.compute-1.amazonaws.com:5432/ddmncurtp843q5", "sfxxrgckkcrsau", "1b1177e6fab1dddd8161c21fb6264c38a85c5f472bdba4ea60931a1f1d3d78f2");
}
