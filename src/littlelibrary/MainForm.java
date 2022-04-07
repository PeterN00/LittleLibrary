/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlelibrary;


import Admin.EmailSendingForm;
import Account.ProfileFrame;
import Member.MemberManagement;
import Member.Member;
import Member.MemberDisplayPanel;
import Member.MemberBorrowHistoryForm;
import Admin.AdminDisplayPanel;
import Admin.AdminManagement;
import Admin.Admin;
import Staff.Staff;
import Staff.StaffDisplayPanel;
import Staff.StaffManagement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
/**
 *
 * @author Admin
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    int user_LibID;
    String user_Role;
    public MainForm(){
        initComponents();
        this.setTitle("Little Library");
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(190,218,245));
    }
    
    public final void displayDashboardInfo(){
        ArrayList<Book> bookList = BookManagement.bookList();
        ArrayList<Member> memberList = MemberManagement.memberList();
        ArrayList<Staff> staffList = StaffManagement.staffList();
        ArrayList<Admin> adminList = AdminManagement.adminList();
        ArrayList<Bookshelf> bsList = BookshelfManagement.bookshelfList();
        ArrayList<BorrowInfo> borrowList = BorrowInfoManagement.borrowInfoList();
        
        int countBook = 0;
        int countMember = 0;
        int countStaff = 0;
        int countAdmin = 0;
        int countBorrowInfo = 0;
        int countBookshelf = 0;
        
        for(Book book : bookList){
            countBook+=1;
        }
        for(Member member : memberList){
            countMember+=1;
        }
        for(Staff staff : staffList){
            countStaff+=1;
        }
        for(Admin admin : adminList){
            countAdmin+=1;
        }
        for(Bookshelf bs : bsList){
            countBookshelf+=1;
        }
        for(BorrowInfo bi : borrowList){
            countBorrowInfo+=1;
        }
        
        lbBookCount.setText("Total: "+String.valueOf(countBook));
        lbMemberCount.setText("Total: "+String.valueOf(countMember));
        lbStaffCount.setText("Total: "+String.valueOf(countStaff));
        lbAdminCount.setText("Total: "+String.valueOf(countAdmin));
        lbBSCount.setText("Total: "+String.valueOf(countBookshelf));
        lbBorrowInfoCount.setText("Total: "+String.valueOf(countBorrowInfo));
    }
    
    public void getUserLibID(String libID){
        lbWelcome.setText("Welcome, "+libID+"!");
        user_LibID = Integer.parseInt(libID);
    }
    
    public final void displayBookPanel(){
        BookDisplayPanel bdp = new BookDisplayPanel(user_Role);
        displayPanel.removeAll();
        displayPanel.add(bdp, BorderLayout.CENTER);
        displayPanel.revalidate();
        displayPanel.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        
        btDashboard.setEnabled(true);
    }
    
    public final void displayBookshelfPanel(){
        BookshelfDisplayPanel bsdp = new BookshelfDisplayPanel();
        displayPanel.removeAll();
        displayPanel.add(bsdp, BorderLayout.CENTER);
        displayPanel.revalidate();
        displayPanel.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        
        btDashboard.setEnabled(true);
    }
    
    public final void displayMemberPanel(){
        MemberDisplayPanel mdp = new MemberDisplayPanel();
        displayPanel.removeAll();
        displayPanel.add(mdp, BorderLayout.CENTER);
        displayPanel.revalidate();
        displayPanel.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        
        btDashboard.setEnabled(true);
    }
    
    public final void displayStaffPanel(){
        StaffDisplayPanel sdp = new StaffDisplayPanel();
        displayPanel.removeAll();
        displayPanel.add(sdp, BorderLayout.CENTER);
        displayPanel.revalidate();
        displayPanel.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        
        if(user_Role.equals("Staff"))
            sdp.hideButton();
        
        btDashboard.setEnabled(true);
    }
    
    public final void displayAdminPanel(){
        AdminDisplayPanel adp = new AdminDisplayPanel();
        displayPanel.removeAll();
        displayPanel.add(adp, BorderLayout.CENTER);
        displayPanel.revalidate();
        displayPanel.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        
        btDashboard.setEnabled(true);
    }
    
    public final void displayLendBookPanel(){
        LendBookPanel lbp = new LendBookPanel();
        displayPanel.removeAll();
        displayPanel.add(lbp);
        displayPanel.revalidate();
        displayPanel.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        
        btLendBook.setEnabled(false);
        if(!btDashboard.isEnabled())
            btDashboard.setEnabled(true);
    }
    
    public final void displayBorrowListPanel(){
        BorrowListPanel blp = new BorrowListPanel();
        displayPanel.removeAll();
        displayPanel.add(blp);
        displayPanel.revalidate();
        displayPanel.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        
        btDashboard.setEnabled(true);
    }
    
    public final void displayDashboardPanel(){
        displayPanel.removeAll();
        displayPanel.add(dashboardPanel);
        displayPanel.revalidate();
        displayPanel.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        
        btDashboard.setEnabled(false);
        if(!btLendBook.isEnabled())
            btLendBook.setEnabled(true);
        
        if(user_Role.equals("Staff"))
            adminPanel.setVisible(false);
        
        displayDashboardInfo();
    }
    
    public void memberBorrowHistoryButton(){
        JButton btBorrowHistory = new JButton("BORROW HISTORY");
        btBorrowHistory.setFont(new Font("Tahoma", Font.BOLD, 24));
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"/src/Images/BorrowHistory.png");
        btBorrowHistory.setIcon(icon);
        btBorrowHistory.setHorizontalTextPosition(SwingConstants.CENTER);
        btBorrowHistory.setVerticalTextPosition(SwingConstants.BOTTOM);
        
        btBorrowHistory.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MemberBorrowHistoryForm mbhf = new MemberBorrowHistoryForm(user_LibID);
                mbhf.setVisible(true);
            }
        });
        
        btBorrowHistory.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btBorrowHistory.setBackground(new Color(120,165,208));
            }
            @Override
            public void mouseExited(MouseEvent e){
                btBorrowHistory.setBackground(UIManager.getColor("control"));
            }
        });
        
        optionPanel.add(btBorrowHistory);
    }
    
    public final void displayStartMenu(String role){
        user_Role = role;
        if(role.equals("Staff"))
            btEmail.setVisible(false);
        
        if(role.equals("Staff") || role.equals("Admin"))
            displayDashboardPanel();
        
        if(role.equals("Member")){
            btDashboard.setVisible(false);
            btLendBook.setVisible(false);
            btEmail.setVisible(false);
            memberBorrowHistoryButton();
            displayBookPanel();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        labelMemberName4 = new javax.swing.JLabel();
        displayPanel = new javax.swing.JPanel();
        dashboardPanel = new javax.swing.JPanel();
        bookPanel = new javax.swing.JPanel();
        lbBookCount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        memberPanel = new javax.swing.JPanel();
        lbMemberCount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        staffPanel = new javax.swing.JPanel();
        lbStaffCount = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        adminPanel = new javax.swing.JPanel();
        lbAdminCount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bookshelfPanel = new javax.swing.JPanel();
        lbBSCount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        borrowInfoPanel = new javax.swing.JPanel();
        lbBorrowInfoCount = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        accountPanel = new javax.swing.JPanel();
        lbWelcome = new javax.swing.JLabel();
        buttonLogout = new javax.swing.JButton();
        buttonProfile = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        optionPanel = new javax.swing.JPanel();
        btDashboard = new javax.swing.JButton();
        btLendBook = new javax.swing.JButton();
        btEmail = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setText("Name:");

        labelMemberName4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Little Library");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        displayPanel.setOpaque(false);
        displayPanel.setLayout(new java.awt.BorderLayout());

        dashboardPanel.setOpaque(false);

        bookPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
        bookPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bookPanelMouseExited(evt);
            }
        });

        lbBookCount.setBackground(new java.awt.Color(0, 204, 204));
        lbBookCount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbBookCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBookCount.setText("bookCount");
        lbBookCount.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Books");
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout bookPanelLayout = new javax.swing.GroupLayout(bookPanel);
        bookPanel.setLayout(bookPanelLayout);
        bookPanelLayout.setHorizontalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBookCount, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookPanelLayout.setVerticalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookPanelLayout.createSequentialGroup()
                .addComponent(lbBookCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        memberPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
        memberPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memberPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                memberPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                memberPanelMouseExited(evt);
            }
        });

        lbMemberCount.setBackground(new java.awt.Color(0, 204, 204));
        lbMemberCount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbMemberCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMemberCount.setText("memberCount");
        lbMemberCount.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Members");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout memberPanelLayout = new javax.swing.GroupLayout(memberPanel);
        memberPanel.setLayout(memberPanelLayout);
        memberPanelLayout.setHorizontalGroup(
            memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMemberCount, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        memberPanelLayout.setVerticalGroup(
            memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memberPanelLayout.createSequentialGroup()
                .addComponent(lbMemberCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
        );

        staffPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
        staffPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                staffPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                staffPanelMouseExited(evt);
            }
        });

        lbStaffCount.setBackground(new java.awt.Color(0, 204, 204));
        lbStaffCount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbStaffCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStaffCount.setText("staffCount");
        lbStaffCount.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Staffs");
        jLabel3.setOpaque(true);

        javax.swing.GroupLayout staffPanelLayout = new javax.swing.GroupLayout(staffPanel);
        staffPanel.setLayout(staffPanelLayout);
        staffPanelLayout.setHorizontalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStaffCount, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        staffPanelLayout.setVerticalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addComponent(lbStaffCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
        );

        adminPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
        adminPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminPanelMouseExited(evt);
            }
        });

        lbAdminCount.setBackground(new java.awt.Color(0, 204, 204));
        lbAdminCount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbAdminCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAdminCount.setText("adminCount");
        lbAdminCount.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Admins");
        jLabel4.setOpaque(true);

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAdminCount, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addComponent(lbAdminCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
        );

        bookshelfPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
        bookshelfPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookshelfPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookshelfPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bookshelfPanelMouseExited(evt);
            }
        });

        lbBSCount.setBackground(new java.awt.Color(0, 204, 204));
        lbBSCount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbBSCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBSCount.setText("bsCount");
        lbBSCount.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Bookshelves");
        jLabel5.setOpaque(true);

        javax.swing.GroupLayout bookshelfPanelLayout = new javax.swing.GroupLayout(bookshelfPanel);
        bookshelfPanel.setLayout(bookshelfPanelLayout);
        bookshelfPanelLayout.setHorizontalGroup(
            bookshelfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBSCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );
        bookshelfPanelLayout.setVerticalGroup(
            bookshelfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookshelfPanelLayout.createSequentialGroup()
                .addComponent(lbBSCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
        );

        borrowInfoPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
        borrowInfoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowInfoPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                borrowInfoPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                borrowInfoPanelMouseExited(evt);
            }
        });

        lbBorrowInfoCount.setBackground(new java.awt.Color(0, 204, 204));
        lbBorrowInfoCount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbBorrowInfoCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBorrowInfoCount.setText("borrowInfoCount");
        lbBorrowInfoCount.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Borrows");
        jLabel6.setOpaque(true);

        javax.swing.GroupLayout borrowInfoPanelLayout = new javax.swing.GroupLayout(borrowInfoPanel);
        borrowInfoPanel.setLayout(borrowInfoPanelLayout);
        borrowInfoPanelLayout.setHorizontalGroup(
            borrowInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBorrowInfoCount, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        borrowInfoPanelLayout.setVerticalGroup(
            borrowInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrowInfoPanelLayout.createSequentialGroup()
                .addComponent(lbBorrowInfoCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dashboardPanelLayout = new javax.swing.GroupLayout(dashboardPanel);
        dashboardPanel.setLayout(dashboardPanelLayout);
        dashboardPanelLayout.setHorizontalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memberPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150)
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bookshelfPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staffPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150)
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        dashboardPanelLayout.setVerticalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borrowInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bookshelfPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bookPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staffPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memberPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        displayPanel.add(dashboardPanel, java.awt.BorderLayout.CENTER);

        accountPanel.setBackground(new java.awt.Color(190, 218, 245));
        accountPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        lbWelcome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbWelcome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbWelcome.setText("Welcome, Lib_ID!");

        buttonLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonLogout.setForeground(new java.awt.Color(0, 0, 153));
        buttonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logout.png"))); // NOI18N
        buttonLogout.setText("Logout");
        buttonLogout.setContentAreaFilled(false);
        buttonLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonLogout.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logout_Hover.png"))); // NOI18N
        buttonLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogoutActionPerformed(evt);
            }
        });

        buttonProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Profile.png"))); // NOI18N
        buttonProfile.setContentAreaFilled(false);
        buttonProfile.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Profile_Hover.png"))); // NOI18N
        buttonProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProfileActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout accountPanelLayout = new javax.swing.GroupLayout(accountPanel);
        accountPanel.setLayout(accountPanelLayout);
        accountPanelLayout.setHorizontalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        accountPanelLayout.setVerticalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonLogout)
                    .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(accountPanelLayout.createSequentialGroup()
                            .addComponent(lbWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52))
        );

        optionPanel.setOpaque(false);
        optionPanel.setLayout(new javax.swing.BoxLayout(optionPanel, javax.swing.BoxLayout.LINE_AXIS));

        btDashboard.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dashboard.png"))); // NOI18N
        btDashboard.setText("Dashboard");
        btDashboard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btDashboard.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btDashboardMouseExited(evt);
            }
        });
        btDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDashboardActionPerformed(evt);
            }
        });
        optionPanel.add(btDashboard);

        btLendBook.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btLendBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Lend Book.png"))); // NOI18N
        btLendBook.setText("Lend Book");
        btLendBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btLendBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btLendBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btLendBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btLendBookMouseExited(evt);
            }
        });
        btLendBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLendBookActionPerformed(evt);
            }
        });
        optionPanel.add(btLendBook);

        btEmail.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Email.png"))); // NOI18N
        btEmail.setText("Email");
        btEmail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEmail.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btEmailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btEmailMouseExited(evt);
            }
        });
        btEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmailActionPerformed(evt);
            }
        });
        optionPanel.add(btEmail);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(accountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jSeparator2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(optionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirm = JOptionPane.showConfirmDialog(null, "Do you really want to close this application?", "Exit",  JOptionPane.YES_NO_OPTION);
        if(confirm==JOptionPane.YES_OPTION)
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.requestFocus();
    }//GEN-LAST:event_formMouseClicked
    
    private void buttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogoutActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Logout",  JOptionPane.YES_NO_OPTION);
        if(confirm==JOptionPane.YES_OPTION){
            LoginForm login = new LoginForm();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_buttonLogoutActionPerformed

    private void buttonProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProfileActionPerformed
        String libID = lbWelcome.getText().substring(9, lbWelcome.getText().length()-1);
        
        try{
            Integer.parseInt(libID);
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Invalid account!", "Alert!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        ProfileFrame profileFrame = new ProfileFrame(libID);
        profileFrame.setVisible(true);
    }//GEN-LAST:event_buttonProfileActionPerformed

    private void btLendBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLendBookActionPerformed
        displayLendBookPanel();
    }//GEN-LAST:event_btLendBookActionPerformed

    private void btEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmailActionPerformed
        EmailSendingForm esf = new EmailSendingForm();
        esf.setVisible(true);
    }//GEN-LAST:event_btEmailActionPerformed

    private void bookPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookPanelMouseEntered
        bookPanel.setBorder(BorderFactory.createLineBorder(new Color(255,0,0), 5, true));
        lbBookCount.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_bookPanelMouseEntered

    private void bookPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookPanelMouseExited
        bookPanel.setBorder(BorderFactory.createLineBorder(new Color(0,204,204), 3, true));
        lbBookCount.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_bookPanelMouseExited

    private void memberPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberPanelMouseEntered
        memberPanel.setBorder(BorderFactory.createLineBorder(new Color(255,0,0), 5, true));
        lbMemberCount.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_memberPanelMouseEntered

    private void memberPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberPanelMouseExited
        memberPanel.setBorder(BorderFactory.createLineBorder(new Color(0,204,204), 3, true));
        lbMemberCount.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_memberPanelMouseExited

    private void staffPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffPanelMouseEntered
        staffPanel.setBorder(BorderFactory.createLineBorder(new Color(255,0,0), 5, true));
        lbStaffCount.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_staffPanelMouseEntered

    private void adminPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminPanelMouseEntered
        adminPanel.setBorder(BorderFactory.createLineBorder(new Color(255,0,0), 5, true));
        lbAdminCount.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_adminPanelMouseEntered

    private void staffPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffPanelMouseExited
        staffPanel.setBorder(BorderFactory.createLineBorder(new Color(0,204,204), 3, true));
        lbStaffCount.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_staffPanelMouseExited

    private void adminPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminPanelMouseExited
        adminPanel.setBorder(BorderFactory.createLineBorder(new Color(0,204,204), 3, true));
        lbAdminCount.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_adminPanelMouseExited

    private void bookPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookPanelMouseClicked
        displayBookPanel();
        bookPanel.setBorder(BorderFactory.createLineBorder(new Color(0,204,204), 3, true));
        lbBookCount.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_bookPanelMouseClicked

    private void memberPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberPanelMouseClicked
        displayMemberPanel();
        memberPanel.setBorder(BorderFactory.createLineBorder(new Color(0,204,204), 3, true));
        lbMemberCount.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_memberPanelMouseClicked

    private void staffPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffPanelMouseClicked
        displayStaffPanel();
        staffPanel.setBorder(BorderFactory.createLineBorder(new Color(0,204,204), 3, true));
        lbStaffCount.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_staffPanelMouseClicked

    private void adminPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminPanelMouseClicked
        displayAdminPanel();
        adminPanel.setBorder(BorderFactory.createLineBorder(new Color(0,204,204), 3, true));
        lbAdminCount.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_adminPanelMouseClicked

    private void btDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDashboardActionPerformed
        displayDashboardPanel();
    }//GEN-LAST:event_btDashboardActionPerformed

    private void bookshelfPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookshelfPanelMouseClicked
        displayBookshelfPanel();
        bookshelfPanel.setBorder(BorderFactory.createLineBorder(new Color(0,204,204), 3, true));
        lbBSCount.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_bookshelfPanelMouseClicked

    private void bookshelfPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookshelfPanelMouseEntered
        bookshelfPanel.setBorder(BorderFactory.createLineBorder(new Color(255,0,0), 5, true));
        lbBSCount.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_bookshelfPanelMouseEntered

    private void bookshelfPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookshelfPanelMouseExited
        bookshelfPanel.setBorder(BorderFactory.createLineBorder(new Color(0,204,204), 3, true));
        lbBSCount.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_bookshelfPanelMouseExited

    private void borrowInfoPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowInfoPanelMouseClicked
        displayBorrowListPanel();
        borrowInfoPanel.setBorder(BorderFactory.createLineBorder(new Color(0,204,204), 3, true));
        lbBorrowInfoCount.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_borrowInfoPanelMouseClicked

    private void borrowInfoPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowInfoPanelMouseEntered
        borrowInfoPanel.setBorder(BorderFactory.createLineBorder(new Color(255,0,0), 5, true));
        lbBorrowInfoCount.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_borrowInfoPanelMouseEntered

    private void borrowInfoPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowInfoPanelMouseExited
        borrowInfoPanel.setBorder(BorderFactory.createLineBorder(new Color(0,204,204), 3, true));
        lbBorrowInfoCount.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_borrowInfoPanelMouseExited

    private void btDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDashboardMouseEntered
        btDashboard.setBackground(new Color(120,165,208));
    }//GEN-LAST:event_btDashboardMouseEntered

    private void btDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDashboardMouseExited
        btDashboard.setBackground(UIManager.getColor("control"));
    }//GEN-LAST:event_btDashboardMouseExited

    private void btLendBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLendBookMouseEntered
        btLendBook.setBackground(new Color(120,165,208));
    }//GEN-LAST:event_btLendBookMouseEntered

    private void btLendBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLendBookMouseExited
        btLendBook.setBackground(UIManager.getColor("control"));
    }//GEN-LAST:event_btLendBookMouseExited

    private void btEmailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEmailMouseEntered
        btEmail.setBackground(new Color(120,165,208));
    }//GEN-LAST:event_btEmailMouseEntered

    private void btEmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEmailMouseExited
        btEmail.setBackground(UIManager.getColor("control"));
    }//GEN-LAST:event_btEmailMouseExited
 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountPanel;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JPanel bookPanel;
    private javax.swing.JPanel bookshelfPanel;
    private javax.swing.JPanel borrowInfoPanel;
    private javax.swing.JButton btDashboard;
    private javax.swing.JButton btEmail;
    private javax.swing.JButton btLendBook;
    private javax.swing.JButton buttonLogout;
    private javax.swing.JButton buttonProfile;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelMemberName4;
    private javax.swing.JLabel lbAdminCount;
    private javax.swing.JLabel lbBSCount;
    private javax.swing.JLabel lbBookCount;
    private javax.swing.JLabel lbBorrowInfoCount;
    private javax.swing.JLabel lbMemberCount;
    private javax.swing.JLabel lbStaffCount;
    private javax.swing.JLabel lbWelcome;
    private javax.swing.JPanel memberPanel;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JPanel staffPanel;
    // End of variables declaration//GEN-END:variables
}
