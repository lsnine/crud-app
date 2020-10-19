/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricbillingsystem;
//import java.util.Timer; 
//import java.util.TimerTask; 
import java.util.Timer;
import java.util.TimerTask;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

/**
 *
 * @author Louie
 */
/*
class Helper extends TimerTask 
{ 
    public static int i = 0; 
    public void run() 
    { 
        System.out.println("Timer ran " + ++i); 
    } 
} 
*/
  



public class electricbillingsystemModel {
    //DecimalFormat dc = new DecimalFormat("0.00");
    
    double rate = 11;
    electricbillingsystemView ebsv;
    public double airConkW = 0.750;
    public double tvkW = 0.240;
    public double fankW = 0.075;
    public double bulbkW = 0.060;
    public double perSecond = rate / 3600000;
    public int multiplier = 3600000;
    public double wattToKiloWatt(double watt){
        return watt / 1000;
    }
    public double kiloWattToWatt(double kiloWatt){
        return kiloWatt * 1000;
    }
    public double hourToSecond(double hour){
        double minuteInHour = 60;
        double secondInMinute = 60;
        return hour * minuteInHour * secondInMinute;
    }
    public double secondToHour(int second){
        double minuteInHour = 60;
        double secondInMinute = 60;
        return second * (1/secondInMinute) * (1/minuteInHour);
    }
    public double wattSecondConverter(double kilowatt, double hour){
        return kiloWattToWatt(kilowatt) * hourToSecond(hour);
    }
    public double wattSecond(double watt, int second){
        return watt * second;
    }
    public double kilowattHourConverter(double watt, int second){
        return wattToKiloWatt(watt) * secondToHour(second);
    }
    public double multiplyWatt(double watt){
        return watt * multiplier;
    }
    public double addUp(double ac,double tv, double fan, double bulb){
        return ac+tv+fan+bulb;
    }
    public String date(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        String date = now.format(dtf);
        return date;
    }
    
}
