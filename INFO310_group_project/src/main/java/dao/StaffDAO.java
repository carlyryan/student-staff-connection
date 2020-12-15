package dao;

import domain.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * INFO310
 * StaffDAO.java
 * 
 * Involves methods which call the H2 database to perform particular actions
 * such as saving a staff, retrieving a staff and returning all available categories.
 * 
 * @author Hugo Baird
 */
public class StaffDAO implements StaffInterface {
    
    private String staffUri = DbConnection.getDefaultConnectionUri();

    public StaffDAO() {
    }
    
    public StaffDAO(String staffUri) {
        this.staffUri = staffUri;
    }
    
    
    @Override
    public void saveStaff(Staff staff) {
        
        // Prepared statement to insert a staff instance into the database
        String sql="insert into Staff (firstname, surname, username, password, email, category, searching, dateOfBirth, gender, phoneNumber, address, description) values (?,?,?,?,?,?,?,?,?,?,?,?)";

        try (      
            // Get connection to the h2 database
            Connection dbCon = DbConnection.getConnection(staffUri);

            // Create prepared statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
            // Use fields from the staff domain object into the SQL parameters
            stmt.setString(1, staff.getFirstname());
            stmt.setString(2, staff.getSurname());
            stmt.setString(3, staff.getUsername());
            stmt.setString(4, staff.getPassword());
            stmt.setString(5, staff.getEmail());
            stmt.setString(6, staff.getCategory());
            stmt.setBoolean(7, staff.isSearching());
            stmt.setString(8, staff.getDateOfBirth());
            stmt.setString(9, staff.getGender());
            stmt.setString(10, staff.getPhoneNumber());
            stmt.setString(11, staff.getAddress());
            stmt.setString(12, staff.getDescription());
           

            
            stmt.executeUpdate();

        } catch (SQLException ex) {  
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Staff getStaffbyUsername(String user) {
        
        // Prepared statement to get a staff member from the database
        String sql = "select * from Staff where username = ?";

        try (
            // Get connection to database
            Connection connection = DbConnection.getConnection(staffUri);

            // Create prepared statement
            PreparedStatement stmt = connection.prepareStatement(sql);
        ) {      
        // Set parameter for prepared statement
        stmt.setString(1, user.toLowerCase());

        // Execute the query to the database
        ResultSet rs = stmt.executeQuery();

        // Iterates through each attribute and returns it to a staff field accordingly
        if (rs.next()) {  
            Integer staffID = rs.getInt("staffID");
            String username = rs.getString("username");
            String firstname = rs.getString("firstname");
            String surname = rs.getString("surname");
            String dateOfBirth = rs.getString("dateOfBirth"); 
            String gender = rs.getString("gender"); 
            String password = rs.getString("password");
            String email = rs.getString("email");
            String phoneNumber = rs.getString("phoneNumber"); 
            String description = rs.getString("description");
            String address = rs.getString("address"); 
            String category = rs.getString("category");
            boolean searching = rs.getBoolean("searching");
            
            return new Staff(staffID,firstname,surname,dateOfBirth,gender,username,password,email,phoneNumber,address,description, category, searching);
        } else {
            return null;
        }
        } catch (SQLException ex) { 
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Collection<Staff> returnStaffbySurname(String sur) {     
        // Prepared statement to get all staff members based on surname from the database
        String sql = "select * from Staff where surname = ?";

        try (
            // Get connection to database
            Connection dbCon = DbConnection.getConnection(staffUri);

            // Create prepared statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
            // Execute query to the database
            stmt.setString(1, sur);

            // Create a list of staff members returned by the database
            List<Staff> staff = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery();

            // Iterate through each staff member returned
            while (rs.next()) {
                Integer staffID = rs.getInt("staffID");
                String username = rs.getString("username");
                String firstname = rs.getString("firstname");
                String surname = rs.getString("surname");
                String dateOfBirth = rs.getString("dateOfBirth"); 
                String gender = rs.getString("gender"); 
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber"); 
                String description = rs.getString("description");
                String address = rs.getString("address"); 
                String category = rs.getString("category");
                boolean searching = rs.getBoolean("searching");

                Staff s = new Staff(staffID,firstname,surname,dateOfBirth,gender,username,password,email,phoneNumber,address,description,category, searching);

                staff.add(s);
            }
            return staff;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Collection<Staff> returnStaff() {     
        // Prepared statement to get all staff members from the database
        String sql = "select * from Staff order by staffID";

        try (
            // Get connection to database
            Connection dbCon = DbConnection.getConnection(staffUri);

            // Create prepared statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
            // Execute query to the database
            ResultSet rs = stmt.executeQuery();

            // Create a list of staff members returned by the database
            List<Staff> staff = new ArrayList<>();

            // Iterate throug each staff member returned
            while (rs.next()) {
                Integer staffID = rs.getInt("staffID");
                String username = rs.getString("username");
                String firstname = rs.getString("firstname");
                String surname = rs.getString("surname");
                String dateOfBirth = rs.getString("dateOfBirth"); 
                String gender = rs.getString("gender"); 
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber"); 
                String description = rs.getString("description");
                String address = rs.getString("address"); 
                String category = rs.getString("category");
                boolean searching = rs.getBoolean("searching");

                Staff s = new Staff(staffID,firstname,surname,dateOfBirth,gender,username,password,email,phoneNumber,address,description,category, searching);

                staff.add(s);
            }
            return staff;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Collection<Staff> returnCategoryStaff(String specifiedCategory) {     
        // Prepared statement to get all staff members based on category from the database
        String sql = "select * from Staff where category = ?";

        try (
            // Get connection to database
            Connection dbCon = DbConnection.getConnection(staffUri);

            // Create prepared statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
            // Execute query to the database
            stmt.setString(1, specifiedCategory);

            // Create a list of staff members returned by the database
            List<Staff> staff = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery();

            // Iterate through each staff member returned
            while (rs.next()) {
                Integer staffID = rs.getInt("staffID");
                String username = rs.getString("username");
                String firstname = rs.getString("firstname");
                String surname = rs.getString("surname");
                String dateOfBirth = rs.getString("dateOfBirth"); 
                String gender = rs.getString("gender"); 
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String description = rs.getString("description");
                String address = rs.getString("address"); 
                String category = rs.getString("category");
                boolean searching = rs.getBoolean("searching");

                Staff s = new Staff(staffID,firstname,surname,dateOfBirth,gender,username,password,email,phoneNumber,address,description,category, searching);

                staff.add(s);
            }
            return staff;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    
    @Override
    public Collection<String> returnAvailableCategories() {
        String sql = "select distinct category from Staff";

        try (
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(staffUri);

            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
            // execute the query
            ResultSet rs = stmt.executeQuery();

            // Using a List to preserve the order in which the data was returned from the query.
            Collection<String> categories = new ArrayList<>();

            // iterate through the query results
            while (rs.next()) {

                // get the data out of the query
                String Category = rs.getString("category");
        
                // and put it in the collection
                categories.add(Category);
            }
            return categories;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }     
    }
    
    @Override
    public void deleteStaff(Staff staff) {
        String sql = "delete from Student where studentID=?"; 
        
        try(
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(staffUri);

            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
             ){
            
            stmt.setInt(1, staff.getStaffID());
            stmt.executeUpdate();
            
                
        }catch (SQLException ex) {
        throw new RuntimeException(ex);
        }
    }
}
