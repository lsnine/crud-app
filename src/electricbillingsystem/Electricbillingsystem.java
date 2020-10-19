/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricbillingsystem; 
/**
 *
 * @author Louie
 */
public class Electricbillingsystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        electricbillingsystemModel ebsm = new electricbillingsystemModel();
        electricbillingsystemView ebsv = new electricbillingsystemView();
        new electricbillingsystemController(ebsv);
        ebsv.setVisible(true);
        /*
        electricbillingsystemModel ebsm = new electricbillingsystemModel();
        Timer timer = new Timer(); 
        TimerTask task = new Helper(); 

        timer.schedule(task, 1000, 1000); 
        */
        /*
            double x = ebsm.rate(9.61, 3600000);
            System.out.println(x);
            System.out.println(x*3600000);
        */
        /*
            double ac = 3.5;
            System.out.println(ac);
            double acH = ac * 4;
            System.out.println(acH);
            double pay = acH*9.61;
            System.out.println(pay);
            System.out.println(ebsm.hourToSecond(4));
            double acWS = ebsm.kiloWattToWatt(ac) * ebsm.hourToSecond(4);
            System.out.println(acWS);
            double paySec = ebsm.perSecond * acWS;
            System.out.println(paySec);
        */
    }
    
}
