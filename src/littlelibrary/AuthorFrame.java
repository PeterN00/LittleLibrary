/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlelibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public final class AuthorFrame {
    private final JFrame authorFrame;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTable authorTable;
    private DefaultTableModel tableModel;
    
    public boolean checkDuplicatedAuthor(String fullName){
        for(int i=0; i<tableModel.getRowCount(); i++){
            if(fullName.equals(tableModel.getValueAt(i, 0).toString()))
                return true;
        }
        return false;
    }
    
    public void displayTBAuthor(String[] addedAuthor){
        if(addedAuthor!=null){
            for(String author : addedAuthor){
                Object[] row = new Object[1];
                row[0] = author;
                tableModel.addRow(row);
            }
        }
    }
    
    public void displayLBAuthor(JLabel lbDisplayAuthor){
        int count=0;
        String[] authorArray = new String[tableModel.getRowCount()];
        for(int i=0; i<tableModel.getRowCount(); i++){
            authorArray[i] = tableModel.getValueAt(i, 0).toString();
        }
        
        StringBuilder sb = new StringBuilder();
        for(String author : authorArray){
            count+=1;
            sb.append(author);
            sb.append(", ");
        }
        
        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i<authorArray.length; i++){
            sb2.append(authorArray[i]);
            sb2.append(", ");
            if(i==4){
                sb2.append("...");
                break;
            }
        }
        
        UIManager.put("ToolTip.font", new Font("Tahoma", Font.BOLD, 18));
        
        if(lbDisplayAuthor.getToolTipText() != null){
            lbDisplayAuthor.setToolTipText(null);
        }
        
        if(count==0){
            lbDisplayAuthor.setText("?");
        }
        else{
            String author = sb.substring(0, sb.length()-2);
            if(count>5){
                lbDisplayAuthor.setText("<html><p align=\"left\">"+sb2.toString()+"</p></html>");
                lbDisplayAuthor.setToolTipText("<html><p width=\"300\">"+author+"</p></html>");
            }
            else
                lbDisplayAuthor.setText("<html><p align=\"left\">"+author+"</p></html>");
        }
    }
    
    public JPanel tfPanel(){
        JPanel tfPanel = new JPanel();
        tfPanel.setVisible(true);
        tfPanel.setLayout(new GridLayout(2,2,10,0));
        JLabel lbFirstName = new JLabel("First Name:");
        lbFirstName.setFont(new Font("Tahoma", Font.BOLD, 18));
        JLabel lbLastName = new JLabel("Last Name:");
        lbLastName.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        tfFirstName = new JTextField("");
        tfFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfFirstName.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
                tfFirstName.setBackground(Color.WHITE);
            }
        });
        tfLastName = new JTextField("");
        tfLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfLastName.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
                tfLastName.setBackground(Color.WHITE);
            }
        });
        
        tfPanel.add(lbFirstName);
        tfPanel.add(lbLastName);
        tfPanel.add(tfFirstName);
        tfPanel.add(tfLastName);
        tfPanel.setBorder(BorderFactory.createCompoundBorder(tfPanel.getBorder(), BorderFactory.createEmptyBorder(5, 5, 10, 5)));
        return tfPanel;
    }
    
    public JPanel tablePanel(){
        JPanel tablePanel = new JPanel();
        tablePanel.setVisible(true);
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Author");
        authorTable = new JTable(tableModel);
        authorTable.getColumn("Author").setMinWidth(1000);
        Font headerFont = new Font("Tahoma", Font.PLAIN, 24);
        authorTable.getTableHeader().setFont(headerFont);
        authorTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        authorTable.setCellSelectionEnabled(true);
        ListSelectionModel select = authorTable.getSelectionModel();  
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        authorTable.setFont(new Font("Tahoma", Font.PLAIN, 24));
        authorTable.setRowHeight(30);
        JScrollPane jsp = new JScrollPane(authorTable);
        tablePanel.add(jsp);
        return tablePanel;
    }
    
    public JPanel optionPanel(JLabel lbDisplayAuthor){
        JPanel optionPanel = new JPanel();
        optionPanel.setVisible(true);
        optionPanel.setLayout(new GridLayout(1,2,10,10));
        optionPanel.setBorder(BorderFactory.createCompoundBorder(optionPanel.getBorder(), BorderFactory.createEmptyBorder(5, 70, 10, 70)));
        
        JButton buttonAddAuthor = new JButton();
        ImageIcon iconApply = new ImageIcon(System.getProperty("user.dir")+"/src/Images/Yes Mark.png");
        buttonAddAuthor.setIcon(iconApply);
        buttonAddAuthor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int errCount=0;
                List<String> err = new ArrayList();
                if(tfFirstName.getText().isEmpty()){
                    tfFirstName.setBackground(Color.yellow);
                    errCount+=1;
                    err.add("First Name");
                }
                if(tfLastName.getText().isEmpty()){
                    tfLastName.setBackground(Color.yellow);
                    errCount+=1;
                    err.add("Last Name");
                }
                if(errCount>0){
                    String error = "";
                    for(String temp : err)
                        error+=temp+"\n";
                    JOptionPane.showMessageDialog(null, "The following field(s) cannot be empty: \n"+error, "Alert!",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                String fullName;
                fullName = tfFirstName.getText().trim() + " " + tfLastName.getText().trim();
                Object[] row = new Object[1];
                row[0] = fullName;
                if(checkDuplicatedAuthor(fullName)==true){
                    JOptionPane.showMessageDialog(null, "\""+fullName+"\""+ " already exists!", "Alert!",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else{
                    tableModel.addRow(row);
                    tfFirstName.setText("");
                    tfLastName.setText("");
                }
                displayLBAuthor(lbDisplayAuthor);
            }
        });
        
        JButton buttonRemoveAuthor = new JButton();
        ImageIcon iconRemove = new ImageIcon(System.getProperty("user.dir")+"/src/Images/X Mark.png");
        buttonRemoveAuthor.setIcon(iconRemove);
        buttonRemoveAuthor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int selectedRow = authorTable.getSelectedRow();
                if(selectedRow == -1){
                    JOptionPane.showMessageDialog(null, "Please select an author in the table to remove!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int confirm = JOptionPane.showConfirmDialog(null, "Do you really want to remove this author from the list?", "Confirmation",  JOptionPane.YES_NO_OPTION);
                if(confirm==JOptionPane.YES_OPTION){
                    tableModel.removeRow(selectedRow);
                    displayLBAuthor(lbDisplayAuthor);
                    }
            }
        });
        
        JButton buttonRefresh = new JButton();
        ImageIcon iconRefresh = new ImageIcon(System.getProperty("user.dir")+"/src/Images/Refresh.png");
        buttonRefresh.setIcon(iconRefresh);
        buttonRefresh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int confirm = JOptionPane.showConfirmDialog(null, "Do you really want to remove all the authors in the list?", "Confirmation",  JOptionPane.YES_NO_OPTION);
                if(confirm==JOptionPane.YES_OPTION){
                    tableModel.setRowCount(0);
                    tfFirstName.setText("");
                    tfLastName.setText("");
                    displayLBAuthor(lbDisplayAuthor);
                }
            }
        });
        
        optionPanel.add(buttonAddAuthor);
        optionPanel.add(buttonRemoveAuthor);
        optionPanel.add(buttonRefresh);
        return optionPanel;
    }
    
    public void setVisible(boolean bl){
        authorFrame.setVisible(bl);
    }
    
    public AuthorFrame(JLabel lbDisplayAuthor, JFrame frame, String[] addedAuthor){
        authorFrame = new JFrame();
        authorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        authorFrame.setTitle("Book Author");
        
        authorFrame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                frame.setEnabled(true);
                frame.requestFocus();
            }
        });
        
        JPanel tfPanel = tfPanel();
        JPanel tablePanel = tablePanel();
        JPanel optionPanel = optionPanel(lbDisplayAuthor);
        
        authorFrame.add(tfPanel, BorderLayout.PAGE_START);
        authorFrame.add(tablePanel, BorderLayout.PAGE_END);
        authorFrame.add(optionPanel, BorderLayout.CENTER);
        
        authorFrame.pack();
        authorFrame.setLocationRelativeTo(null);
        authorFrame.setResizable(false);
        
        displayTBAuthor(addedAuthor);
    }
}
