
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

 //trashegohen vecorite dhe metodat e JFrame dhe trajtohen ngjarjet nga veprimet e perdoruesit
public class ViewEmployee extends JFrame implements ActionListener{
    
    //deklaron komponente te ndryshem per nderfaqen grafike.
    JTable table;
    Choice cemployeeId;
    JButton search, print, update, back;
    
    
    //krijohet dritarja ViewEmployee me sfond te brendshem te bardhe
    //vendoset nje paraqitje e re pa ndonje lloj formesimi te caktuar.lejon elementet e tjere re vendsen dhe pozicionhen manualisht ne dritare
    ViewEmployee() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //choice eshte nje zgjedhes qe lejon perdoruesin te zgjedhe nga nje liste opsionesh
        JLabel searchlb = new JLabel ("Perditeso ID e punonjesit");
        searchlb.setBounds(20, 20, 150, 20);
        add(searchlb);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        //merr te dhenat nga tabela employe ne databaze  dhe i shton ne choice .lejon perdoruesin te zgedhe nje id nga lista e te dhenave
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employe");
            while(rs.next()) {
                cemployeeId.add(rs.getString("id"));
                
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        
        //krijohet nje JTable dhe mbushet me te dhenat e marra nga tabela employe.pastaj perdoret metoda setModelper te vendosur modelin e te dhenave
        //tek resultSet ne JTablekjo paraqet te dhenat e punonjesve ne tabelen grafike te aplikacionit
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employe");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            


        }catch (Exception e) {
            e.printStackTrace();
        }
        
        //shtojme nje JScrollPane per ta bere tabelen te shfletueshme.na lejon te shikojme te gjitha te dhenat e tabeles se punonjesve
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        //krijohet butoni search
        search = new JButton ("Kerko");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton ("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton ("Perditeso");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton ("Kthehu");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
        
        
    }
    
    //me metoden actionPerformedkontrollojme cilin buton ka shtypur perdoruesi duke perdoru metoden getSource
    //me search krijohet nje query per te marre te dhenat e punonjesit me id e zgjedhur
    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource() == search) {
            String query = "select * from empoye where id='"+cemployeeId.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch (Exception e) {
                e.printStackTrace();
            }
         //printohet tabela           
        }else if (ae.getSource() == print){
            try {
               table.print(); 
            }catch (Exception e) {
                e.printStackTrace();
            }
          //fshihet dritarja aktuale dhe ahpet nje dritare aktuale per te perditesuar te dhenat e punonjesit  
        }else if (ae.getSource() == update){
            setVisible(false);
            new UpdateEmployee (cemployeeId.getSelectedItem());
            
          //Nese nuk shtypim asnje buton hapet faqja kryesore  
        }else{
            setVisible(false);
            new Home();
            
        }
        
    }
    
    //main ben ekzekutimin e programit,ViewEmployee inicializohet
    public static void main (String[] args) {
        new ViewEmployee();
        
        
    }
    
}
