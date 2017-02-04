
package sql;
import sql.conexion;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class sql_Login {
    public int tipo_U = 0;
    public static int id_usuario =0;
    conexion con = new conexion();
    
    public int login(String usuario, String password){  
        int Resultado = 0;
        String SQL = "SELECT * FROM usuarios WHERE Us_user='"+usuario+"'and Us_password='"+password+"'";
        
        try {
            Connection cn = con.conexion();//prepara la conexion
            Statement st = cn.createStatement();//crea la instancia
            ResultSet rs = st.executeQuery(SQL);//ejecuta la instrucion de SQL
            
            while(rs.next()){//verificamos el resultado
            Resultado = 1;
            id_usuario = rs.getInt("idUsuarios");
            tipo_U = rs.getInt("tipo_usuario_idtipo_usuario");
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(sql_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Resultado;
    }
}
