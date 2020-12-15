package dao;

import domain.ContactRequest;
import java.util.Collection;

/**
 * ContactRequestInterface.java
 * @author leon
 */
public interface ContactRequestInterface {
    String removeRequest(String requestID);
    
    void saveContactRequest(ContactRequest cr);
    
    Collection<ContactRequest> getRequestByStaffID(String staffID);
    
    Collection<ContactRequest> getRequestByStudentID(String studentID);
}
