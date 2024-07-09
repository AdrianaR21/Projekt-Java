
package employee.management.system;


import java.sql.*;


//klasa Conn permban dy variabla c & s te tipit connection dhe statment.
public class Conn {
    
    Connection c;
    Statement s;
    
//krijohet konstruktori i klases Conn qe lidh me bazen e te dhenave dhe krijon nje objekt te lidhjes se bazes se te dhenave
    public Conn() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employemanagementsystem","root","0987654321");
            
             s=c.createStatement();
            
            
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
