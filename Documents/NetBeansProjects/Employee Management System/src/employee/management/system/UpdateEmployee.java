
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

//trashegohen vecorite dhe metodat e JFrame dhe trajtohen ngjarjet nga veprimet e perdoruesit
public class UpdateEmployee extends JFrame implements ActionListener {
    

    //deklaron komponente te ndryshem per nderfaqen grafike.
    JTextField tfshkollimi, tffname,tfrroga,tfadresa,tfnrtel,tfemail,tfsurname;
    JLabel lblempId;
    JButton add,back;
    String empId;
    
    //vendosim id e punonjesit ne variablin empId dhe ndryshihet ngjyra sfondit
    UpdateEmployee(String empId) {
        this.empId=empId;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //krijohet etiketa per panelin detaje per shtimin r punonjesve
        JLabel heading = new JLabel("Detaje per shtimin e punonjesve");
        heading.setBounds(220, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD,25));
        add(heading);
        
        //etiketa per panelin  name
        JLabel name =  new JLabel("Emri");
        name.setBounds(50,150, 150, 30);
        name.setFont(new Font("serif",Font.PLAIN, 20));
        add(name);
        
        //krijohet etiketa lblname pa tekst
        JLabel lblname = new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        //etiketa per panelin fname
        JLabel fname =  new JLabel("Emri i babait");
        fname.setBounds(400,150, 150, 30);
        fname.setFont(new Font("serif",Font.PLAIN, 20));
        add(fname);
        
        //fusha tekstit
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel rroga =  new JLabel("Rroga e punonjesit");
        rroga.setBounds(50,200, 150, 30);
        rroga.setFont(new Font("serif",Font.PLAIN, 20));
        add(rroga);
        
        tfrroga = new JTextField();
        tfrroga.setBounds(200,200,150,30);
        add(tfrroga);
        
        JLabel adresa =  new JLabel("Adresa e punonjesit");
        adresa.setBounds(400,200, 150, 30);
        adresa.setFont(new Font("serif",Font.PLAIN, 20));
        add(adresa);
        
        tfadresa = new JTextField();
        tfadresa.setBounds(600,200,150,30);
        add(tfadresa);
        
        JLabel nrtel =  new JLabel("Numri telefonit");
        nrtel.setBounds(50,250, 150, 30);
        nrtel.setFont(new Font("serif",Font.PLAIN, 20));
        add(nrtel);
        
        tfnrtel = new JTextField();
        tfnrtel.setBounds(200,250,150,30);
        add(tfnrtel);
        
        JLabel email =  new JLabel(" Email i punonjesit");
        email.setBounds(400,250, 150, 30);
        email.setFont(new Font("serif",Font.PLAIN, 20));
        add(email);
        
        JTextField tfemail = new JTextField();
        tfemail.setBounds(600,250,150,30);
        add(tfemail);
        
        JLabel shkollimi =  new JLabel("Shkollimi punonjesit");
        shkollimi.setBounds(50,300, 150, 30);
        shkollimi.setFont(new Font("serif",Font.PLAIN, 20));
        add(shkollimi);
        
        tfshkollimi = new JTextField();
        tfshkollimi.setBounds(200,300,150,30);
        add(tfshkollimi);
        
        JLabel surname =  new JLabel("Mbiemri punonjesit");
        surname.setBounds(50,350, 150, 30);
        surname.setFont(new Font("serif",Font.PLAIN, 20));
        add(surname);
        
        tfsurname = new JTextField();
        tfsurname.setBounds(200,350,150,30);
        add(tfsurname);
        
        JLabel labelempI =  new JLabel("ID punonjesit");
        labelempI.setBounds(400,350, 150, 30);
        labelempI.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelempI);
        
        lblempId = new JLabel();
        lblempId.setBounds(600,350,150,30);
        add(lblempId);
        
        //kryejme nje pyetje bate te ID se punonjesit per te marre te dhenat nga tabela employe
        //pastaj perdorim te dhenat e marra per te vedosur vlerat per etiketat  dhe fushat e tekstit ne aplikacion
        //nesa ka ndonje gabim ai shfaqet ne konsole
        try{
            Conn c = new Conn();
            String query = "Select * from employe where empId='"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                tfrroga.setText(rs.getString("rroga"));
                tfadresa.setText(rs.getString("adresa"));
                tfnrtel.setText(rs.getString("nrtel"));
                tfemail.setText(rs.getString("email"));
                tfshkollimi.setText(rs.getString("shkollimi"));
                tfsurname.setText(rs.getString("surname"));
                lblempId.setText(rs.getString("empId"));

            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        //krijohet butoni perditeso detajet
        add= new JButton ("Perditeso detaje");
        add.setBounds(250, 550, 150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        //butoni kthehu
        back= new JButton ("Kthehu");
        back.setBounds(450, 550, 150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);  
        setVisible(true);

    }
    //kur butoni add eshte klikuar marrim vlerat nga fushat e tekstit
    public void  actionPerformed (ActionEvent ae) {
        if(ae.getSource() == add) {
            
            String fname = tffname.getText();
            String rroga = tfrroga.getText();
            String adresa = tfadresa.getText();
            String nrtel = tfnrtel.getText();
            String email = tfemail.getText();
            String shkollimi = tfshkollimi.getText();
            String surname = tfsurname.getText();
            
            //perditesohen te dhenat e punonjesit  ne bazen e te dhenave.Nese perditesime eshte i susksesshem shaqet ne mesazh.Nese ka ndonje gabim shfaqet ne konsole
            try{
                Conn conn = new Conn();
                String query = "update employe set fname = '"+fname+"','"+fname+"',rroga = '"+rroga+"',adresa = '"+adresa+"',nrtel = '"+nrtel+"',email = '"+email+"',shkollomi = '"+shkollimi+"',surname='"+surname+"',where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Detajet u perditesuan me sukses");
                setVisible(false);
                new Home();
                
            }catch (Exception e) {
                e.printStackTrace();
                
            }

            
        }else {
            setVisible(false);
            new Home();
            
            
        }
    }
    

        //main ben ekzekutimin e programit,UpdateEmployee inicializohet
        public static void main(String[] args) {
            new UpdateEmployee("");
            
        }

        
        
    }

