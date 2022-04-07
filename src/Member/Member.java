/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Member;


/**
 *
 * @author Admin
 */
public class Member {
    private int LibID;
    private String idCardNumber;
    private String FirstName;
    private String LastName;
    private String Gender;
    private String DOB;
    private String Phone;
    private String Email;
    private String Address;
    private String Reg_Date;
    
    public Member() {
    }
    
    public Member(int LibID, String idCardNumber, String FirstName, String LastName, String Gender, String DOB, String Phone, String Email, String Address, String Reg_Date) {
        this.LibID = LibID;
        this.idCardNumber = idCardNumber;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.DOB = DOB;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.Reg_Date = Reg_Date;
    }

    public int getLibID() {
        return LibID;
    }

    public void setLibID(int LibID) {
        this.LibID = LibID;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
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

    public String getGender() {
        if("M".equals(this.Gender))
            return "Male";
        return "Female";
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
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

    public String getReg_Date() {
        return Reg_Date;
    }

    public void setReg_Date(String Reg_Date) {
        this.Reg_Date = Reg_Date;
    }
    
}
