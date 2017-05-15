
package Usuarios.RolAdministrador;

import Usuarios.Administrador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import sql.conexion;

public class VerInventario extends javax.swing.JFrame {
conexion con = new conexion();
Connection cn = con.conexion();
DefaultTableModel tabla;

    public VerInventario() {
        initComponents();
        cargarlistaproductos("");
    }

         String comparar(String cod)
    {
        String cant="";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM productos WHERE pro_nombre='"+cod+"'");
            while(rs.next())
            {
                cant=rs.getString(4);
            }
            
        } catch (SQLException ex) {
            System.out.println("ERROR al cargar los datos"+ex);
        }
        return cant;
        
    }
     void cargarlistaproductos(String dato){
        String [] Titulo = {"CODIGO","PRODUCTO","NOMBRE","EXISTENCIA"};
        tabla=new DefaultTableModel(null,Titulo);
    String []Registro= new String[3];
    String mostrar="SELECT * FROM productos WHERE CONCAT (pro_nombre) LIKE '%"+dato+"%'"; 
    Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs =st.executeQuery(mostrar);
            while(rs.next())
            {
                Registro[0]=rs.getString("pro_codigo");
                Registro[1]=rs.getString("pro_nombre");
                Registro[2]=rs.getString("pro_stock");
                
                tabla.addRow(Registro);
            }
            tblInventario.setModel(tabla);
        } catch (SQLException ex) {
            System.out.println("ERROR... Al Cargar los Datos"+ex);
        }
    
    
    
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPro = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INVENTARIO");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("INVENTARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 11, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblInventario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tblInventario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CODIGO DE PRODUCTO", "NOMBRE", "EXISTENCIA"
            }
        ));
        jScrollPane1.setViewportView(tblInventario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 794, 492));

        jButton1.setText("CERRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 581, -1, -1));

        jLabel2.setText("BUSCAR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 42, -1, -1));

        txtPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProKeyReleased(evt);
            }
        });
        getContentPane().add(txtPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 39, 188, 26));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProKeyReleased
          cargarlistaproductos(this.txtPro.getText());
    }//GEN-LAST:event_txtProKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VerInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtPro;
    // End of variables declaration//GEN-END:variables
}
