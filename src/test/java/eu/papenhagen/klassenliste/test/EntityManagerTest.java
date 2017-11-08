/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.test;

import eu.papenhagen.klassenliste.EntityManager;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author jay
 */
public class EntityManagerTest {
    
    private EntityManager em = new EntityManager();

    @Test
    public void testPingDb() {
        
        assertThat(em.pingDb()).as("Connect to the Database").isTrue();
    }

}
