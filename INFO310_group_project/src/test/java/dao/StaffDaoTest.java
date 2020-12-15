package dao;

/**
 * StaffDaoTest.java
 * @author cedricstephani
 */

import domain.Staff;
import java.util.Collection;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class StaffDaoTest {
    //private final StaffDAO staffDao = new StaffDAO(); 
    StaffInterface staffDao = new StaffDAO(
        "jdbc:h2:mem:tests;INIT=runscript from 'src/main/resources/schema.sql'");  
    
    private Staff staff1; 
    private Staff staff2;
    private Staff staff3;
    
    @Before
    public void setUp() {  
       this.staff1 = new Staff(01,"staff","one","19/12/1998","male","staff1","password","staff1@gmail.com","02102677801","1 address street","a description of staff 1","computer science",true); 
       this.staff2 = new Staff(02,"staff","two","15/2/1998","male","staff2","password","staff2@gmail.com","02102677802","2 address street","a description of staff 2","information science",true);
       this.staff3 = new Staff(03,"staff","three","5/08/1998","female","staff3","password","staff1@gmail.com","02102677803","3 address street","a description of staff 3","genetic science",false);
       
       staffDao.saveStaff(staff1);
       staffDao.saveStaff(staff2);
    }
    
    @After
    public void tearDown() {
       staffDao.deleteStaff(staff1);
       staffDao.deleteStaff(staff2);
       staffDao.deleteStaff(staff3);
    }
    
    @Test
    public void testSaveStudent() {
       staffDao.saveStaff(staff3);
       
       assertTrue("Ensure that the staff member was saved", staffDao.returnStaff().contains(staff3));
    }
    
    @Test
    public void testReturnStaff() {
       Collection<Staff> staff = staffDao.returnStaff();
       
       assertTrue("staff1 should exist", staff.contains(staff1)); 
       assertTrue("staff2 should exist", staff.contains(staff2)); 
       
       assertEquals("Only 2 staff members in result", 2, staff.size());
        
    }

    @Test
    public void testDeleteStaff() {
        assertTrue("Ensure that the student exists", staffDao.returnStaff().contains(staff3));    
        staffDao.deleteStaff(staff3);
        assertFalse("Ensure that the student doesnt exist", staffDao.returnStaff().contains(staff3)); 
    }   
}