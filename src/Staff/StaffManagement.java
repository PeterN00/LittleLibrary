/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import littlelibrary.DBConnection;

/**
 *
 * @author Admin
 */
public class StaffManagement {
    public static ArrayList<Staff> staffList(){
        String stm = "select Library_ID, First_Name, Last_Name, Position, `Gender(M/F)`, DOB, Phone, Email, Address, \n" +
        "Start_Date from Staff";
        ArrayList<Staff> staffList = new ArrayList<>();
        Staff staff;
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                staff = new Staff(rs.getInt("Library_ID"), rs.getString("First_Name"), rs.getString("Last_Name"), rs.getString("Position"), rs.getString("Gender(M/F)"), rs.getString("DOB")
                , rs.getString("Phone"), rs.getString("Email"), rs.getString("Address"), rs.getString("Start_Date"));
                staffList.add(staff);
            }
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        return staffList;
    }
    
    public static void addStaff(String firstName, String lastName, String Position, String DOB, String gender, String Phone, String Email, String Address, String startDate){
        String stm = "insert into Staff(First_Name, Last_Name, Position, DOB, `Gender(M/F)`, Phone, Email, Address, Start_Date) "
                + "value(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, Position);
            ps.setString(4, DOB);
            ps.setString(5, gender);
            ps.setString(6, Phone);
            ps.setString(7, Email);
            ps.setString(8, Address);
            ps.setString(9, startDate);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "New staff added!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void removeStaff(int libID){
        String stm = "Delete from Staff where Library_ID = ?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setInt(1, libID);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Staff "+"\""+libID+"\""+" successfully removed!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void editStaff(int libID, String position, String gender, String DOB, String phone, String email, String address){
        String stm = "Update Staff set Position = ?, `Gender(M/F)` = ?, DOB = ?, Phone = ?, Email = ?, Address = ? "
                + "where Library_ID = ?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, position);
            ps.setString(2, gender);
            ps.setString(3, DOB);
            ps.setString(4, phone);
            ps.setString(5, email);
            ps.setString(6, address);
            ps.setInt(7, libID);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "New changes saved successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
}
