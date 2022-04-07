/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

/**
 *
 * @author Admin
 */
public class Account {
    private int LibID;
    private String Password;
    private String Status;
    private String Role;
    
    public Account() {}
    public Account(int LibID, String Password, String Status) {
        this.LibID = LibID;
        this.Password = Password;
        this.Status = Status;
    }

    public int getLibID() {
        return LibID;
    }

    public void setLibID(int LibID) {
        this.LibID = LibID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getRole() {
        if(this.LibID>=100000001 && this.LibID<200000000)
            return "Admin";
        else if(this.LibID>=200000001 && this.LibID<300000000)
            return "Staff";
        return "Member";
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
    
}
