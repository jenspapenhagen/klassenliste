/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste;

import eu.papenhagen.klassenliste.entity.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.LoggerFactory;

/**
 * Querry the full table
 *
 * @author jay
 */
public class EntityManager {

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(EntityManager.class);

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
            LOG.error(ex.getMessage());
        }

        return false;
    }

 

   
}
