/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlelibrary;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author Admin
 */
public final class CategoryFrame{
    private final JFrame categoryFrame;
    private JCheckBox[] checkBoxList;
    
    public JCheckBox[] checkBoxCategoryList(){
        List<String> categoryList = BookManagement.categoryList();
        checkBoxList = new JCheckBox[categoryList.size()];
        if(!categoryList.isEmpty()){
            for(int i=0; i < categoryList.size(); i++){
                JCheckBox temp = new JCheckBox(categoryList.get(i));
                temp.setFont(new Font("Tahoma", Font.PLAIN, 18));
                temp.setName("checkBox"+categoryList.get(i));
                checkBoxList[i]= temp;
            }
        }
        return checkBoxList;
    }
    
    public void displayCBCategory(String[] categoryArray){
        if(categoryArray!=null){
            for(int i=0; i<checkBoxList.length; i++){
                for(int j=0; j<categoryArray.length;j++){
                    if(checkBoxList[i].getText().equals(categoryArray[j])){
                        checkBoxList[i].setSelected(true);
                    }
                }
            }
        }
    }
    
    public boolean checkDuplicatedCategory(String category){
        List<String> categoryList = BookManagement.categoryList();
        for(String temp : categoryList){
            if(temp.equals(category))
                return true;
        }
        return false;
    }
    
    public void refreshCategoryPanel(JPanel categoryPanel, String[] categoryArray){
        checkBoxList = checkBoxCategoryList();
        categoryPanel.removeAll();
        for(JCheckBox checkBox : checkBoxList){
            categoryPanel.add(checkBox);
        }
        categoryPanel.revalidate();
        categoryPanel.repaint();
        categoryFrame.pack();
        displayCBCategory(categoryArray);
    }
    
    public JPanel categoryPanel(String[] categoryArray){
        JPanel categoryPanel = new JPanel();
        categoryPanel.setVisible(true);
        categoryPanel.setLayout(new GridLayout(0,3,70,30));
        categoryPanel.setBorder(BorderFactory.createCompoundBorder(categoryPanel.getBorder(), BorderFactory.createEmptyBorder(10,5,10,5)));
        refreshCategoryPanel(categoryPanel, categoryArray);
        return categoryPanel;
    }
    
    public void displayLBCategory(JLabel lbDisplayCategory){
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<checkBoxList.length; i++){
            if(checkBoxList[i].isSelected()){
                count+=1;
                sb.append(checkBoxList[i].getText());
                sb.append(", ");
            }
        }
        
