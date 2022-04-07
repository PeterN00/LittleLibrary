/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlelibrary;
import java.sql.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class BorrowInfoManagement {
    public static ArrayList<BorrowInfo> borrowInfoList(){
        String stm = "select BorrowID, BookISBN, MemberLibID, BorrowDate, DueDate, ReturnDate, Deposit from BorrowInfo";
        
        ArrayList<BorrowInfo> borrowedBookList = new ArrayList<>();
        BorrowInfo borrowedBook;
        
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                borrowedBook = new BorrowInfo(rs.getInt("BorrowID"), rs.getString("BookISBN"), rs.getInt("MemberLibID"), rs.getString("BorrowDate")
                        , rs.getString("DueDate"), rs.getString("ReturnDate"), rs.getFloat("Deposit"));
                borrowedBookList.add(borrowedBook);
            }
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        
        return borrowedBookList;
    }
    
    public static void addBorrowedBook(String ISBN, int LibID, String BorrowDate, String DueDate, float Deposit){
        String stm = "Insert into BorrowInfo(BookISBN, MemberLibID, BorrowDate, DueDate, Deposit) value(?, ?, ?, ?, ?)";
        
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, ISBN);
            ps.setInt(2, LibID);
            ps.setString(3, BorrowDate);
            ps.setString(4, DueDate);
            ps.setFloat(5, Deposit);
            ps.executeUpdate();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void returnBook(int BorrowID){
        String stm = "update BorrowedBook set ReturnDate = ? where BorrowID = ?";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String curDate = sdf.format(cal.getTime());
        
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, curDate);
            ps.setInt(2, BorrowID);
            ps.executeUpdate();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static int getLateTime(String dueDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date now = cal.getTime();
        Date due;
        long timediff = 0;
        try {
            due = sdf.parse(dueDate);
            timediff = now.getTime() - due.getTime();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        int secs = (int) timediff/1000;
        
        int totalHrs = secs/3600;
        
        return totalHrs;
    }
    
    public static String getStatus(String returnDate, String dueDate){
        String status = "";
        int lateHrs = getLateTime(dueDate);
        if(returnDate.isEmpty()){
            if(lateHrs<=0)
                status = "PENDING";
            if(lateHrs>0)
                status = "LATE";
        }
        else
            status = "RESOLVED";
        
        return status;
    }
    
    public static int getRemainingDays(String dueDate){
        int num = 1;
        int lateHrs = getLateTime(dueDate);
        
        if(lateHrs >= 0)
            return 0;
        
        while(lateHrs<=-24){
            num += 1;
            lateHrs = lateHrs + 24;
        }
        
        return num;
    }
    
    public static int getNumOfDaysLate(String dueDate){
        int num = 0;
        int lateHrs = getLateTime(dueDate);
        while(lateHrs>=24){
            num += 1;
            lateHrs = lateHrs - 24;
        }
        
        return num;
    }
    
    public static float getFine(String dueDate){
        float Fine;
        
        int numOfDaysLate = getNumOfDaysLate(dueDate);
        
        Fine = numOfDaysLate*10000;
        
        return Fine;
    }
    
    public static String displayDate(String date){
        if(date.isEmpty())
            return "-";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
        Date d;
        String str = "";
        try {
            d = sdf.parse(date);
            str = sdf2.format(d);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        
        return str;
    }
}
