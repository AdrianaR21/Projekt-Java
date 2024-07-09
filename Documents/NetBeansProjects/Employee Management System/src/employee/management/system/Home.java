
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//trashegohen vecorite dhe metodat e JFrame dhe trajtohen ngjarjet nga veprimet e perdoruesit
public class Home extends JFrame implements ActionListener {
    
    //deklarohen kate variabla te tipit JButton
    JButton add, view, update, remove;
    
    //krijohet dritarja home me nje paraqitje te lire te elementeve
    Home(){
        
        setLayout(null);
      
        //krijohet  nje etikete ne class qe i jep asaj nje imazh duke perdorur objektin ImageIcon nga dosja second.png ne direktorine IMAGEPastaj 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("IMAGE/second.png"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        //etiketa panelit
        JLabel heading = new JLabel("Sistemi i menaxhimit te punonjesve");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("serif", Font.BOLD,25));
        image.add(heading);
        
        //krijohet nje objekt JButton me emrin add.Butoni eshte shtuar ne nje kontenier te quajtur image.ActionListener ka reagim kur butoni klikohet
        add= new JButton ("Shto punonjes");
        add.setBounds(650, 80, 150,40);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton ("Shiko punonjesit");
        view.setBounds(820, 80, 150,40);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton ("Perditeso punonjesit");
        update.setBounds(650, 140, 150,40);
        update.addActionListener(this);
        image.add(update);
        
        
        remove = new JButton ("Fshij punonjesin");
        remove.setBounds(820, 140, 150,40);
        remove.addActionListener(this);
        image.add(remove);
        

        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
        
    }
    
    //actionPerformed ekzekutohet kur ndodh nje veprim i caktuar
    public void actionPerformed(ActionEvent ae) {
        
        //cikle if qe na tregojne cdo te ndodhe nese klikohet dhe buton dhe cil dritare cdo te shfaqet
        if(ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        }else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
            
        }else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
            
        }else {
            setVisible (false);
            new RemoveEmployee();
            
        
    }
    }
    
    //main ben ekzekutimin e programit,Home inicializohet
    public static void main(String[] args){
        new Home();
        
        
    }
}

