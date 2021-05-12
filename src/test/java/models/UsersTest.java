package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void instantiatesUserObjectsCorrectly_true() throws Exception {
        Users users = newUser();
        assertTrue(users instanceof Users);
    }

    @Test
    public void userNameReturnsCorrectly_String() throws Exception {
        Users users = newUser();
        assertEquals("Joy", users.getName());
    }

    @Test
    public void userDepartmentReturnsCorrectly_String() throws Exception {
        Users users = newUser();
        assertEquals("IT", users.getDepartment());
    }

    @Test
    public void userRoleReturnsCorrectly_String() throws Exception {
        Users users = newUser();
        assertEquals("Support", users.getRole());
    }

    @Test
    public void setUserIdSetsCorrectly_int() throws Exception {
        Users users = newUser();
        users.setId(2);
        assertNotEquals(1, users.getId());
    }

    @Test
    public void setNameSetsCorrectUserName_String() throws Exception {
        Users users = newUser();
        users.setName("Ian");
        assertNotEquals("Joy", users.getName());
    }

    @Test
    public void setDepartmentSetsCorrectDepartment_String() throws Exception {
        Users users = newUser();
        users.setDepartment("Finance");
        assertNotEquals("IT", users.getDepartment());
    }

    @Test
    public void setRoleSetsCorrectRole_String() throws Exception {
        Users users = newUser();
        users.setRole("Balancing ledger accounts");
        assertNotEquals("Support", users.getRole());
    }

    private Users newUser() {
        return new Users("Joy", "IT", "Support");
    }
}