import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;


    

public class textbox extends JFrame implements ActionListener{
    

    
    JButton alarmbutton;
    JTextField hoursTextField;
    JTextField minutesTextField;
    JTextField ampmtTextField;
    JTextField secondsTextField;
    static Scanner scan = new Scanner(System.in);
    static Calendar cal = Calendar.getInstance();
    public static int h = cal.get(Calendar.HOUR_OF_DAY);
    public static int m = cal.get(Calendar.MINUTE);
    public static int c = cal.get(Calendar.SECOND);
    public static int ap = cal.get(Calendar.AM_PM);
    public static int k;
    public static int p;
    public static int seconds;
    public static String r;
    public static int w = 0;
    static textbox hello = new textbox();
    



    textbox(){ 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JLabel msgLabel = new JLabel("SET YOUR ALARM : ");
        msgLabel.setFont(new Font("Century gothic",Font.PLAIN,25));
        msgLabel.setForeground(Color.YELLOW);
        msgLabel.setBackground(Color.BLACK);
        msgLabel.setOpaque(true);

        hoursTextField = new JTextField();
        hoursTextField.setPreferredSize(new Dimension(50,40));
        hoursTextField.setText("HH");
        minutesTextField = new JTextField();
        minutesTextField.setPreferredSize(new Dimension(50,40));
        minutesTextField.setText("MM");
        secondsTextField = new JTextField();
        secondsTextField.setPreferredSize(new Dimension(50,40));
        secondsTextField.setText("SS");
        
        ampmtTextField = new JTextField();
        ampmtTextField.setPreferredSize(new Dimension(50,40));
        ampmtTextField.setText("AM/PM");

        alarmbutton = new JButton("SET ALARM");
        alarmbutton.setBounds(60,130,70,50);
        alarmbutton.setFont(new Font("Serif",Font.PLAIN,20));
        alarmbutton.setBackground(Color.GRAY);
        alarmbutton.setFocusable(false);
        alarmbutton.addActionListener(this);

        this.add(msgLabel);
        this.add(hoursTextField);
        this.add(minutesTextField);
        this.add(secondsTextField);
        this.add(ampmtTextField);
        this.add(alarmbutton);
        this.pack();
        this.setVisible(true);    
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        k=Integer.parseInt(hoursTextField.getText());
        p=Integer.parseInt(minutesTextField.getText());
        seconds = Integer.parseInt(secondsTextField.getText());
        r= ampmtTextField.getText();
        
            
        if(e.getSource() == alarmbutton){
           
            System.out.println("Alarm set at "+k+":"+p+":"+seconds+" "+r); 
        }

        try {
            hello.ring();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
               

    }

    public static void ring()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        
        if(r.equals("PM")){
            if(k==12){
                w = k;
            }else{
                w = k+12;
            }
            
        }else if(r.equals("AM")){
            w = k;
        } 

        int g = (w-h)*3600000;
        int z = (p-m)*60000;
        int y = (seconds-c)*1000;
        int q = g+z+y;       
    
        
    
        sleep(q);
    
        File file = new File("Alarm-ringtone.wav");
        AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audiostream);
    
        clip.start();
    
        String response = scan.next();
    
    
    
    }
    
    
    public static void sleep(int time) {
        try{
            Thread.sleep(time);
        }catch(Exception e){

        }
        
    }
   

}