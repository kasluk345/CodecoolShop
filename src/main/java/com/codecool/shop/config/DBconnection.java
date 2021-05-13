package com.codecool.shop.config;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
import org.postgresql.ds.PGSimpleDataSource;
import java.util.HashMap;


public class DBconnection {

    private final HashMap<String, String> DBcredentials = new HashMap<>();

    public DBconnection() throws SQLException {
        DataSource dataSource = connect();
    }

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        System.out.println("Read DB credentials...");
        readDataDB();

        String dbName = DBcredentials.get("dbName");
        String user = DBcredentials.get("user");
        String password = DBcredentials.get("password");

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        System.out.println("Trying to connect");
        dataSource.getConnection().close();
        System.out.println("Connection ok.");

        return dataSource;
    }

    private void readDataDB() {

        try {
            String shortPath = "src/main/resources/connection.properties";
            //String shortPath = "src/main/resources/DB-credentials.txt";
            File file = new File(shortPath);
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                String[] data = sc.nextLine().split(":");
                DBcredentials.put(data[0], data[1]);
            }
            System.out.println("Successfully read DB data from the file");
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error - File Not Found");
        }
    }
}
