/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentelsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Keshaw
 */
public class dbconn {
     public Connection con= null;
    public Statement st=null;
    public ResultSet rs=null;
    public void loaddriver (){
        try {
          Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public void connection (){
        try
        {
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","car","car");
            st=con.createStatement();
        }
          catch(SQLException ex)
          {
              JOptionPane.showMessageDialog(null, ex.getMessage());
          }    
    }
    public void fetch(String qry){
        try{
              rs=st.executeQuery(qry); 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
