package dao;

import domain.Student;
import java.util.Collection;

/**
 * INFO310
 * StaffInterface.java
 * @author Hugo Baird
 */
public interface StudentInterface {
    void saveStudent(Student student);
    
    Student getStudent(String user);
    
    Collection<Student> returnStudentbySurname(String sur);
    
    Collection<Student> returnStudent();
    
    Collection<Student> returnCategoryStudent(String specifiedCategory);
    
    Collection<String> returnAvailableCategories();
    
    void deleteStudent(Student student); 
}
