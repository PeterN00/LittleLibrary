/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlelibrary;

/**
 *
 * @author Admin
 */
public class Book {
    private String Title;
    private String Author;
    private String Category;
    private String Language;
    private int Quantity;
    private float Price;
    private String ISBN;
    private int Year;
    private String Status;
    private byte[] Image;
    public Book(String Title, String Author, String Category, String Language, int Quantity, float Price, String ISBN, int Year, String Status, byte[] Image) {
        this.Title = Title;
        this.Author = Author;
        this.Category = Category;
        this.Language = Language;
        this.Quantity = Quantity;
        this.Price = Price;
        this.ISBN = ISBN;
        this.Year = Year;
        this.Status = Status;
        this.Image = Image;
    }
    public Book(){}

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public byte[] getImage(){
        return Image;
    }
    
    public void setImage(byte[] Image){
        this.Image = Image;
    }
    
    public float getPrice(){
        return Price;
    }
    public void setPrice(float Price){
        this.Price = Price;
    }
}
