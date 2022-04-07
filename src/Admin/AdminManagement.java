/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

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
public class AdminManagement {
    public static ArrayList<Admin> adminList(){
        String stm = "select Library_ID, First_Name, Last_Name, `Gender(M/F)`, DOB, Phone, Email, Address,\n" +
        "Start_Date from Admin";
        ArrayList<Admin> adminList = new ArrayList<>();
        Admin admin;
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                admin = new Admin(rs.getInt("Library_ID"), rs.getString("First_Name"), rs.getString("Last_Name"), rs.getString("Gender(M/F)"), rs.getString("DOB")
                , rs.getString("Phone"), rs.getString("Email"), rs.getString("Address"), rs.getString("Start_Date"));
                adminList.add(admin);
            }
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        return adminList;
    }
    
    public static void addAdmin(String firstName, String lastName, String DOB, String gender, String Phone, String Email, String Address, String startDate){
        String stm = "insert into Admin(First_Name, Last_Name, DOB, `Gender(M/F)`, Phone, Email, Address, Start_Date) "
                + "value(?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, DOB);
            ps.setString(4, gender);
            ps.setString(5, Phone);
            ps.setString(6, Email);
            ps.setString(7, Address);
            ps.setString(8, startDate);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "New admin added!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void removeAdmin(int libID){
        String stm = "Delete from Admin where Library_ID = ?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setInt(1, libID);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Admin "+"\""+libID+"\""+" successfully removed!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void editAdmin(int libID, String gender, String DOB, String phone, String email, String address){
        String stm = "Update Admin set `Gender(M/F)` = ?, DOB = ?, Phone = ?, Email = ?, Address = ? "
                + "where Library_ID = ?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, gender);
            ps.setString(2, DOB);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.setInt(6, libID);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "New changes saved successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
}
