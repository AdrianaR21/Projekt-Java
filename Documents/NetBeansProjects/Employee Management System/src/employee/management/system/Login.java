
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//trashegohen vecorite dhe metodat e JFrame dhe trajtohen ngjarjet nga veprimet e perdoruesit
public class Login extends JFrame implements ActionListener{
    
    //deklarohem dy variabla te tipit JTextField dhe JPasswordField dhe quhen pergakesisht tfuserneme dhe tfpassword
    JTextField tfusername;
    JPasswordField tfpassword;
    
    //krijohet dritarja login me sfond te brendshem te bardhe
    //vendoset nje paraqitje e re pa ndonje lloj formesimi te caktuar.lejon elementet e tjere re vendsen dhe pozicionhen manualisht ne dritare
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //etiketat per panelet
        JLabel username= new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);
        
        //fushat e tekstit per te dhenat e panelit
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
       
        
        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 30);
        add( tfpassword);
        
        //krijohet butoni Login i vendosen ngjyrat,dimensionet dhe lidhet me actionListener,ben qe te ndodhe nje ngjarje kur klikohet
        JButton Login = new JButton ("Login");
        Login.setBounds(150, 140, 150, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);
       
        //krijohet  nje etikete ne class  qe i jep asaj nje imazh duke perdorur objektin ImageIcon nga dosja sixth.png ne direktorine IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("IMAGE/sixth.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
        
    }
    
    //medota actionPerformed ekzekutohet kur ndodh nje veprim/event i caktuar
    public void actionPerformed (ActionEvent ae) {
        
        //kemi nje bllok try&catch.Behet verifikimi i te dhenave per dritaren e hyrjes login.
        //programi merr vlerat e shkruara dhe i kontrollon ne ne bazen e te dhenave per nje perdorues me te dhena te sakta.
        //nese gjendet perdoruesi dritarja Login behet e padukshme nese nuk gjendet shfaqet nje mesazh gabim
        try{
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            
            String query = "select * from login where username = '"+username+"'and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                
            }else {
                JOptionPane.showMessageDialog(null, "Username ose password i pavlefshem");
                setVisible(false);
                
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    //main fillon ekzekutimin e prgramit,inicializohet Login dritarja shfaqet kur programi ekzekutohet
    public static void main(String [] args) {
        new Login();
        
    }
    

}
