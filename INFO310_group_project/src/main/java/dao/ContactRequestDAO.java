package dao;

import domain.ContactRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ContactRequestDAO.java
 * @author leon
 */
public class ContactRequestDAO implements ContactRequestInterface {

    private String contactRequestURI = DbConnection.getDefaultConnectionUri();

    // Base constructor
    public ContactRequestDAO() {
    }

    public ContactRequestDAO(String uri) {
        this.contactRequestURI = uri;
    }
    
    @Override
    public String removeRequest(String requestID) {
        String sql = "delete from ContactRequest where contactrequestid = ?";
        try (
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(contactRequestURI);
            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
            stmt.setString(1, requestID); 
            stmt.executeUpdate(); 
            return "Deleted Successfully.";

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }     
    }

    @Override
    public void saveContactRequest(ContactRequest cr) {
        String sql = "insert into ContactRequest (studentid, staffid, studentFirstname, studentLastname, staffFirstname, staffLastname, message, staffemail, studentemail, staffphonenumber, studentphonenumber, studenttoprofessor) values (?,?,?,?,?,?,?,?,?,?,?,?)";

        try (
                Connection dbCon = DbConnection.getConnection(contactRequestURI);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
            ) {
            stmt.setInt(1, cr.getStudentID());
            stmt.setInt(2, cr.getStaffID());
            stmt.setString(3, cr.getStudentFirstname());
            stmt.setString(4, cr.getStudentLastname());
            stmt.setString(5, cr.getStaffFirstname());
            stmt.setString(6, cr.getStaffLastname());
            stmt.setString(7, cr.getMessage());
            stmt.setString(8, cr.getStaffEmail());
            stmt.setString(9, cr.getStudentEmail());
            stmt.setString(10, cr.getStaffPhonenumber());
            stmt.setString(11, cr.getStudentPhonenumber());
            stmt.setBoolean(12, cr.isStudentToStaff());
            
            stmt.executeUpdate();
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Collection<ContactRequest> getRequestByStaffID(String staffID){
        String sql = "select * from ContactRequest where staffID = ? and studenttoprofessor = true";
        
        try(
            Connection dbCon = DbConnection.getConnection(contactRequestURI);
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ){
            Integer id = Integer.parseInt(staffID);
            stmt.setInt(1, id);
            
            List<ContactRequest> requests = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery();
            
            // If we get something back from the db
            while(rs.next()){
                Integer contactrequestid = rs.getInt("contactrequestid");
                Integer staff = rs.getInt("staffID");
                Integer student = rs.getInt("studentID");
                String studentFirstname = rs.getString("studentFirstname");
                String studentLastname = rs.getString("studentLastname");
                String staffFirstname = rs.getString("staffFirstname");
                String staffLastname = rs.getString("staffLastname");
                String message = rs.getString("Message");
                String staffEmail = rs.getString("staffEmail");
                String studentEmail = rs.getString("studentEmail");
                String staffPhonenumber = rs.getString("staffPhonenumber");
                String studentPhonenumber = rs.getString("studentPhonenumber");
                boolean studToStaffBool = rs.getBoolean("studenttoprofessor");
                
                ContactRequest cr = new ContactRequest(contactrequestid, staff, student, studentFirstname, studentLastname, staffFirstname, staffLastname, message, staffEmail, studentEmail, staffPhonenumber, studentPhonenumber, studToStaffBool);
                requests.add(cr);
            }
            return requests;
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Collection<ContactRequest> getRequestByStudentID(String studentID){
        String sql = "select * from ContactRequest where studentID = ? and studenttoprofessor = false";
        
        
        try(
            Connection dbCon = DbConnection.getConnection(contactRequestURI);
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ){
            Integer id = Integer.parseInt(studentID);
            stmt.setInt(1, id);
            
            List<ContactRequest> requests = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery();
            
            // If we get something back from the db
            while(rs.next()){
                Integer contactrequestid = rs.getInt("contactrequestid");
                Integer staff = rs.getInt("staffID");
                Integer student = rs.getInt("studentID");
                String studentFirstname = rs.getString("studentFirstname");
                String studentLastname = rs.getString("studentLastname");
                String staffFirstname = rs.getString("staffFirstname");
                String staffLastname = rs.getString("staffLastname");
                String message = rs.getString("Message");
                String staffEmail = rs.getString("staffEmail");
                String studentEmail = rs.getString("studentEmail");
                String staffPhonenumber = rs.getString("staffPhonenumber");
                String studentPhonenumber = rs.getString("studentPhonenumber");
                boolean studToStaffBool = rs.getBoolean("studenttoprofessor");           
                       
                ContactRequest cr = new ContactRequest(contactrequestid, staff, student, studentFirstname, studentLastname, staffFirstname, staffLastname, message, staffEmail, studentEmail, staffPhonenumber, studentPhonenumber, studToStaffBool);
                requests.add(cr);
            }
            return requests;
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }
    }
}
