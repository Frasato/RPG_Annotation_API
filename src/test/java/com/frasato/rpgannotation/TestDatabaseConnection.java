package com.frasato.rpgannotation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class TestDatabaseConnection {

    @Autowired
    private DataSource dataSource;

    @Test
    public void databaseConnection() throws SQLException {
        try(Connection connection = dataSource.getConnection()){

            System.out.println("Success connection on database!");

        }catch(SQLException sqlException){
            System.out.println("Error on connect: " + sqlException.getMessage());
        }
    }
}
