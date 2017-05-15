
package sql;

import java.sql.*;
import javax.swing.JOptionPane;

public class conexion {
    Connection conect = null;
    
    public Connection conexion(){
    try{
    Class.forName("org.gjt.mm.mysql.Driver");
    conect = DriverManager.getConnection("jdbc:mysql://localhost/sig","root","");
    //System.out.println("Conexion Exitosa");
        }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, "error en la conexion a INTERNET");
    }
    return conect;
}
    
}