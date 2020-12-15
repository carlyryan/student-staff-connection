package dao;

/**
 * StudentDaoTest.java
 * @author cedricstephani
 */

import domain.Student;
import java.util.Collection;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class StudentDaoTest {
    //private StudentDAO studentDao = new StudentDAO();
    StudentInterface studentDao = new StudentDAO(
            "jdbc:h2:mem:tests;INIT=runscript from 'src/main/resources/schema.sql'");   
    
    private Student student1; 
    private Student student2; 
    private Student student3; 
    
    public StudentDaoTest(){
    }
    
    @Before
    public void setUp() {
       this.student1 = new Student(4322434,"student","one","19/12/1998","male","student1","password","student1@gmail.com","02102677801","1 address street","a description of student 1","computer science",true); 
       this.student2 = new Student(2342344,"student","two","15/2/1998","male","student2","password","student2@gmail.com","02102677802","2 address street","a description of student 2","information science",true);
       this.student3 = new Student(5109978,"student","three","5/08/1998","female","student3","password","student3@gmail.com","02102677803","3 address street","a description of student 3","genetic science",false);
       
       studentDao.saveStudent(student1);
       studentDao.saveStudent(student2);
    }
    
    @After
    public void tearDown() {
       studentDao.deleteStudent(student1);
       studentDao.deleteStudent(student2);
       studentDao.deleteStudent(student3);
    }
    
    @Test
    public void testSaveStudent() {
       studentDao.saveStudent(student3);
       assertTrue("Ensure that the student was saved", studentDao.returnStudent().contains(student3));
    }
    
    @Test
    public void testReturnStudents() {
       Collection<Student> students = studentDao.returnStudent();
       
       assertTrue("student1 should exist", students.contains(student1)); 
       assertTrue("student2 should exist", students.contains(student2)); 
       
       assertEquals("Only 2 students in result", 2, students.size());
    }

    @Test
    public void testDeleteStaff() {
        assertTrue("Ensure that the student exists", studentDao.returnStudent().contains(student3));    
        studentDao.deleteStudent(student3);
        assertFalse("Ensure that the student doesnt exist", studentDao.returnStudent().contains(student3)); 
    }  
}
