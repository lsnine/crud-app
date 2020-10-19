/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Louie
 */
/*
public class Insert implements Interface{

    @Override
    public void crud(String date, double kwh, double payment) {
        try {
            DB.stmt = DB.conn.createStatement();
            String query = " INSERT INTO log (date, kwh, payment)"+" VALUES (?,?,?)";
            PreparedStatement pstm = DB.conn.prepareStatement(query);
            //DB.pstm = DB.conn.prepareStatement(query);
            pstm.setString(1, date);
            pstm.setDouble(2, kwh);
            pstm.setDouble(3, payment);
            pstm.executeUpdate();
            /*
            String query = " INSERT INTO log (date, kwh, payment) VALUES (?,?,?)";
            DB.pstm = DB.conn.prepareStatement(query);
            DB.pstm.setString (1, date);
            DB.pstm.setDouble (2, kwh);
            DB.pstm.setDouble(3, payment);
            
        }catch (Exception e) {
                //System.err.println("Got an exception!");
                //System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                DB.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
    
}
*/

