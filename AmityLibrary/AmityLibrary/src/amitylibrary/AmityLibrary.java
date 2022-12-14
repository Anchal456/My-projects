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
public class AmityLibrary extends JFrame implements ActionListener{
    private JPanel contentPane;
        JLabel l1;
        JButton b1,b2,b3;
        
        public AmityLibrary() {
            setBounds(100, 150, 600, 600);
                setLayout(null);
                setLocation(300,300);
        
		l1 = new JLabel(" ");
                l1.setBounds(100, 46, 500, 35);
                 l1.setForeground(new Color(204, 51, 102));
                 l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
                b1 = new JButton("Home");
                b2 =new JButton("Login/Signup");
                b3 =new JButton("Catalogue");
               
          ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("amitylibrary/image/library.jpg"));
           Image i3 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
              ImageIcon i2 = new ImageIcon(i3);
           l1 = new JLabel(i2);
            
                b1.setBounds(0,5,200,30);
                b2.setBounds(200,5,200,30);
                b3.setBounds(400,5,200,30);
		l1.setBounds(0, 100, 600, 400);
                
                l1.add(b1);
                l1.add(b2);
                l1.add(b3);
		add(l1);
               
                b1.addActionListener(this);
                b2.addActionListener(this);
                b3.addActionListener(this);
	}
        
        public void actionPerformed(ActionEvent ae){
            
            if(ae.getSource() == b1){
                this.setVisible(false);
                new AmityLibrary().setVisible(true);
            }
            if(ae.getSource() == b2){
                 this.setVisible(false);
                new Login().setVisible(true);
            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                new Catalogue().setVisible(true);
            }
                
        }
        
        public static void main(String[] args) {
                AmityLibrary window = new AmityLibrary();
                window.setVisible(true);			
	}
}
