/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amitylibrary;

/**
 *
 * @author anchal
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Catalogue extends JFrame implements ActionListener{
    JLabel label= new JLabel("BOOK DETAILS");
        Container content=getContentPane();
        JButton b1=new JButton("Back");
        JTable t1;
        public Catalogue()
        {
            setBackground(Color.CYAN);
            setSize(1000,500);
            content.setLayout(null);
            String[] columns={"Serial No.","Name of the Book","Author"};
            Object[][] info={{"1","Gulliver's Travels","Jonathan Swift"},
                            {"2","Pride and Prejudice","Jane Austen"},
                            {"3","The Complete Reference","Herbert Schildt"},

                            };
            t1 = new JTable(info,columns);
            t1.setPreferredScrollableViewportSize(new Dimension(500,100));
            t1.setFillsViewportHeight(true);
            t1.setEnabled(false);
            JScrollPane scrollPane = new JScrollPane(t1);
            scrollPane.setBounds(100, 150, 800, 200);
            content.add(scrollPane);
            label.setBounds(435,100,200,30);
            b1.setBounds(455,375,100,30);
            label.setFont(new Font("Times New Roman",Font.BOLD,20));
            content.add(label);
            content.add(b1);
            b1.addActionListener(this);
        }
       
        public void actionPerformed(ActionEvent ae) {
            new AmityLibrary().setVisible(true);
                this.setVisible(false);
        }
           public static void main(String[] args) {
                 new Catalogue().setVisible(true);			
	}
}