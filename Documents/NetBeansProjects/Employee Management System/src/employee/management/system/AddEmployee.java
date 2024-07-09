
package employee.management.system;

//importohen klasat e gatshme
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


//trashegohen vecorite dhe metodat e JFrame dhe trajtohen ngjarjet nga veprimet e perdoruesit
public class AddEmployee extends JFrame implements ActionListener{
    
    //krijohet nje instance e objektit random dhe nje variabel te tipit int te qajtur number.
    //metoda gjeneron nje numer te rastesishem nga 0 ne 99999 dhe e ruan ne variablin number
    Random ran = new Random();
    int number = ran.nextInt(900);
    
    //deklaron komponente te ndryshem per nderfaqen grafike.
    //perfshijne fushat e tekstit,nje ComboBox,nje etikete dhe dy butona
    JTextField tfname,tffname,tfrroga,tfadresa,tfnrtel,tfsurname,tfemail;
    JComboBox cbshkollimi;
    JLabel lblempId;
    JButton add,back;
    
    
    //krijohet dritarja AddEmployee me sfond te brendshem te bardhe
    //vendoset nje paraqitje e re pa ndonje lloj formesimi te caktuar.lejon elementet e tjere re vendsen dhe pozicionhen manualisht ne dritare
    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //etiketa panelit shto detajet e punonjesit
        JLabel heading = new JLabel ("Shto detajet e nje punonjesi");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        //etiketa emrit
        JLabel name = new JLabel("Emri");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);
        
        
        //fusha tekstit
        tfname=new JTextField();
        tfname.setBounds(200, 150, 150,30);
        add(tfname);
        
        JLabel fname = new JLabel("Emri babait");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);
        
        tffname=new JTextField();
        tffname.setBounds(600, 150, 150,30);
        add(tffname);
        
        JLabel rroga = new JLabel("Rroga punonjesit");
        rroga.setBounds(50, 200, 150, 30);
        rroga.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(rroga);
        
        tfrroga=new JTextField();
        tfrroga.setBounds(200, 200, 150,30);
        add(tfrroga);
        
        JLabel adresa = new JLabel("Adresa e punonjesit");
        adresa.setBounds(400, 200, 150, 30);
        adresa.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(adresa);
        
        tfadresa=new JTextField();
        tfadresa.setBounds(600, 200, 150,30);
        add(tfadresa);
        
        JLabel nrtel = new JLabel("Numri telefonit");
        nrtel.setBounds(50, 250, 150, 30);
        nrtel.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(nrtel);
        
        tfnrtel=new JTextField();
        tfnrtel.setBounds(200, 250, 150,30);
        add(tfnrtel);
        
        JLabel surname = new JLabel("Mbiemri");
        surname.setBounds(400, 250, 150, 30);
        surname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(surname);
        
        tfsurname=new JTextField();
        tfsurname.setBounds(600, 250, 150,30);
        add(tfsurname);
        
        JLabel email = new JLabel("Email i punonjesit");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);
        
        tfemail=new JTextField();
        tfemail.setBounds(200, 300, 150,30);
        add(tfemail);
        
        JLabel shkollimi = new JLabel("Shkollimi");
        shkollimi.setBounds(400, 300, 150, 30);
        shkollimi.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(shkollimi);
        
        //Klasa JComboBox eshte nje komponent swing qe ofron nje liste renese te artikujve qe perdoruesi do zgjedhe
        //deklarohet nje varg i tipit string  qe perban vlerat e dhena
        String courses[] = {"Gjimnaz","U.Bachelor","U.Master"};
        cbshkollimi=new JComboBox(courses);
        cbshkollimi.setBounds(600, 300, 150,30);
        add(cbshkollimi);
        
        JLabel empId = new JLabel("Emri");
        empId.setBounds(50, 350, 150, 30);
        empId.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empId);
        
        lblempId=new JLabel("" + number);
        lblempId.setBounds(200, 350, 150,30);
        add( lblempId);
        
        // //krijohet nje objekt JButton me emrin add.
        add= new JButton ("Shto detaje");
        add.setBounds(250, 400, 150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back= new JButton ("Kthehu");
        back.setBounds(450, 400, 150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        

        
        setSize(900, 7000);
        setLocation(300, 100);
        setVisible(true);
        
        
    }
    //metoda actionPerformed perpunon ngjarjet e klikimit te butonit add.Nese ai klikohetvariablat e fushave te tekstit merren si vlera
    //ruhen ne variablat e tyre perkates
    public void actionPerformed (ActionEvent ae) {
       if(ae.getSource() == add) {
           String name=tfname.getText();
           String fname=tffname.getText();
           String rroga=tfrroga.getText();
           String adresa=tfadresa.getText();
           String nrtel=tfnrtel.getText();
           String surname=tfsurname.getText();
           String email=tfemail.getText();
           String shkollimi=(String)cbshkollimi.getSelectedItem();
           String empId=lblempId.getText();
           
           //lidhje me bazen e te dhenave per te shtuar te dhena ne tabelen employe.Pas ekzekutimit shfaqet mesazh se detajet u shtuan me sukses
           //nese nuk shtypet butoni add hapet faqja home
           try{
               Conn conn = new Conn();
               String query=" insert into employe values ('"+name+"','"+fname+"','"+rroga+"','"+adresa+"','"+nrtel+"','"+surname+"'.'"+email+"','"+name+"','"+shkollimi+"','"+empId+"')";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Detajet u shtuan me sukses");
               setVisible(false);
               new Home();
               
               
           }catch (Exception e) {
               e.printStackTrace();
           }
           
       }else{
           setVisible(false);
           new Home();
           
       }
    }
    
     
    //main ben ekzekutimin e programit,AddEmployee inicializohet
    public static void main (String[] args) {
        new AddEmployee();
        
    }


    
}
