/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlelibrary;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class BookManagement {
    public static ArrayList<Book> bookList(){
        String stm = "select A.ISBN, A.Title, A.Language,A.`Price (VND)`,A.Quantity,A.Published_Year,A.Status,A.Image, B.Author, C.Category \n" +
        "from Book A \n" +
        "left join \n" +
        "(select B.ISBN, GROUP_CONCAT(concat(B.Author) SEPARATOR ', ') \n" +
        "as Author from bookauthor B group by B.ISBN) B on A.ISBN=B.ISBN \n" +
        "left JOIN \n" +
        "(select B1.ISBN, GROUP_CONCAT(B2.Category SEPARATOR ', ') \n" +
        "as Category from bookcategory B1, category B2 where B1.ID=B2.ID group by B1.ISBN) C on A.ISBN=C.ISBN "
                + "order by A.Title asc";
        ArrayList<Book> booklist = new ArrayList<>();
        Book book;
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                book = new Book(rs.getString("Title"), rs.getString("Author"), rs.getString("Category"), rs.getString("Language")
                , rs.getInt("Quantity"), rs.getFloat("Price (VND)"), rs.getString("ISBN"), rs.getInt("Published_Year"), rs.getString("Status"), rs.getBytes("Image"));
                booklist.add(book);
            }
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        return booklist;
    }
    
    public static List<String> categoryList(){
        String stm = "select Category from Category";
        List<String> categoryList = new ArrayList();
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                categoryList.add(rs.getString("Category"));
            }
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        return categoryList;
    }
    
    public static void addCategory(String Category){
        String stm = "Insert into Category(category) value(?)";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, Category);
            ps.executeUpdate();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void removeCategory(String Category){
        String stm = "Delete from Category where Category = ?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, Category);
            ps.executeUpdate();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void deleteBookCategory(String ISBN){
        String stm = "Delete from BookCategory where ISBN = ?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, ISBN);
            ps.executeUpdate();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void addBookCategory(String ISBN, String[] Category){
        String stm = "Insert into BookCategory(ISBN, ID) "
                + "value(?, (select ID from Category where Category = ?))";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            for(int i=0; i<Category.length; i++){
                ps.setString(1, ISBN);
                ps.setString(2, Category[i]);
                ps.executeUpdate();
            }
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void deleteBookAuthor(String ISBN){
        String stm = "Delete from BookAuthor where ISBN = ?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, ISBN);
            ps.executeUpdate();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void addBookAuthor(String ISBN, String[] Author){
        String stm = "Insert into BookAuthor(ISBN, Author) value(?, ?)";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            for(int i=0; i<Author.length; i++){
                ps.setString(1, ISBN);
                ps.setString(2, Author[i]);
                ps.executeUpdate();
            }
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void addBook(String ISBN, String Title, String Language, int Quantity, float Price, int Year, String Status){
        String stm = "Insert into Book(ISBN, Title, Language, Quantity, `Price (VND)`, Published_year, Status)"
                + "value(?, ?, ?, ?, ?, ?, ?)";
        
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, ISBN);
            ps.setString(2, Title);
            ps.setString(3, Language);
            ps.setInt(4, Quantity);
            ps.setFloat(5, Price);
            ps.setInt(6, Year);
            ps.setString(7, Status);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "New book added successfully!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void removeBook(String ISBN){
        String stm = "Delete from Book where ISBN=?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, ISBN);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "\""+ISBN+"\""+" removed successful!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
     
    public static void changeCover(String ISBN, byte[] Image){
        String stm ="update Book set Image=? where ISBN=?";
        
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setBytes(1, Image);
            ps.setString(2, ISBN);
            ps.executeUpdate();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void editISBN(String ISBN, String newISBN){
        String stm = "update Book set ISBN = ? where ISBN = ?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, newISBN);
            ps.setString(2, ISBN);
            ps.executeUpdate();
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void editBook(String ISBN, String Title, String Language, int Quantity, float Price, int Year, String Status){
        String stm = "update Book set Title=?, Language=?, Quantity=?, `Price (VND)`=?, Published_Year=?, Status=?"
                + "where ISBN=?";
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(stm);
            ps.setString(1, Title);
            ps.setString(2, Language);
            ps.setInt(3, Quantity);
            ps.setFloat(4, Price);
            ps.setInt(5, Year);
            ps.setString(6, Status);
            ps.setString(7, ISBN);
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Changes saved successful!", "Information!", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
}
