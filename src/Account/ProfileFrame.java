/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

import Member.MemberManagement;
import Member.Member;
import Admin.AdminManagement;
import Admin.Admin;
import Staff.Staff;
import Staff.StaffManagement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Admin
 */
public final class ProfileFrame {
    ArrayList<Member> memberList = MemberManagement.memberList();
    ArrayList<Staff> staffList = StaffManagement.staffList();
    ArrayList<Admin> adminList = AdminManagement.adminList();
    
    private final JFrame profileFrame;
    private JLabel labelProfileName;
    private JLabel labelProfileGender;
    private JLabel labelProfileDOB;
    private JLabel labelProfilePhone;
    private JLabel labelProfileEmail;
    private JLabel labelProfileAddress;
    private JLabel labelProfileJoinedDate;
    private JLabel labelProfileIDCardNum;
    private JLabel labelProfilePosition;
    
    public void displayMemberProfile(String LibID){
        for(int i=0;i<memberList.size();i++){
            if(LibID.equals(String.valueOf(memberList.get(i).getLibID()))){
                labelProfileName.setText("<html><p align=\"left\" width=\"500\">"+memberList.get(i).getFirstName()+" "+memberList.get(i).getLastName()+"</p></html>");
                labelProfileGender.setText("<html><p align=\"left\">"+memberList.get(i).getGender()+"</p></html>");
                labelProfilePhone.setText("<html><p align=\"left\">"+memberList.get(i).getPhone()+"</p></html>");
                labelProfileEmail.setText("<html><p align=\"left\" width=\"500\">"+memberList.get(i).getEmail()+"</p></html>");
                labelProfileAddress.setText("<html><p align=\"left\" width=\"500\">"+memberList.get(i).getAddress()+"</p></html>");
                labelProfileJoinedDate.setText("<html><p align=\"left\">"+memberList.get(i).getReg_Date()+"</p></html>");
                labelProfileDOB.setText("<html><p align=\"left\">"+memberList.get(i).getDOB()+"</p></html>");
                labelProfileIDCardNum.setText("<html><p align=\"left\">"+memberList.get(i).getIdCardNumber()+"</p></html>");
                break;
            }
        }
    }
    
    public void displayStaffProfile(String LibID){
        for(int i=0;i<staffList.size();i++){
            if(LibID.equals(String.valueOf(staffList.get(i).getLibID()))){
                labelProfileName.setText("<html><p align=\"left\" width=\"500\">"+staffList.get(i).getFirstName()+" "+staffList.get(i).getLastName()+"</p></html>");
                labelProfileGender.setText("<html><p align=\"left\">"+staffList.get(i).getGender()+"</p></html>");
                labelProfilePhone.setText("<html><p align=\"left\">"+staffList.get(i).getPhone()+"</p></html>");
                labelProfileEmail.setText("<html><p align=\"left\" width=\"500\">"+staffList.get(i).getEmail()+"</p></html>");
                labelProfileAddress.setText("<html><p align=\"left\" width=\"500\">"+staffList.get(i).getAddress()+"</p></html>");
                labelProfileJoinedDate.setText("<html><p align=\"left\">"+staffList.get(i).getStart_Date()+"</p></html>");
                labelProfileDOB.setText("<html><p align=\"left\">"+staffList.get(i).getDOB()+"</p></html>");
                labelProfilePosition.setText("<html><p align=\"left\">"+staffList.get(i).getPosition()+"</p></html>");
                break;
            }
        }
    }
    
    public void displayAdminProfile(String LibID){
        for(int i=0;i<adminList.size();i++){
            if(LibID.equals(String.valueOf(adminList.get(i).getLibID()))){
                labelProfileName.setText("<html><p align=\"left\" width=\"500\">"+adminList.get(i).getFirstName()+" "+adminList.get(i).getLastName()+"</p></html>");
                labelProfileGender.setText("<html><p align=\"left\">"+adminList.get(i).getGender()+"</p></html>");
                labelProfilePhone.setText("<html><p align=\"left\">"+adminList.get(i).getPhone()+"</p></html>");
                labelProfileEmail.setText("<html><p align=\"left\" width=\"500\">"+adminList.get(i).getEmail()+"</p></html>");
                labelProfileAddress.setText("<html><p align=\"left\" width=\"500\">"+adminList.get(i).getAddress()+"</p></html>");
                labelProfileJoinedDate.setText("<html><p align=\"left\">"+adminList.get(i).getStart_Date()+"</p></html>");
                labelProfileDOB.setText("<html><p align=\"left\">"+adminList.get(i).getDOB()+"</p></html>");
                break;
            }
        }
    }
    
    public JPanel leftPanel(){
        JPanel panel = new JPanel();
        panel.setVisible(true);
        
        
        panel.setBackground(new Color(197, 235, 223));
        return panel;
    }
    
    public JLabel profileLabel(String name){
        JLabel lb = new JLabel();
        Font font = new Font("Tahoma", Font.PLAIN, 24);
        lb.setFont(font);
        lb.setForeground(new Color(0,102,102));
        
        Font font_TitledBorder = new Font("Tahoma", Font.BOLD+Font.ITALIC, 18);
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2, true);
        
        lb.setBorder(BorderFactory.createTitledBorder(
                lineBorder, 
                name, TitledBorder.LEFT, TitledBorder.TOP
                , font_TitledBorder, Color.BLACK));
        
        return lb;
    }
    
    public JPanel rightPanel(String libID){
        JPanel panel = new JPanel();
        panel.setVisible(true);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        
        labelProfileName = profileLabel("Name");
        labelProfileGender = profileLabel("Gender");
        labelProfileDOB = profileLabel("Date of Birth");
        labelProfilePosition = profileLabel("Position");
        labelProfileIDCardNum = profileLabel("ID Card Number");
        labelProfilePhone = profileLabel("Phone");
        labelProfileEmail = profileLabel("Email");
        labelProfileAddress = profileLabel("Address");
        labelProfileJoinedDate = profileLabel("Joined Date");
        
        panel.add(labelProfileName);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(labelProfileGender);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(labelProfileDOB);
        
        int ID = Integer.parseInt(libID);
        
        if(ID>=200000001 && ID<300000000){
            panel.add(Box.createRigidArea(new Dimension(0,10)));
            panel.add(labelProfilePosition);
        }
        else if(ID>=300000001){
            panel.add(Box.createRigidArea(new Dimension(0,10)));
            panel.add(labelProfileIDCardNum);
        }
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(labelProfilePhone);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(labelProfileEmail);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(labelProfileAddress);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(labelProfileJoinedDate);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        
        panel.setBackground(new Color(190,218,245));
        
        return panel;
    }
    
    public void setVisible(boolean bl){
        profileFrame.setVisible(bl);
    }
    
    public ProfileFrame(String libID){
        profileFrame = new JFrame("Profile Frame");
        profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profileFrame.setResizable(false);
        profileFrame.setLayout(new FlowLayout());
        profileFrame.getContentPane().setBackground(new Color(190,218,245));
        
        JPanel leftPanel = leftPanel();
        JPanel rightPanel = rightPanel(libID);
        
        profileFrame.add(rightPanel);
        
        int ID = Integer.parseInt(libID);
        if(ID>=100000001 && ID<200000000)
            displayAdminProfile(libID);
        else if(ID>=200000001 && ID<300000000)
            displayStaffProfile(libID);
        else if(ID>=300000001)
            displayMemberProfile(libID);
        
        
        profileFrame.pack();
        profileFrame.setLocationRelativeTo(null);
    }
}