        int count2 = 0;
        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i<checkBoxList.length; i++){
            if(checkBoxList[i].isSelected()){
                count2+=1;
                sb2.append(checkBoxList[i].getText());
                sb2.append(", ");
                if(count2==10){
                    sb2.append("...");
                    break;
                }
            }
        }
        
        UIManager.put("ToolTip.font", new Font("Tahoma", Font.BOLD, 18));
        
        if(lbDisplayCategory.getToolTipText() != null){
            lbDisplayCategory.setToolTipText(null);
        }
        
        if(count==0)
            lbDisplayCategory.setText("?");
        else{
            String category = sb.substring(0, sb.length()-2);
            if(count>10){
                lbDisplayCategory.setText("<html><p align=\"left\">"+sb2.toString()+"</p></html>");
                lbDisplayCategory.setToolTipText("<html><p width=\"300\">"+category+"</p></html>");
            }
            else
                lbDisplayCategory.setText("<html><p align=\"left\">"+category+"</p></html>");
        }
    }
    
    public JPanel optionPanel_1(JLabel lbDisplayCategory, JFrame frame){
        JPanel optionPanel_1 = new JPanel();
        optionPanel_1.setVisible(true);
        optionPanel_1.setLayout(new GridLayout(1,3,10,10));
        optionPanel_1.setBorder(BorderFactory.createCompoundBorder(optionPanel_1.getBorder(), BorderFactory.createEmptyBorder(5,140,10,140)));
        
        JButton buttonApply = new JButton();
        ImageIcon iconApply = new ImageIcon(System.getProperty("user.dir")+"/src/Images/Yes Mark.png");
        buttonApply.setIcon(iconApply);
        buttonApply.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                displayLBCategory(lbDisplayCategory);
                frame.dispose();
                frame.pack();
            }
        });
        JButton buttonDeselect = new JButton();
        ImageIcon iconRefresh = new ImageIcon(System.getProperty("user.dir")+"/src/Images/Refresh.png");
        buttonDeselect.setIcon(iconRefresh);
        buttonDeselect.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               for(JCheckBox checkBox : checkBoxList){
                   checkBox.setSelected(false);
               }
           } 
        });
        
        optionPanel_1.add(buttonApply);
        optionPanel_1.add(buttonDeselect);
        
        return optionPanel_1;
    }
    
    public JPanel optionPanel_2(JPanel categoryPanel, JLabel lbDisplayCategory, String[] categoryArray){
        JPanel optionPanel_2 = new JPanel();
        optionPanel_2.setVisible(true);
        optionPanel_2.setLayout(new GridLayout(1,2,10,10));
        optionPanel_2.setBorder(BorderFactory.createCompoundBorder(optionPanel_2.getBorder(), BorderFactory.createEmptyBorder(5,5,5,5)));
        
        JButton buttonNewCategory = new JButton();
        ImageIcon iconAdd = new ImageIcon(System.getProperty("user.dir")+"/src/Images/Plus.png");
        buttonNewCategory.setIcon(iconAdd);
        buttonNewCategory.setContentAreaFilled(false);
        buttonNewCategory.setText("(New Category)");
        buttonNewCategory.setFont(new Font("Tahoma", Font.BOLD,18));
        buttonNewCategory.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String category = JOptionPane.showInputDialog(null,"Enter category:");
                if(category!=null){
                    if(category.trim().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter the name of the new category!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        if(checkDuplicatedCategory(category.trim())==true){
                            JOptionPane.showMessageDialog(null, "Category already exists!","Alert!",JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        BookManagement.addCategory(category.trim());
                        JOptionPane.showMessageDialog(null, "New category added: "+"\""+category.trim()+"\"");
                        refreshCategoryPanel(categoryPanel, categoryArray);
                    }
                }
            }
        });
        
        JButton buttonRemoveCategory = new JButton();
        ImageIcon iconMinus = new ImageIcon(System.getProperty("user.dir")+"/src/Images/Minus.png");
        buttonRemoveCategory.setIcon(iconMinus);
        buttonRemoveCategory.setContentAreaFilled(false);
        buttonRemoveCategory.setText("(Remove Category)");
        buttonRemoveCategory.setFont(new Font("Tahoma", Font.BOLD,18));
        buttonRemoveCategory.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String category = JOptionPane.showInputDialog(null, "Enter category:");
                if(category!=null){
                    if(category.trim().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please enter the name of the category to remove!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    else{
                        if(checkDuplicatedCategory(category.trim())==false){
                            JOptionPane.showMessageDialog(null, "Category doesn't exist!","Alert!",JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        BookManagement.removeCategory(category.trim());
                        JOptionPane.showMessageDialog(null, "Category removed: "+"\""+category.trim()+"\"");
                        refreshCategoryPanel(categoryPanel, categoryArray);
                        displayLBCategory(lbDisplayCategory);
                    }
                }
            }
        });
        
        optionPanel_2.add(buttonNewCategory);
        optionPanel_2.add(buttonRemoveCategory);
        
        return optionPanel_2;
    }
    
    public void setVisible(boolean bl){
        categoryFrame.setVisible(bl);
    }
    
    public CategoryFrame(JLabel lbDisplayCategory, JFrame frame, String[] categoryArray){
        checkBoxList = checkBoxCategoryList();
        categoryFrame = new JFrame();
        categoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        categoryFrame.setTitle("Book Category");
        categoryFrame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                frame.setEnabled(true);
                frame.requestFocus();
            }
        });
        
        JPanel categoryPanel = categoryPanel(categoryArray);
        JPanel optionPanel_1 = optionPanel_1(lbDisplayCategory, categoryFrame);
        JPanel optionPanel_2 = optionPanel_2(categoryPanel, lbDisplayCategory, categoryArray);
        
        categoryFrame.add(categoryPanel, BorderLayout.CENTER);
        categoryFrame.add(optionPanel_1,BorderLayout.PAGE_END);
        categoryFrame.add(optionPanel_2, BorderLayout.PAGE_START);
        
        categoryFrame.pack();
        categoryFrame.setLocationRelativeTo(null);
        categoryFrame.setResizable(false);
        
        displayCBCategory(categoryArray);
    }
}
