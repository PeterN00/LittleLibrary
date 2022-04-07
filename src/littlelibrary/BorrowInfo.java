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
public class BorrowInfo {
    private int BorrowID;
    private String BorrowedISBN;
    private int MemberLibID;
    private String BorrowDate;
    private String DueDate;
    private String ReturnDate;
    private float Deposit;
    private String Status;
    
    public BorrowInfo() {
    }
    
    public BorrowInfo(int BorrowID, String BorrowedISBN, int MemberLibID, String BorrowDate, String DueDate, String ReturnDate, float Deposit) {
        this.BorrowID = BorrowID;
        this.BorrowedISBN = BorrowedISBN;
        this.MemberLibID = MemberLibID;
        this.BorrowDate = BorrowDate;
        this.DueDate = DueDate;
        this.ReturnDate = ReturnDate;
        this.Deposit = Deposit;
    }

    public int getBorrowID(){
        return BorrowID;
    }
    
    public void setBorrowID(int BorrowID){
        this.BorrowID = BorrowID;
    }
    
    public String getBorrowedISBN() {
        return BorrowedISBN;
    }

    public void setBorrowedISBN(String BorrowedISBN) {
        this.BorrowedISBN = BorrowedISBN;
    }

    public int getMemberLibID() {
        return MemberLibID;
    }

    public void setMemberLibID(int MemberLibID) {
        this.MemberLibID = MemberLibID;
    }

    public String getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(String BorrowDate) {
        this.BorrowDate = BorrowDate;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String DueDate) {
        this.DueDate = DueDate;
    }
    
    public String getReturnDate(){
        if(this.ReturnDate==null)
            return "";
        return ReturnDate;
    }
    
    public void setReturnDate(String ReturnDate){
        this.ReturnDate = ReturnDate;
    }
    
    public float getDeposit() {
        return Deposit;
    }

    public void setDeposit(float Deposit) {
        this.Deposit = Deposit;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
}
