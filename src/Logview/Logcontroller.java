/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logview;

import crud.DB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Louie
 */
public class Logcontroller {
    Logview lv;
    DB db = new DB();
    //public DefaultTableModel model = new DefaultTableModel();
    
    public Logcontroller(Logview lv){
        this.lv = lv;
        //lv.allListener(new ActionBtn());
        //lv.allListener(new Mouse());
    }
    /*
    class ActionBtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == lv.refresh){
                lv.setVisible(false);
                System.out.println("Clicked");
                //lv.setVisible(true);
            }
        }
        /*
         public void actionPerformed(ActionEvent e){
             if(e.getSource() == lv.update){
                 DB db = new DB();
                 //db.update();
                 
             }
         }
        */
    //}
    
    /*
    public void mouse(){
        int selected = lv.jTable.getSelectedRow();
        lv.dateTextField.setText(db.m.getValueAt(selected, 1).toString());
    }*/
    /*
    class Mouse implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent arg0) {
            int selected = lv.jTable.getSelectedRow();
            lv.dateTextField.setText(db.m.getValueAt(selected, 1).toString()); 
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }*/
    
}
