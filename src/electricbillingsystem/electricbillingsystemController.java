/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricbillingsystem;

import Logview.Logcontroller;
import Logview.Logview;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import crud.*;
import javax.swing.JTable;


/**
 *
 * @author Louie
 */
public class electricbillingsystemController {
    int k = 1;
    int k2 = 1;
    int k3 = 1;
    int k4 = 1;
    double total = 0;
    double rate = 0;
    String totalAC = "0";
    String totalTV = "0";
    String totalFan = "0";
    String totalBulb = "0";
    double totalACDouble = 0;
    double totalTVDouble = 0;
    double totalFanDouble = 0;
    double totalBulbDouble = 0;
    //DefaultTableModel
    
    Timer timerAC = new Timer(1000, new ActionListener(){
        public void actionPerformed (ActionEvent e){
             ebsv.timeAC.setText(String.valueOf(k) + "");
             ++k;
        }
    });
    Timer timerTV = new Timer(1000, new ActionListener(){
        public void actionPerformed (ActionEvent e){
             ebsv.timeTV.setText(String.valueOf(k2) + "");
             ++k2;
        }
    });
    Timer timerFan = new Timer(1000, new ActionListener(){
        public void actionPerformed (ActionEvent e){
             ebsv.timeFan.setText(String.valueOf(k3) + "");
             ++k3;
        }
    });
    Timer timerBulb = new Timer(1000, new ActionListener(){
        public void actionPerformed (ActionEvent e){
             ebsv.timeBulb.setText(String.valueOf(k4) + "");
             ++k4;
        }
    });
    electricbillingsystemModel ebsm = new electricbillingsystemModel();
    electricbillingsystemView ebsv;
    public electricbillingsystemController(electricbillingsystemView ebsv){
        this.ebsv = ebsv;
        ebsv.allListener(new ActionBtn());
        //totalAC = ebsv.consumptionAC.getText();
        
    }
    
    
    
    
    class ActionBtn implements ActionListener{
        //int k = 0;
         @Override
         public void actionPerformed(ActionEvent e){
             
                if(e.getSource() == ebsv.onAC){
                    timerAC.start();
                }
                if(e.getSource() == ebsv.offAC){
                    timerAC.stop();
                    String stopAC = ebsv.timeAC.getText();
                    int stopACInt = Integer.parseInt(stopAC);
                    double kWhAC = ebsm.kilowattHourConverter(ebsm.airConkW, stopACInt);
                    double multiplierAC = ebsm.multiplyWatt(kWhAC);
                    ebsv.consumptionAC.setText(String.format("%.8f", multiplierAC));
                    totalAC = ebsv.consumptionAC.getText();
                }
                if(e.getSource() == ebsv.onTV){
                    timerTV.start();
                }
                if(e.getSource() == ebsv.offTV){
                    timerTV.stop();
                    String stopTV = ebsv.timeTV.getText();
                    int stopTVInt = Integer.parseInt(stopTV);
                    double kWhTV = ebsm.kilowattHourConverter(ebsm.tvkW, stopTVInt);
                    double multiplierTV = ebsm.multiplyWatt(kWhTV);
                    ebsv.consumptionTV.setText(String.format("%.8f", multiplierTV));
                    totalTV = ebsv.consumptionTV.getText();
                }
                if(e.getSource() == ebsv.onFan){
                    timerFan.start();
                }
                if(e.getSource() == ebsv.offFan){
                    timerFan.stop();
                    String stopFan = ebsv.timeFan.getText();
                    int stopFanInt = Integer.parseInt(stopFan);
                    double kWhFan = ebsm.kilowattHourConverter(ebsm.fankW, stopFanInt);
                    double multiplierFan = ebsm.multiplyWatt(kWhFan);
                    ebsv.consumptionFan.setText(String.format("%.8f", multiplierFan));
                    totalFan = ebsv.consumptionFan.getText();
                }
                if(e.getSource() == ebsv.onBulb){
                    timerBulb.start();
                }
                if(e.getSource() == ebsv.offBulb){
                    timerBulb.stop();
                    String stopBulb = ebsv.timeBulb.getText();
                    int stopBulbInt = Integer.parseInt(stopBulb);
                    double kWhBulb = ebsm.kilowattHourConverter(ebsm.bulbkW, stopBulbInt);
                    double multiplierBulb = ebsm.multiplyWatt(kWhBulb);
                    ebsv.consumptionBulb.setText(String.format("%.8f", multiplierBulb));
                    totalBulb = ebsv.consumptionBulb.getText();
                }
                double totalACDouble = Double.parseDouble(totalAC);
                double totalTVDouble = Double.parseDouble(totalTV);
                double totalFanDouble = Double.parseDouble(totalFan);
                double totalBulbDouble = Double.parseDouble(totalBulb);
                double totalAppliances = ebsm.addUp(totalACDouble, totalTVDouble, totalFanDouble, totalBulbDouble);
                ebsv.total.setText(String.format("%.8f", totalAppliances));
                double rate = totalAppliances * ebsm.rate;
                ebsv.pesos.setText(String.format("%.2f", rate));
                
                if(e.getSource() == ebsv.insertBtn){
                    //Logview log = new Logview();
                    //Logcontroller lc = new Logcontroller(log);
                    
                    DB db = new DB();
                    double kWh = Double.parseDouble(ebsv.total.getText());
                    double payment = Double.parseDouble(ebsv.pesos.getText());
                    db.insert(ebsm.date(),kWh,payment);
                    //db.select();
                    //log.jTable.setModel(lc.model);
                }
                if(e.getSource() == ebsv.viewBtn){
                    Logview log = new Logview();
                    //Logcontroller lc = new Logcontroller(log);
                    DB db = new DB();
                    //log.jTable = new JTable(lc.model);
                    db.select();
                    //log.setVisible(true);
                }
            
         }
    }
    
}
