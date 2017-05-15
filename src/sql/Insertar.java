
package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sql.conexion;

public class Insertar {
    
    conexion con = new conexion();
    Connection cn= con.conexion();
    public int tipo_U = 0;
//insertar cliente 
    public int insertar_cliente(String datos, String direccion, String telefono, String nit){
    int resultado = 0;
          String sql="INSERT INTO clientes (cli_nombre,cli_telefono,cli_direccion,cli_nit) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst  = cn.prepareStatement(sql);
            pst.setString(1, datos);
            pst.setString(2, telefono);
            pst.setString(3, direccion);
            pst.setString(4, nit);
            int n=pst.executeUpdate();
            if(n>0){
                resultado = 1;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR.."+ex);
            resultado = 0;
        }
    return resultado;
    }
    
//Insertar Nueva Categoria     
    public int insertar_categoria(String nombre){
    int resultado = 0;
          String sql="INSERT INTO categoria (Nombre) VALUES (?)";
        try {
            PreparedStatement pst  = cn.prepareStatement(sql);
            pst.setString(1, nombre);
            int n=pst.executeUpdate();
            if(n>0){
                resultado = 1;
            }
        } catch (SQLException ex) {
            resultado = 0;
        }
    return resultado;
    }
//Insertar Nueva Categoria de Cliente
    public int insertar_usuario(String datos, String direccion, String Telefono,
            String user, String password,int idTipo){
    int resultado = 0;
          String sql="INSERT INTO usuarios (us_datos, us_direccion, us_telefono,"
                  + "us_user, us_password,tipo_usuario_idtipo_usuario) VALUES (?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst  = cn.prepareStatement(sql);
            pst.setString(1, datos);
            pst.setString(2, direccion);
            pst.setString(3, Telefono);
            pst.setString(4, user);
            pst.setString(5, password);
            pst.setInt(6, idTipo);
    
            int n=pst.executeUpdate();
            if(n>0){
                resultado = 1;
            }
        } catch (SQLException ex) {
            resultado = 0;
        }
    return resultado;
    }

//insertar proveedor 
    public int insertar_proveedor(String datos, String direccion, String telefono){
    int resultado = 0;
          String sql="INSERT INTO proveedores (prov_datos,prov_direccion,pro_telefono) VALUES (?,?,?)";
        try {
            PreparedStatement pst  = cn.prepareStatement(sql);
            pst.setString(1, datos);
            pst.setString(2, direccion);
            pst.setString(3, telefono);
            int n=pst.executeUpdate();
            if(n>0){
                resultado = 1;
            }
        } catch (SQLException ex) {
            resultado = 0;
        }
    return resultado;
    }
    
    //Insertar Nueva Categoria     
    public int insertar_tp_usuario(String nombre){
    int resultado = 0;
          String sql="INSERT INTO tipo_usuario(tp_nombre) VALUES (?)";
        try {
            PreparedStatement pst  = cn.prepareStatement(sql);
            pst.setString(1, nombre);
            int n=pst.executeUpdate();
            if(n>0){
                resultado = 1;
            }
        } catch (SQLException ex) {
            resultado = 0;
        }
    return resultado;
    }
    
    //insertar compras
    public int insertar_compras(String fecha, int cantidadC, double precioCompra, int Proveedor,String producto){
        int resultado = 0;       
        double total = cantidadC * precioCompra;
          String sql="INSERT INTO compras (com_fecha, com_cantidad_compra,com_total,com_proveedores,pro_codigo) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst  = cn.prepareStatement(sql);
            pst.setString(1, fecha);
            pst.setInt(2, cantidadC);
            pst.setDouble(3, total);
            pst.setInt(4, Proveedor);
            pst.setString(5, producto);
            int n=pst.executeUpdate();
            if(n>0){
                resultado = 1;
            }
        } catch (SQLException ex) {
            resultado = 0;
        }       
       return resultado;
    }
    
    public int insertar_producto(String codigo,String nombre, int minimo, int idcategoria){
    int resultado = 0;       
          String sql="INSERT INTO productos (pro_codigo,pro_nombre, pro_stock_minimo,Categoria_idCategoria) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst  = cn.prepareStatement(sql);
            pst.setString(1,codigo);
            pst.setString(2, nombre);
            pst.setInt(3, minimo);
            pst.setInt(4, idcategoria);
            int n=pst.executeUpdate();
            if(n>0){
                resultado = 1;
            }
        } catch (SQLException ex) {
            resultado = 0;
        }
    
    
    
    return resultado;
    }
   
    public int maxID(){  
        int Resultado = 0;
        String SQL = "SELECT MAX(idcompras) as id from compras";
        
        try {
            Connection cn = con.conexion();//prepara la conexion
            Statement st = cn.createStatement();//crea la instancia
            ResultSet rs = st.executeQuery(SQL);//ejecuta la instrucion de SQL
            
            while(rs.next()){//verificamos el resultado
            Resultado = rs.getInt("id");
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(sql_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Resultado;
    }

    public int actualizarProductos(String idproducto, int stock, double precioCompra, double precioventa){
    int resultado = 0;
         String sql="UPDATE productos SET pro_stock = pro_stock +"+stock+" ,pro_PrecioCompra= "+precioCompra+",pro_precioVenta="+precioventa+" WHERE pro_codigo= "+idproducto+""; 
    try {
        PreparedStatement pst = cn.prepareStatement(sql);
      int n =  pst.executeUpdate();
      if(n>0){
      resultado = 1;
      }
    } catch (Exception e) {
        System.out.println("ERROR..."+idproducto+" "+e);
      resultado = 0;
    }
    
    
    return resultado;
    }
}
