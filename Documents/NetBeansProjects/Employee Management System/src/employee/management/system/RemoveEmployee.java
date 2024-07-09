
package employee.management.system;

//importojme klasat e gatshme
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

//trashegohen vecorite dhe metodat e JFrame dhe trajtohen ngjarjet nga veprimet e perdoruesit
public class RemoveEmployee extends JFrame implements ActionListener{
    
    //deklaron komponente te ndryshem per nderfaqen grafike.
    Choice cEmpId;
    JButton delete,back;
    
    //krijohet dritarja RemoveEmployee me sfond te brendshem te bardhe
    //vendoset nje paraqitje e re pa ndonje lloj formesimi te caktuar.lejon elementet e tjere re vendsen dhe pozicionhen manualisht ne dritare
    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //krijohet etiketa id e punonjesit
        JLabel labelempId = new JLabel("ID e punonjesit");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);
        
        //krijohet nje choice
        cEmpId =  new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        add(cEmpId);
        
        //marrim te dhenat e punonjesit nga tabela employe ne bazen e te dhenave pasi kodi ekzekutohet cEmpId do plotesohet me vlerat id te punonjesve
        try{
            Conn c = new Conn();
            String query= "select * from employe";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cEmpId.add(rs.getString("id"));
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        //etiketa per panelin labelname
        JLabel labelname = new JLabel("Emri");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        //etiketa lblname pa tekst
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        //etiketa per panelin labelnrtel
        JLabel labelnrtel = new JLabel("Numri telefonit");
        labelnrtel.setBounds(50, 150, 100, 30);
        add(labelnrtel);
        
        //etikeka lblnrtel pa tekst
        JLabel lblnrtel = new JLabel();
        lblnrtel.setBounds(200, 150, 100, 30);
        add(lblnrtel);
        
        //etiketa per panelin labelemail
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        //etiketa lblemail pa tekst
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 100, 30);
        add(lblemail);
        
        //merr te dhenat e punonjesit nga tabela employe duke perdorue id e zgjedhur nga cEmpId,pasi ekzekutohet kodi etiketa plotesohen automatikisht
        try{
            Conn c = new Conn();
            String query= "select * from employe where id = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblnrtel.setText(rs.getString("nrtel"));
                lblemail.setText(rs.getString("Email"));
                
                
                
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        //shtohet nje degjues ItemListeber ne cEmpId.Kur nje elemnt i zgjedhur ndrshon nje zgjedhje kodi brenda metodes itemStateChanged dp te ekzekutohet
        //ekzekutohet kodi etiketa plotesohen automatikisht
        cEmpId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie) {
                try{
            Conn c = new Conn();
            String query= "select * from employe where id = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblnrtel.setText(rs.getString("nrtel"));
                lblemail.setText(rs.getString("Email"));
                
                
                
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
                
            }
        } );
        
        //krijohet butoni fshij
        delete = new JButton("Fshij");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        //krijohet butoni kthehu
        back = new JButton("Kthehu");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        //krijohet  nje etikete ne class  qe i jep asaj nje imazh duke perdorur objektin ImageIcon nga dosja first.png ne direktorine IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("IMAGE/first.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
        
    }
    //nese shtypim butonin fshij ateher kodi fshin  te dhenat punonjesit ne id e zgjedhur ne te kundert dritarja fshihet
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete) {
            try{
                Conn c = new Conn();
                String query= "delete from employe where id = '"+cEmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Informacioni i punonjesit u fshi me sukses");
                setVisible(false);
                new Home();
                
                
                
            }catch (Exception e ) {
                e.printStackTrace();
            }
            
        }else {
            setVisible(false);
            
        }
    }
     //main ben ekzekutimin e programit,RemoveEmployee inicializohet
    public static void main(String[] args){
        new RemoveEmployee();
        
    }
        
}
                

