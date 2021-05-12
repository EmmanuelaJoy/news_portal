package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void instantiatesDepartmentObjectsCorrectly_true() throws Exception {
        Departments departments = newDepartment();
        assertTrue(departments instanceof Departments);
    }

    @Test
    public void departmentNameReturnsCorrectly_String() throws Exception {
        Departments departments = newDepartment();
        assertEquals("Sales and Marketing", departments.getName());
    }

    @Test
    public void departmentDescriptionReturnsCorrectly_String() throws Exception {
        Departments departments =newDepartment();
        assertEquals("Handles marketing of the company", departments.getDescription());
    }

    @Test
    public void departmentEmployeesReturnsCorrectly_String() throws Exception {
        Departments departments = newDepartment();
        assertEquals("Emmanuela,Ian,Stacy", departments.getEmployees());
    }

    @Test
    public void setDepartmentNameSetsCorrectly_String() throws Exception {
        Departments departments = newDepartment();
        departments.setName("Front office");
        assertNotEquals("Sales and Marketing", departments.getName());
    }

    @Test
    public void setDepartmentDescriptionSetsCorrectly_String() throws Exception {
        Departments departments = newDepartment();
        departments.setDescription("Attends to clients");
        assertNotEquals("Handles marketing of the company", departments.getDescription());
    }

    @Test
    public void setEmployeesSetsCorrectly_String() throws Exception {
        Departments departments = newDepartment();
        departments.setEmployees("Kevin,Douglas");
        assertNotEquals("Emmanuela,Ian,Stacy", departments.getEmployees());
    }

    private Departments newDepartment() {
        return new Departments("Sales and Marketing", "Handles marketing of the company", "Emmanuela,Ian,Stacy");
    }
}