/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staff;

/**
 *
 * @author Admin
 */
public class Staff {
    private int LibID;
    private String FirstName;
    private String LastName;
    private String Position;
    private String Gender;
    private String DOB;
    private String Phone;
    private String Email;
    private String Address;
    private String Start_Date;
    
    public Staff() {
        
    }
    public Staff(int LibID, String FirstName, String LastName, String Position, String Gender, String DOB, String Phone, String Email, String Address, String Start_Date) {
        this.LibID = LibID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Position = Position;
        this.Gender = Gender;
        this.DOB = DOB;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.Start_Date = Start_Date;
    }

    public int getLibID() {
        return LibID;
    }

    public void setLibID(int LibID) {
        this.LibID = LibID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        if("M".equals(this.Gender))
            return "Male";
        return "Female";
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(String Start_Date) {
        this.Start_Date = Start_Date;
    }
    
}
