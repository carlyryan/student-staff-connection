package dao;

import domain.Staff;
import java.util.Collection;

/**
 * INFO310
 * StaffInterface.java
 * @author Hugo Baird
 */
public interface StaffInterface {
    
    void saveStaff(Staff staff);
    
    Staff getStaffbyUsername(String user);
    
    Collection<Staff> returnStaffbySurname(String surname);
    
    Collection<Staff> returnStaff();
    
    Collection<Staff> returnCategoryStaff(String specifiedCategory);
    
    Collection<String> returnAvailableCategories();
    
    void deleteStaff(Staff staff);
}
