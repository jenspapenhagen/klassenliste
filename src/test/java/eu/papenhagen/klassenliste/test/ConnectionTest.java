/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author jay
 */
public class ConnectionTest {

    
    /**
     * Ping the Database for fast test
     *
     * @return true on connection was okay, can return
     */
    public boolean pingDb() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/db_database?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";
        try {
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection con = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!!!");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    @Test
    public void testPingDb() {
        
        assertThat(pingDb()).as("Connect to the Database").isTrue();
    }

}
