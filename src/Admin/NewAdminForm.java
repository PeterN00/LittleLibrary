/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Admin
 */
public final class NewAdminForm extends javax.swing.JFrame {

    /**
     * Creates new form NewAdminForm
     */
    public NewAdminForm() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(190,218,245));
        getToday();
    }

    public void getToday(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now();  
        lbDate.setText(dtf.format(now));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDate = new javax.swing.JLabel();
        tfDay = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btAddMember = new javax.swing.JButton();
        tfPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btUndoAll = new javax.swing.JButton();
        tfEmail = new javax.swing.JTextField();
        tfMonth = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAddress = new javax.swing.JTextArea();
        tfFirstName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        tfLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfYear = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Admin");

        lbDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbDate.setForeground(new java.awt.Color(255, 51, 51));

        tfDay.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfDay.setText("01");
        tfDay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfDayFocusGained(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Phone:");

        btAddMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Yes Mark.png"))); // NOI18N
        btAddMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddMemberMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddMemberMouseExited(evt);
            }
        });
        btAddMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddMemberActionPerformed(evt);
            }
        });

        tfPhone.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfPhoneFocusGained(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("-");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Email:");

        btUndoAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh.png"))); // NOI18N
        btUndoAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btUndoAllMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btUndoAllMouseExited(evt);
            }
        });
        btUndoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUndoAllActionPerformed(evt);
            }
        });

        tfEmail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfEmailFocusGained(evt);
            }
        });

        tfMonth.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfMonth.setText("01");
        tfMonth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfMonthFocusGained(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("-");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Address:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("First Name:");

        taAddress.setColumns(20);
        taAddress.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        taAddress.setLineWrap(true);
        taAddress.setRows(5);
        taAddress.setWrapStyleWord(true);
        taAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                taAddressFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(taAddress);

        tfFirstName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfFirstNameFocusGained(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Last Name:");

        tfLastName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfLastNameFocusGained(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Gender:");

        cbGender.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Today:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("DOB(day-month-year):");

        tfYear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfYear.setText("2000");
        tfYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfYearFocusGained(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/NewAdmin.png"))); // NOI18N
        jLabel11.setText("ADMIN");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfDay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btUndoAll, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAddMember)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfDay)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfMonth)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfYear))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btUndoAll, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btAddMember))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfDayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDayFocusGained
        tfDay.setBackground(Color.WHITE);
    }//GEN-LAST:event_tfDayFocusGained

    private void btAddMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddMemberActionPerformed
        int errorCount=0;
        List<String> error = new ArrayList();
        if(tfFirstName.getText().isEmpty()){
            error.add("First Name");
            tfFirstName.setBackground(Color.yellow);
            errorCount+=1;
        }
        if(tfLastName.getText().isEmpty()){
            error.add("Last Name");
            tfLastName.setBackground(Color.yellow);
            errorCount+=1;
        }
        if(tfDay.getText().isEmpty()){
            error.add("DOB(Day)");
            tfDay.setBackground(Color.yellow);
            errorCount+=1;
        }
        if(tfMonth.getText().isEmpty()){
            error.add("DOB(Month)");
            tfMonth.setBackground(Color.yellow);
            errorCount+=1;
        }
        if(tfYear.getText().isEmpty()){
            error.add("DOB(Year)");
            tfYear.setBackground(Color.yellow);
            errorCount+=1;
        }
        if(taAddress.getText().isEmpty()){
            error.add("Address");
            taAddress.setBackground(Color.yellow);
            errorCount+=1;
        }

        if(errorCount>0){
            String err = "";
            for(String temp : error){
                err+=temp+"\n";
            }
            JOptionPane.showMessageDialog(null, "The following field(s) cannot be empty:\n"+err, "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try{
            Integer.parseInt(tfPhone.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Phone only contains numbers!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            tfPhone.setBackground(Color.yellow);
            return;
        }
        try{
            Integer.parseInt(tfDay.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Day only contains numbers!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            tfDay.setBackground(Color.yellow);
            return;
        }
        try{
            Integer.parseInt(tfMonth.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Month only contains numbers!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            tfMonth.setBackground(Color.yellow);
            return;
        }
        try{
            Integer.parseInt(tfYear.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Year only contains numbers!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            tfYear.setBackground(Color.yellow);
            return;
        }

        if(tfPhone.getText().length()!=10){
            JOptionPane.showMessageDialog(null, "Phone contains 10 numbers!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            tfPhone.setBackground(Color.yellow);
            return;
        }

        if(!tfEmail.getText().contains("@")){
            JOptionPane.showMessageDialog(null, "Invalid email!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            tfEmail.setBackground(Color.yellow);
            return;
        }

        if(Integer.parseInt(tfDay.getText())<1){
            JOptionPane.showMessageDialog(null, "Invalid Day!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            tfDay.setBackground(Color.yellow);
            return;
        }
        if(Integer.parseInt(tfMonth.getText())<1){
            JOptionPane.showMessageDialog(null, "Invalid month!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            tfMonth.setBackground(Color.yellow);
            return;
        }
        if(Integer.parseInt(tfMonth.getText())>12){
            JOptionPane.showMessageDialog(null, "Invalid month!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            tfMonth.setBackground(Color.yellow);
            return;
        }
        if(Integer.parseInt(tfYear.getText())<0){
            JOptionPane.showMessageDialog(null, "Invalid year!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            tfYear.setBackground(Color.yellow);
            return;
        }
        
        String gender;
        if(cbGender.getSelectedItem().toString().equals("Male"))
            gender = "M";
        else
            gender = "F";

        String DOB = tfYear.getText()+"-"+tfMonth.getText()+"-"+tfDay.getText();
        
        AdminManagement.addAdmin(tfFirstName.getText().trim(), tfLastName.getText().trim(), DOB, gender, tfPhone.getText(), tfEmail.getText(), taAddress.getText(), lbDate.getText());
        
    }//GEN-LAST:event_btAddMemberActionPerformed

    private void tfPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPhoneFocusGained
        tfPhone.setBackground(Color.WHITE);
    }//GEN-LAST:event_tfPhoneFocusGained

    private void btUndoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUndoAllActionPerformed
        tfFirstName.setText("");
        tfLastName.setText("");
        tfDay.setText("01");
        tfMonth.setText("01");
        tfYear.setText("2000");
        tfPhone.setText("");
        tfEmail.setText("");
        taAddress.setText("");
    }//GEN-LAST:event_btUndoAllActionPerformed

    private void tfEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmailFocusGained
        tfEmail.setBackground(Color.WHITE);
    }//GEN-LAST:event_tfEmailFocusGained

    private void tfMonthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfMonthFocusGained
        tfMonth.setBackground(Color.WHITE);
    }//GEN-LAST:event_tfMonthFocusGained

    private void taAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_taAddressFocusGained
        taAddress.setBackground(Color.WHITE);
    }//GEN-LAST:event_taAddressFocusGained

    private void tfFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfFirstNameFocusGained
        tfFirstName.setBackground(Color.WHITE);
    }//GEN-LAST:event_tfFirstNameFocusGained

    private void tfLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfLastNameFocusGained
        tfLastName.setBackground(Color.WHITE);
    }//GEN-LAST:event_tfLastNameFocusGained

    private void tfYearFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfYearFocusGained
        tfYear.setBackground(Color.WHITE);
    }//GEN-LAST:event_tfYearFocusGained

    private void btUndoAllMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUndoAllMouseEntered
        btUndoAll.setBackground(new Color(120,165,208));
    }//GEN-LAST:event_btUndoAllMouseEntered

    private void btUndoAllMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUndoAllMouseExited
        btUndoAll.setBackground(UIManager.getColor("control"));
    }//GEN-LAST:event_btUndoAllMouseExited

    private void btAddMemberMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddMemberMouseEntered
        btAddMember.setBackground(new Color(120,165,208));
    }//GEN-LAST:event_btAddMemberMouseEntered

    private void btAddMemberMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddMemberMouseExited
        btAddMember.setBackground(UIManager.getColor("control"));
    }//GEN-LAST:event_btAddMemberMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddMember;
    private javax.swing.JButton btUndoAll;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbDate;
    private javax.swing.JTextArea taAddress;
    private javax.swing.JTextField tfDay;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfMonth;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables
}