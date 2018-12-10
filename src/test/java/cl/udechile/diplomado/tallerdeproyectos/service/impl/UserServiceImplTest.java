package cl.udechile.diplomado.tallerdeproyectos.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import cl.udechile.diplomado.tallerdeproyectos.model.User;

@ContextConfiguration (locations = {"classpath:user-beans.xml"})
public class UserServiceImplTest {
	
	private User user;

    @Before
    public void setUp() throws Exception {
    	user = new User();
    }

    @Test
    public void testSetAndGetUsername() {
        String testDescription = "profesor";
        
        assertNull(user.getUsername());
        user.setUsername(testDescription);
        assertEquals(testDescription, user.getUsername());
    }

    @Test
    public void testSetAndGetFirtName() {
        String testDescription = "profesor";
        
        assertNull(user.getFirstname());
        user.setFirstname(testDescription);
        assertEquals(testDescription, user.getFirstname());
    }
}