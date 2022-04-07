/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlelibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin
 */
public final class BookshelfDisplayPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookshelfDisplayPanel
     */
    ArrayList<Book> allBookList = BookManagement.bookList();
    ArrayList<Bookshelf> allBSList = BookshelfManagement.bookshelfList();
    private String selectedBookshelf = "";
    public BookshelfDisplayPanel() {
        initComponents();
        bookTable.getTableHeader().setEnabled(false);
        bookTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        Font headerFont = new Font("Tahoma", Font.PLAIN, 24);
        bookTable.getTableHeader().setFont(headerFont);
        bookTable.setRowHeight(40);
        bookTable.requestFocusInWindow();
        SearchTable();
        buttonGF.doClick();
        selectFirstBookshelf();
    }
    
    public JButton[] getBookshelfButton(List<String> bsList){
        JButton[] btArray = new JButton[bsList.size()];
        for(int i=0; i<bsList.size(); i++){
            btArray[i] = new JButton(bsList.get(i));
            btArray[i].setName("bt"+bsList.get(i));
            btArray[i].setFont(new Font("Tahoma", Font.BOLD, 24));
        }
        return btArray;
    }
    
    public void selectFirstBookshelf(){
        if(bookshelfPanel.getComponents().length>0){
            JButton firstBS = (JButton) bookshelfPanel.getComponent(0);
            firstBS.setEnabled(false);
            selectedBookshelf = firstBS.getText();
            displayBookTable(firstBS.getText());
        }
    }
    
    public void enableAllButton(JButton selectedBS){
        for(Component cp : bookshelfPanel.getComponents()){
            if(!cp.getName().equals(selectedBS.getName()))
                cp.setEnabled(true);
        }
    }
    
    public void displayBookTable(String bsID){
        DefaultTableModel model = (DefaultTableModel)bookTable.getModel();  
        model.setRowCount(0);
        HashMap<String, String> bookList_OnBS = BookshelfManagement.getBook(bsID);
        Object[] row = new Object[2];
        for(HashMap.Entry me : bookList_OnBS.entrySet()){
            row[0] = me.getKey();
            row[1] = me.getValue();
            model.addRow(row);
        }
    }
    
    public void displayBookshelfPanel(List<String> bsList){
        bookshelfPanel.removeAll();
        bookshelfPanel.setLayout(new GridLayout(0,3,30,30));
        JButton[] bsButton = getBookshelfButton(bsList);
        for(JButton jbt : bsButton){
            jbt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    jbt.setEnabled(false);
                    enableAllButton(jbt);
                    displayBookTable(jbt.getText());
                    selectedBookshelf = jbt.getText();
                }
            });
            bookshelfPanel.add(jbt);
        }
        bookshelfPanel.revalidate();
        bookshelfPanel.repaint();
    }
    
    public void SearchTable(){        
        DefaultTableModel searchmodel = (DefaultTableModel)bookTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(searchmodel);
        bookTable.setRowSorter(sorter);
        tfSearch.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent de) {
                String text = tfSearch.getText();
                if(text.trim().length()==0 || text.equals("Search by Title/ISBN")){
                    sorter.setRowFilter(null);
                }
                else{
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                String text = tfSearch.getText();
                if(text.trim().length()==0 || text.equals("Search by Title/ISBN")){
                    sorter.setRowFilter(null);
                }
                else{
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
            
    });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGF = new javax.swing.JButton();
        button1F = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btAddBS = new javax.swing.JButton();
        btBookPlacement = new javax.swing.JButton();
        btRemoveBS = new javax.swing.JButton();
        bsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jspBSPanel = new javax.swing.JScrollPane();
        bookshelfPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(190, 218, 245));

        buttonGF.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        buttonGF.setText("GROUND FLOOR");
        buttonGF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGFActionPerformed(evt);
            }
        });

        button1F.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        button1F.setText("FIRST FLOOR");
        button1F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1FActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        bookTable.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Title"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookTable.setAutoscrolls(false);
        bookTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(bookTable);
        if (bookTable.getColumnModel().getColumnCount() > 0) {
            bookTable.getColumnModel().getColumn(0).setResizable(false);
            bookTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            bookTable.getColumnModel().getColumn(1).setResizable(false);
            bookTable.getColumnModel().getColumn(1).setPreferredWidth(700);
        }

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MagnifyingGlass.png"))); // NOI18N

        tfSearch.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfSearch.setForeground(new java.awt.Color(153, 153, 153));
        tfSearch.setText("Search by Title/ISBN");
        tfSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSearchFocusLost(evt);
            }
        });
        tfSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfSearchMouseClicked(evt);
            }
        });

        btAddBS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btAddBS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Plus.png"))); // NOI18N
        btAddBS.setText("New Bookshelf");
        btAddBS.setContentAreaFilled(false);
        btAddBS.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btAddBS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddBSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddBSMouseExited(evt);
            }
        });
        btAddBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddBSActionPerformed(evt);
            }
        });

        btBookPlacement.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btBookPlacement.setText("Book Placement");
        btBookPlacement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btBookPlacementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btBookPlacementMouseExited(evt);
            }
        });
        btBookPlacement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBookPlacementActionPerformed(evt);
            }
        });

        btRemoveBS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btRemoveBS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Minus.png"))); // NOI18N
        btRemoveBS.setText("Remove Bookshelf");
        btRemoveBS.setContentAreaFilled(false);
        btRemoveBS.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btRemoveBS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btRemoveBSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btRemoveBSMouseExited(evt);
            }
        });
        btRemoveBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveBSActionPerformed(evt);
            }
        });

        bsPanel.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("-Bookshelf-");

        jspBSPanel.setBorder(null);
        jspBSPanel.setPreferredSize(new java.awt.Dimension(455, 350));

        bookshelfPanel.setBackground(new java.awt.Color(190, 218, 245));
        bookshelfPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout bookshelfPanelLayout = new javax.swing.GroupLayout(bookshelfPanel);
        bookshelfPanel.setLayout(bookshelfPanelLayout);
        bookshelfPanelLayout.setHorizontalGroup(
            bookshelfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );
        bookshelfPanelLayout.setVerticalGroup(
            bookshelfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        jspBSPanel.setViewportView(bookshelfPanel);

        javax.swing.GroupLayout bsPanelLayout = new javax.swing.GroupLayout(bsPanel);
        bsPanel.setLayout(bsPanelLayout);
        bsPanelLayout.setHorizontalGroup(
            bsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspBSPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        bsPanelLayout.setVerticalGroup(
            bsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspBSPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buttonGF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1F, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btRemoveBS)
                    .addComponent(btAddBS))
                .addGap(18, 18, 18)
                .addComponent(bsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btBookPlacement))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btBookPlacement, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonGF, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button1F, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(273, 273, 273)
                                .addComponent(btAddBS, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRemoveBS, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(bsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGFActionPerformed
        List<String> bsList = BookshelfManagement.getBookshelf("GF");
        buttonGF.setEnabled(false);
        button1F.setEnabled(true);
        displayBookshelfPanel(bsList);
    }//GEN-LAST:event_buttonGFActionPerformed

    private void button1FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1FActionPerformed
        List<String> bsList = BookshelfManagement.getBookshelf("1F");
        buttonGF.setEnabled(true);
        button1F.setEnabled(false);
        displayBookshelfPanel(bsList);
    }//GEN-LAST:event_button1FActionPerformed

    private void tfSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSearchFocusGained
        if(tfSearch.getText().equals("Search by Title/ISBN") && tfSearch.isEnabled()){
            tfSearch.setText("");
            tfSearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_tfSearchFocusGained

    private void tfSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSearchFocusLost
        if(tfSearch.getText().isEmpty()){
            tfSearch.setForeground(Color.GRAY);
            tfSearch.setText("Search by Title/ISBN");
        }
    }//GEN-LAST:event_tfSearchFocusLost

    private void tfSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSearchMouseClicked
        if(tfSearch.getText().equals("Search by Title/ISBN") && tfSearch.isEnabled()){
            tfSearch.setText("");
            tfSearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_tfSearchMouseClicked

    private void btAddBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddBSActionPerformed
        JFrame newBS = new JFrame("New Bookshelf");
        
        Font font = new Font("Tahoma", Font.PLAIN, 24);
        JLabel lbID = new JLabel("Bookshelf ID:");
        JLabel lbLocation = new JLabel("Location: ");
        JTextField tfID = new JTextField();
        JComboBox cbLocation = new JComboBox();
        cbLocation.addItem("Ground Floor");
        cbLocation.addItem("First Floor");
        lbID.setFont(font);
        lbLocation.setFont(font);
        cbLocation.setFont(font);
        tfID.setFont(font);
        
        JButton btAdd = new JButton("Add");
        btAdd.setFont(font);
        btAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String location = "";
                if(cbLocation.getSelectedItem().toString().equals("Ground Floor"))
                    location = "GF";
                else if(cbLocation.getSelectedItem().toString().equals("First Floor"))
                    location = "1F";
                if(tfID.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "ID cannot be empty", "Notification!", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if(tfID.getText().length()<5 || tfID.getText().length()>5){
                    JOptionPane.showMessageDialog(null, "ID have to contains 5 characters", "Notification!", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if(checkDuplicatedBookshelfID(tfID.getText())==true){
                    JOptionPane.showMessageDialog(null, "ID already exists!", "Notification!", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                BookshelfManagement.addBookshelf(tfID.getText(), location);
                
                List<String> bsList = BookshelfManagement.getBookshelf(location);
                if(location.equals("GF")){
                    buttonGF.setEnabled(false);
                    button1F.setEnabled(true);
                }
                else if(location.equals("1F")){
                    buttonGF.setEnabled(true);
                    button1F.setEnabled(false);
                }
                displayBookshelfPanel(bsList);
            }
        });
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2,2,10,10));
        panel1.add(lbID);
        panel1.add(tfID);
        panel1.add(lbLocation);
        panel1.add(cbLocation);
        panel1.setBorder(BorderFactory.createCompoundBorder(panel1.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        
        newBS.add(panel1, BorderLayout.NORTH);
        newBS.add(btAdd, BorderLayout.SOUTH);
        
        newBS.pack();
        newBS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newBS.setResizable(false);
        newBS.setLocationRelativeTo(null);
        newBS.setVisible(true);
    }//GEN-LAST:event_btAddBSActionPerformed

    public boolean checkDuplicatedBookshelfID(String ID){
        for(Bookshelf bsID : allBSList){
            if(ID.equals(bsID.getID()))
                return true;
        }
        return false;
    }
    
    private void btRemoveBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveBSActionPerformed
        String removedID = JOptionPane.showInputDialog(null, "Enter Bookshelf ID:");
        
        if(removedID!=null){
            
            if(checkDuplicatedBookshelfID(removedID)==false)
                JOptionPane.showMessageDialog(null, "ID doesn't exist!", "Notification!", JOptionPane.INFORMATION_MESSAGE);
            else{
                String location = "";
                for(Bookshelf bs : allBSList){
                    if(removedID.equals(bs.getID())){
                        location = bs.getLocation();
                        break;
                    }
                }
                
                BookshelfManagement.removeBookshelf(removedID);
                JOptionPane.showMessageDialog(null, "\""+removedID+" - "+location+"\""+" removed!", "Notification!", JOptionPane.INFORMATION_MESSAGE);
                
                if(location.equals("Ground Floor"))
                    location = "GF";
                else if(location.equals("First Floor"))
                    location = "1F";
                
                List<String> bsList = BookshelfManagement.getBookshelf(location);
                if(location.equals("GF")){
                    buttonGF.setEnabled(false);
                    button1F.setEnabled(true);
                }
                else if(location.equals("1F")){
                    buttonGF.setEnabled(true);
                    button1F.setEnabled(false);
                }
                displayBookshelfPanel(bsList);
            }
        }
        
    }//GEN-LAST:event_btRemoveBSActionPerformed

    public boolean checkDuplicatedISBN(String ISBN){
        for(int i=0; i<allBookList.size(); i++){
            if(ISBN.equals(allBookList.get(i).getISBN()))
                return true;
        }
        return false;
    }
    
    public int checkISBN_IsNumeric(String ISBN){
        int count = 0;
        for(int i=0;i<ISBN.length();i++){
            if(Character.isDigit(ISBN.charAt(i))){
                count+=1;
            }
        }
        return count;
    }
    
    public void displayBookInfo(String ISBN, JLabel lbISBN, JLabel lbTitle, JLabel lbCover){
        ImageIcon cover = new ImageIcon(System.getProperty("user.dir")+"/src/BookCover/Empty.jpg");
        for(Book book : allBookList){
            if(book.getISBN().equals(ISBN)){
                lbISBN.setText(ISBN);
                lbTitle.setText(book.getTitle());
                if(book.getImage()==null)
                    lbCover.setIcon(cover);
                else
                    lbCover.setIcon(new ImageIcon(book.getImage()));
                break;
            }
        }
    }
    
    public void displayBookLocation(String bookshelfID, JLabel lbLocation){
        for(Bookshelf bs : allBSList){
            if(bs.getID().equals(bookshelfID)){
                lbLocation.setText(lbLocation.getText()+bookshelfID+" - "+bs.getLocation());
                break;
            }
        }
    }
    
    public boolean checkBook_DoesExist(String ID, String ISBN){
        HashMap<String, String> allBookInBookshelf = BookshelfManagement.getBook(ID);
        for(Map.Entry me : allBookInBookshelf.entrySet()){
            if(me.getKey().equals(ISBN))
                return true;
        }
        return false;
    }
    
    public int checkInputTFISBN(JTextField tfISBN){
        int err = 0;
        if(tfISBN.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter ISBN!", "Notification!", JOptionPane.INFORMATION_MESSAGE);
            tfISBN.setBackground(Color.yellow);
            err+=1;
            return err;
        }
        if(tfISBN.getText().length()!=13){
            JOptionPane.showMessageDialog(null, "ISBN has to contains 13 digits", "Notification!", JOptionPane.INFORMATION_MESSAGE);
            tfISBN.setBackground(Color.yellow);
            err+=1;
            return err;
        }
        if(checkISBN_IsNumeric(tfISBN.getText())!=13){
            JOptionPane.showMessageDialog(null, "ISBN only contains numbers", "Notification!", JOptionPane.INFORMATION_MESSAGE);
            tfISBN.setBackground(Color.yellow);
            err+=1;
            return err;
        }
        if(checkDuplicatedISBN(tfISBN.getText())==false){
            JOptionPane.showMessageDialog(null, "ISBN doesn't exist!", "Notification!", JOptionPane.INFORMATION_MESSAGE);
            err+=1;
            return err;
        }
        return err;
    }
    
    private void btBookPlacementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBookPlacementActionPerformed
        if(selectedBookshelf.isEmpty()){
            JOptionPane.showMessageDialog(null, "Select a bookshelf first!", "Notification!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JFrame frame = new JFrame("Book Placement");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        
        JPanel isbnPanel = new JPanel();
        isbnPanel.setBorder(BorderFactory.createCompoundBorder(isbnPanel.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        JPanel bookInfoPanel = new JPanel();
        bookInfoPanel.setBorder(BorderFactory.createCompoundBorder(bookInfoPanel.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        JPanel optionPanel = new JPanel();
        optionPanel.setBorder(BorderFactory.createCompoundBorder(bookInfoPanel.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        
        Font font = new Font("Tahoma", Font.PLAIN, 24);
        JLabel lbISBN = new JLabel("Enter ISBN: ");
        JTextField tfISBN = new JTextField("0123456789123");
        tfISBN.setFont(font);
        lbISBN.setFont(font);
        lbISBN.setToolTipText("<html><p width=\"350\">"+"International Standard Book Number that contains 13 digits to uniquely identify each book"+"</p></html>");
        UIManager.put("ToolTip.font", new Font("Tahoma", Font.BOLD, 18));
        tfISBN.setForeground(Color.GRAY);
        JButton btBookCheck = new JButton();
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"/src/Images/MagnifyingGlass.png");
        btBookCheck.setIcon(icon);
        
        tfISBN.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe){
                if(tfISBN.getText().equals("0123456789123")){
                    tfISBN.setText("");
                    tfISBN.setForeground(Color.BLACK);
                }
                tfISBN.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if(tfISBN.getText().isEmpty()){
                    tfISBN.setForeground(Color.GRAY);
                    tfISBN.setText("0123456789123");
                }
            }
        });
        
        isbnPanel.add(lbISBN, BorderLayout.LINE_START);
        isbnPanel.add(tfISBN, BorderLayout.AFTER_LAST_LINE);
        isbnPanel.add(btBookCheck, BorderLayout.LINE_END);
        
        ImageIcon cover = new ImageIcon(System.getProperty("user.dir")+"/src/BookCover/Empty.jpg");
        JLabel lbDisplayISBN = new JLabel("ISBN");
        JLabel lbDisplayTitle = new JLabel("Title");
        JLabel lbDisplayCover = new JLabel();
        lbDisplayCover.setIcon(cover);
        lbDisplayCover.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        lbDisplayISBN.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbDisplayTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbDisplayISBN.setHorizontalAlignment(SwingConstants.CENTER);
        lbDisplayTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbDisplayTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbDisplayISBN.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbDisplayCover.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        bookInfoPanel.setLayout(new BoxLayout(bookInfoPanel, BoxLayout.PAGE_AXIS));
        bookInfoPanel.add(lbDisplayISBN);
        bookInfoPanel.add(Box.createRigidArea(new Dimension(0,10)));
        bookInfoPanel.add(lbDisplayTitle);
        bookInfoPanel.add(Box.createRigidArea(new Dimension(0,10)));
        bookInfoPanel.add(lbDisplayCover);
        
        JButton btAddToBS = new JButton("Add book to bookshelf");
        JButton btRemoveFromBS = new JButton("Remove from bookshelf");
        btAddToBS.setFont(font);
        btRemoveFromBS.setFont(font);
        btAddToBS.setIcon(new ImageIcon(System.getProperty("user.dir")+"/src/Images/Plus.png"));
        btRemoveFromBS.setIcon(new ImageIcon(System.getProperty("user.dir")+"/src/Images/Minus.png"));
        JLabel lbLocation = new JLabel("Location: ");
        lbLocation.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbLocation.setForeground(new Color(255,51,51));
        lbLocation.setHorizontalAlignment(SwingConstants.CENTER);
        lbLocation.setAlignmentX(Component.CENTER_ALIGNMENT);
        btAddToBS.setAlignmentX(Component.CENTER_ALIGNMENT);
        btRemoveFromBS.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        displayBookLocation(selectedBookshelf, lbLocation);
        
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.PAGE_AXIS));
        optionPanel.add(lbLocation);
        optionPanel.add(Box.createRigidArea(new Dimension(0,10)));
        optionPanel.add(btAddToBS);
        optionPanel.add(Box.createRigidArea(new Dimension(0,10)));
        optionPanel.add(btRemoveFromBS);
        
        isbnPanel.setOpaque(false);
        bookInfoPanel.setOpaque(false);
        optionPanel.setOpaque(false);
        
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.PAGE_AXIS));
        frame.add(isbnPanel);
        frame.add(Box.createRigidArea(new Dimension(0,5)));
        frame.add(bookInfoPanel);
        frame.add(Box.createRigidArea(new Dimension(0,5)));
        frame.add(optionPanel);
        
        btBookCheck.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(checkInputTFISBN(tfISBN)==0)
                    displayBookInfo(tfISBN.getText(), lbDisplayISBN, lbDisplayTitle, lbDisplayCover);
            }
        });
        
        btAddToBS.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(checkInputTFISBN(tfISBN)==0){
                    if(checkBook_DoesExist(selectedBookshelf, tfISBN.getText())==true){
                        JOptionPane.showMessageDialog(null, "\""+tfISBN.getText()+"\""+" is already on bookshelf!", "Notification!", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    BookshelfManagement.addBookToBookshelf(selectedBookshelf, tfISBN.getText());
                    
                    displayBookTable(selectedBookshelf);
                }
            }
        });
        
        btRemoveFromBS.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(checkInputTFISBN(tfISBN)==0){
                    if(checkBook_DoesExist(selectedBookshelf, tfISBN.getText())==false){
                        JOptionPane.showMessageDialog(null, "\""+tfISBN.getText()+"\""+" not found on bookshelf "+"\""+selectedBookshelf+"\"!", "Notification!", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    int confirm = JOptionPane.showConfirmDialog(null, "Do you really want to remove this book from the bookshelf?\n\n"+"ISBN: "+tfISBN.getText()+"\n"+"Bookshelf ID: "+selectedBookshelf
                            , "Confirmation!", JOptionPane.YES_NO_OPTION);
                    if(confirm==JOptionPane.YES_OPTION){
                        BookshelfManagement.removeBookFromBookshelf(selectedBookshelf, tfISBN.getText());
                        
                        HashMap<String, String> allBookInBS = BookshelfManagement.getBook(selectedBookshelf);
                        displayBookTable(selectedBookshelf);
                    }
                }
            }
        });
        
        frame.getContentPane().setBackground(new Color(190,218,245));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_btBookPlacementActionPerformed

    private void btAddBSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddBSMouseEntered
        btAddBS.setForeground(Color.RED);
    }//GEN-LAST:event_btAddBSMouseEntered

    private void btAddBSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddBSMouseExited
        btAddBS.setForeground(Color.BLACK);
    }//GEN-LAST:event_btAddBSMouseExited

    private void btRemoveBSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRemoveBSMouseEntered
        btRemoveBS.setForeground(Color.RED);
    }//GEN-LAST:event_btRemoveBSMouseEntered

    private void btRemoveBSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRemoveBSMouseExited
        btRemoveBS.setForeground(Color.BLACK);
    }//GEN-LAST:event_btRemoveBSMouseExited

    private void btBookPlacementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBookPlacementMouseEntered
        btBookPlacement.setBackground(new Color(120,165,208));
    }//GEN-LAST:event_btBookPlacementMouseEntered

    private void btBookPlacementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBookPlacementMouseExited
        btBookPlacement.setBackground(UIManager.getColor("control"));
    }//GEN-LAST:event_btBookPlacementMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookTable;
    private javax.swing.JPanel bookshelfPanel;
    private javax.swing.JPanel bsPanel;
    private javax.swing.JButton btAddBS;
    private javax.swing.JButton btBookPlacement;
    private javax.swing.JButton btRemoveBS;
    private javax.swing.JButton button1F;
    private javax.swing.JButton buttonGF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jspBSPanel;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
