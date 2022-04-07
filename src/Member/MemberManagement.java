/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Member;

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
public class MemberManagement {
    public static ArrayList<Member> memberList(){
        String stm = "select Library_ID, ID_Card_Num, First_Name, Last_Name, `Gender(M/F)`, DOB, Phone, Email, Address, \n" +
        "Registration_Date from Member";
        ArrayList<Member> memberList = new ArrayList<>();
        Member member;
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                member = new Member(rs.getInt("Library_ID"), rs.getString("ID_Card_Num"), rs.getString("First_Name"), rs.getString("Last_Name"), rs.getString("Gender(M/F)"), rs.getString("DOB")
                , rs.getString("Phone"), rs.getString("Email"), rs.getString("Address"), rs.getString("Registration_Date"));
                memberList.add(member);
            }
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        return memberList;
    }
    
    public static void addMember(String idCardNum, String firstName, String lastName, String gender, String DOB, String Phone, String Email, String Address, String regDate){
        String stm = "insert into Member(ID_Card_Num, First_Name, Last_Name, `Gender(M/F)`, DOB, Phone, Email, Address, Registration_Date) "
                + "value(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, idCardNum);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, gender);
            ps.setString(5, DOB);
            ps.setString(6, Phone);
            ps.setString(7, Email);
            ps.setString(8, Address);
            ps.setString(9, regDate);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "New member added!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void removeMember(int libID){
        String stm = "Delete from Member where Library_ID = ?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setInt(1, libID);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Member "+"\""+libID+"\""+" successfully removed!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void editMember(int libID, String idCardNum, String gender, String DOB, String phone, String email, String address){
        String stm = "Update Member set ID_Card_Num = ?, `Gender(M/F)` = ?, DOB = ?, Phone = ?, Email = ?, Address = ? "
                + "where Library_ID = ?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, idCardNum);
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
