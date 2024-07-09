
package employee.management.system;

//importojme klasat e gatshme
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//klasa trashegon te gjitha metodat dhe vetite e klase JFrame si dhe trajton ngjarjet nga veprimet e perdoruesit
public class Paraqitje  extends JFrame implements ActionListener{
    
    //krijohet dritarja Paraqitje me sfond te brendshem te bardhe
    //vendoset nje paraqitje e re pa ndonje lloj formesimi te caktuar.lejon elementet e tjere re vendosen dhe pozicionhen manualisht ne dritare
    Paraqitje(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        //JLabel etiketat per  panelin sistemi i menaxhimit te punonjesve
        JLabel heading=new JLabel ("SISTEMI I MENAXHIMIT TE PUNONJESVE");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 50));
        heading.setForeground(Color.RED);
        add(heading);
        
        //krijohet  nje etikete ne class  qe i jep asaj nje imazh duke perdorur objektin ImageIcon nga dosja fifth.png ne direktorine IMAGEPastaj 
        //vendosen dimensionet.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("IMAGE/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);

        //krijohet  nje buton te cilit i vendosim dimensionet dhe ngjyrat,eshte i lidhur me actionListener
        //qe do te thote se do nodhe nje ngjarje kur te klikohet
        JButton Kliko = new JButton ("KLIKON KETU PER TE VAZHDUAR");
        Kliko.setBounds(400, 400, 300, 70);
        Kliko.setBackground(Color.BLACK);
        Kliko.setBackground(Color.WHITE);
        Kliko.addActionListener(this);
        add(Kliko);

        //vendosen permasat e dritares
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
        
        //krijohet nje cikel i pafund me dy blloqe try & catch qe ndryshon dukshmerine e nje etikete heading.
        //fillimishte etiketa behet e padukshme  per 500 milisekonda pastaj e dukshme po per 500 milisekonda
        while(true) {
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            } catch (Exception e){
                
            }
            
            heading.setVisible(true);
             try{
                Thread.sleep(500);
            } catch (Exception e){
                
            }
            
        }
    }
    
    //medota actionPerformed ekzekutohet kur ndodh nje veprim/event i caktuar.Kur metoda thirret klasa behet e padukshme me medoden setVisible(false)
    //kur shfaqet dritarja e re login dritarja akruale behet e padukshme
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
        
        
    }
    //metoda main fillon ekzekutimin e programit,inicializohet klasa paraqitje.Dritarja e kesaj klase do shfaqet kur programi te ekzekutohet.
    public static void main(String args[]){
    new Paraqitje();
        
        
    }
    
}
