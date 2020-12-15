package domain;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 * Staff.java
 * 
 * @author cedricstephani
 */
public class Staff {
    private Integer staffID;
    
    @NotNull(message = "name must be provided.")
    @NotBlank(message = "name must be provided")
    @Length(min=2, message="name must contain at least two characters.")
    private String firstname; 
    
    @NotNull(message = "surname must be provided.")
    @NotBlank(message = "surname must be provided")
    @Length(min=2, message="surname must contain at least two characters.")
    private String surname; 
    
    @NotNull(message = "date of birth must be provided.")
    @NotBlank(message = "date of birth must be provided")
    private String dateOfBirth;
    
    @NotNull(message = "gender number must be provided.")
    @NotBlank(message = "gender number must be provided")
    private String gender;
    
    @NotNull(message = "username must be provided.")
    @NotBlank(message = "username must be provided")
    @Length(min=5, message="name must contain at least five characters.")
    private String username; 
    
    @NotNull(message = "password must be provided.")
    @NotBlank(message = "password must be provided")
    @Length(min=6, message="password must contain at least six characters.")
    private String password; 
    
    @NotNull(message = "email must be provided.")
    @NotBlank(message = "email must be provided")
    private String email; 
    
    @NotNull(message = "phone number must be provided.")
    @NotBlank(message = "phone number must be provided")
    private String phoneNumber;
    
    @NotNull(message = "address number must be provided.")
    @NotBlank(message = "address number must be provided")
    private String address; 
      
    private String description;
    private String category;
    private boolean searching; 

    public Staff(Integer staffID, String firstname, String surname, String dateOfBirth, String gender, String username, String password, String email, String phoneNumber, String address,String description, String category, boolean searching) {
        this.staffID = staffID;
        this.firstname = firstname;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.description = description; 
        this.category = category;
        this.searching = searching;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isSearching() {
        return searching;
    }

    public void setSearching(boolean searching) {
        this.searching = searching;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    @Override
    public String toString() {
        return "Staff{" + "staffID=" + staffID + ", firstname=" + firstname + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", username=" + username + ", password=" + password + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", category=" + category + ", searching=" + searching + '}';
    }

    
}
