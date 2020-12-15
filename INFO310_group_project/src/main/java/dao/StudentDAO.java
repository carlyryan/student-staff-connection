package dao;

import domain.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * INFO310
 * StudentDAO.java
 * 
 * Involves methods which call the H2 database to perform particular actions
 * such as saving a student, retrieving a student and returning all available categories.
 * 
 * @author Hugo Baird
 */
public class StudentDAO implements StudentInterface {
    
    private String studentUri = DbConnection.getDefaultConnectionUri();

    public StudentDAO() {
    }
    
    public StudentDAO(String studentUri) {
        this.studentUri = studentUri;
    }
    
    @Override
    public void saveStudent(Student student) {
        
        // Prepared statement to insert a student instance into the database
        String sql="insert into Student (studentID, firstname, surname, username, password, email, category, searching, dateOfBirth, gender, phoneNumber, address, description) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (
            // Get connection to the h2 database
            Connection dbCon = DbConnection.getConnection(studentUri);

            // Create prepared statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
            // Use fields from the student domain object into the SQL parameters
            stmt.setInt(1, student.getStudentID());
            stmt.setString(2, student.getFirstname());
            stmt.setString(3, student.getSurname());
            stmt.setString(4, student.getUsername());
            stmt.setString(5, student.getPassword());
            stmt.setString(6, student.getEmail());
            stmt.setString(7, student.getCategory());
            stmt.setBoolean(8, student.isSearching());
            stmt.setString(9, student.getDateOfBirth());
            stmt.setString(10, student.getGender());
            stmt.setString(11, student.getPhoneNumber());
            stmt.setString(12, student.getAddress());
            stmt.setString(13, student.getDescription());
            
            stmt.executeUpdate(); 

        } catch (SQLException ex) {  
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Student getStudent(String user) {
        
        // Prepared statement to get a student from the database
        String sql = "select * from Student where username = ?";

        try (
            // Get connection to database
            Connection connection = DbConnection.getConnection(studentUri);

            // Create prepared statement
            PreparedStatement stmt = connection.prepareStatement(sql);
        ) {
            // Set parameter for prepared statement
            stmt.setString(1, user);

            // Execute the query to the database
            ResultSet rs = stmt.executeQuery();

            // Iterates through each attribute and returns it to a staff field accordingly
            if (rs.next()) {
                Integer studentID = rs.getInt("studentID");   
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

            return new Student(studentID,firstname,surname,dateOfBirth,gender,username,password,email,phoneNumber,address,description,category, searching);
        } else {
            return null;
        }
        } catch (SQLException ex) { 
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Collection<Student> returnStudentbySurname(String sur) {     
        // Prepared statement to get all students based on surname from the database
        String sql = "select * from Student where surname = ?";

        try (
            // Get connection to database
            Connection dbCon = DbConnection.getConnection(studentUri);

            // Create prepared statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
            // Execute query to the database
            stmt.setString(1, sur);

            // Create a list of students returned by the database
            List<Student> student = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery();

            // Iterate through each student returned
            while (rs.next()) {
                Integer studentID = rs.getInt("studentID");   
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

                Student s = new Student(studentID,firstname,surname,dateOfBirth,gender,username,password,email,phoneNumber,address,description, category, searching);

                student.add(s);
            }
            return student;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Collection<Student> returnStudent() {
        // Prepared statement to get all students from the database
        String sql = "select * from Student order by studentID";

        try (
            // Get connection to database
            Connection dbCon = DbConnection.getConnection(studentUri);

            // Create prepared statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
            // Execute query to the database
            ResultSet rs = stmt.executeQuery();

            // Create a list of staff members returned by the database
            List<Student> student = new ArrayList<>();

            // Iterate throug each staff member returned
            while (rs.next()) {
                Integer studentID = rs.getInt("studentID");   
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

                Student s = new Student(studentID,firstname,surname,dateOfBirth,gender,username,password,email,phoneNumber,address,description,category, searching);

                student.add(s);
            }
            return student;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Collection<Student> returnCategoryStudent(String specifiedCategory) {     
        // Prepared statement to get all students based on category from the database
        String sql = "select * from Student where category = ?";

        try (
            // Get connection to database
            Connection dbCon = DbConnection.getConnection(studentUri);

            // Create prepared statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
            // Execute query to the database
            stmt.setString(1, specifiedCategory);

            // Create a list of students returned by the database
            List<Student> student = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery();

            // Iterate through each student returned
            while (rs.next()) {
                Integer studentID = rs.getInt("studentID");   
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

                Student s = new Student(studentID,firstname,surname,dateOfBirth,gender,username,password,email,phoneNumber,address,description, category, searching);

                student.add(s);
            }
            return student;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<String> returnAvailableCategories() {
        String sql = "select distinct category from Student";

        try (
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(studentUri);

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
    public void deleteStudent(Student student) {
        String sql = "delete from Student where studentID=?"; 
        
        try(
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(studentUri);

            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
             ){
            
            stmt.setInt(1, student.getStudentID());
            stmt.executeUpdate();
            
                
        }catch (SQLException ex) {
        throw new RuntimeException(ex);
        }
    }
}
