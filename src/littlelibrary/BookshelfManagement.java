/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlelibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class BookshelfManagement {
    public static ArrayList<Bookshelf> bookshelfList(){
        String stm = "select ID, Location from Bookshelf order by ID asc";
        ArrayList<Bookshelf> bookshelfList = new ArrayList();
        Bookshelf bookShelf;
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                bookShelf = new Bookshelf(rs.getString("ID"), rs.getString("Location"));
                bookshelfList.add(bookShelf);
            }
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        return bookshelfList;
    }
    
    public static List<String> getBookshelf(String location){
        List<String> bsList = new ArrayList();
        String stm = "select ID from Bookshelf where Location = ? order by ID asc";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, location);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                bsList.add(rs.getString("ID"));
            }
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        return bsList;
    }
    
    public static HashMap<String, String> getBook(String bsID){
        HashMap<String, String> bookList = new HashMap();
        String stm = "select A.BookISBN, B.Title from BookPlacement A, Book B where A.BookshelfID = ? "
                + "and A.BookISBN = B.ISBN order by B.Title asc";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, bsID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                bookList.put(rs.getString("BookISBN"), rs.getString("Title"));
            }
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        return bookList;
    }
    
    public static void addBookshelf(String ID, String location){
        String stm = "insert into Bookshelf(ID, Location) value(?, ?)";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, ID);
            ps.setString(2, location);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "\""+ID+" - "+location+"\""+" added!", "Notification!", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void removeBookshelf(String ID){
        String stm = "delete from Bookshelf where ID = ?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, ID);
            ps.executeUpdate();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void addBookToBookshelf(String bsID, String ISBN){
        String stm = "Insert into BookPlacement(BookshelfID, BookISBN) value(?, ?)";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, bsID);
            ps.setString(2, ISBN);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Added book to bookshelf: \n\n"+"ISBN: "+ISBN+"\n"+"Bookshelf ID: "+bsID);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void removeBookFromBookshelf(String bsID, String ISBN){
        String stm = "Delete from BookPlacement where BookshelfID = ? and BookISBN = ?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, bsID);
            ps.setString(2, ISBN);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Book removed from bookshelf:\n\n"+"ISBN: "+ISBN+"\n"+"Bookshelf ID: "+bsID);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
}
