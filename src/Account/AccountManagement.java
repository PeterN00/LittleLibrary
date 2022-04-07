/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import littlelibrary.DBConnection;

/**
 *
 * @author Admin
 */
public class AccountManagement {
    public static ArrayList<Account> accountList(){
        String stm = "SELECT Library_ID, Password, Account_Status from Admin \n" +
        "UNION\n" +
        "(select Library_ID, Password, Account_Status from staff )\n" +
        " union \n" +
        " (select Library_ID, Password, Account_Status from member )";
        ArrayList<Account> accountList = new ArrayList<>();
        Account account;
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                account = new Account(rs.getInt("Library_ID"), rs.getString("Password"), rs.getString("Account_Status"));
                accountList.add(account);
            }
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        return accountList;
    }
    
    public static int checkExistAccount(String libID){
        ArrayList<Account> accountList = accountList();
        for(int i=0;i<accountList.size();i++){
            if(libID.equals(String.valueOf(accountList.get(i).getLibID())))
                return 1; //Account does exist
        }
        return 0;
    }
    
    public static void setAccount(String libID, String password, String status){
        String role = "";
        int ID = Integer.parseInt(libID);
        ArrayList<Account> accountList = accountList();
        for(Account acc : accountList){
            if(acc.getLibID() == ID){
                role = acc.getRole();
                break;
            }
        }
        String stm = "update "+role+" set `Password` = ?, Account_Status = ? where Library_ID = ?";
        
        if(!role.isEmpty()){
            try{
                Connection con = DBConnection.getCon();
                PreparedStatement ps = con.prepareStatement(stm);
                ps.setString(1, password);
                ps.setString(2, status);
                ps.setInt(3, ID);
                ps.executeUpdate();
                con.close();
                JOptionPane.showMessageDialog(null, "Account information saved successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
