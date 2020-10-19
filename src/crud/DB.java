/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;
import Logview.Logcontroller;
import Logview.Logview;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Louie
 */
public class DB {
    Logview lv = new Logview();
    //Logcontroller lc = new Logcontroller(lv);
    public DefaultTableModel m;

    //public DefaultTableModel model = new DefaultTableModel();
    static String JDBC_DRIVER;
    static String DB_URL;

    static Connection conn;
    static Statement stmt;
    static PreparedStatement pstm;

    // DataBase Credential
    static String USER;
    static String PASS;

    public DB() {
        //this.lc = new Logcontroller(lv);
            
            JDBC_DRIVER = "com.mysql.jdbc.Driver";
            DB_URL = "jdbc:mysql://localhost:3306/electricitylog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

            // Database Credentials
            USER = "root";
            PASS = "!overthirteenis076923";

            try {
                    // Registering JDBC Driver
                    //Class.forName(JDBC_DRIVER);
                    // Opening a Connection
                    System.out.println("Connecting to Database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    System.out.println("Connected!\n");
            } catch (Exception ex) {
                    ex.printStackTrace();
            }
    }
    public void insert(String date, double kwh, double payment){
        try {
            stmt = conn.createStatement();
            String query = " INSERT INTO log (date, kwh, payment)"+" VALUES (?,?,?)";
            pstm = conn.prepareStatement(query);
            //DB.pstm = DB.conn.prepareStatement(query);
            pstm.setString(1, date);
            pstm.setDouble(2, kwh);
            pstm.setDouble(3, payment);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserted Successfully");
        }catch (Exception e) {
                //System.err.println("Got an exception!");
                //System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, e);
        } 
    }
    
    
    public void select(){
        //DefaultTableModel m = new DefaultTableModel();
        //lv.jTable = new JTable(m);
        
                //lv.jTable.setModel(model);
        //Logcontroller lc = new Logcontroller(lv);
        try {
            pstm = conn.prepareStatement("SELECT * FROM log");
            ResultSet Rs = pstm.executeQuery();
            int row= 0;
            while(Rs.next()){
                String id = String.valueOf(Rs.getInt("id"));
                String date = Rs.getString("date");
                String kWh = String.valueOf(Rs.getDouble("kwh"));
                String payment = String.valueOf(Rs.getDouble("payment"));
                String data[] = {id,date,kWh,payment};
                JTable t = lv.jTable;
                m = (DefaultTableModel)t.getModel();
                m.addRow(data);
                //m.addRow(new Object[]{date,kWh,payment});
                //lv.jTable.setModel(m);
               
                //lv.jTable.setRowHeight(row,50);
                row = row+1;
                lv.setVisible(true);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public void update(int id, String date, double kwh, double payment){
        try {
                    stmt = conn.createStatement();
                    int row = lv.jTable.getSelectedRow();
                    
                    String sql = "UPDATE log SET date='"+date+"', kwh="+kwh+", payment="+payment+" WHERE id ="+id;
                    pstm = conn.prepareStatement(sql);
                    pstm.execute();
                    m = (DefaultTableModel)lv.jTable.getModel();
                    m.setRowCount(0);
                    JOptionPane.showMessageDialog(null, "Record Successfully Updated");
                    //lv.setVisible(false);
                    //select();

            } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
            } 
    }
    public void delete(int row, String cell){
        
        
        try{
            
            String sql = "DELETE FROM log where id = " + cell;
            pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            m = (DefaultTableModel)lv.jTable.getModel();
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
