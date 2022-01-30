import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    String time;
    String day;
    JButton stopwatchButton = new JButton("STOPWATCH\n");
    JButton alarmb = new JButton("ALARM");
    JFrame sp = new JFrame();

    Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("WATCH");
        this.setLayout(new FlowLayout());
        this.setSize(500,400);
        this.setResizable(false);


        timeFormat = new SimpleDateFormat("hh:mm:ss a\n");
        dayFormat = new SimpleDateFormat("M/d/y , E \n");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Serif",Font.PLAIN,70));
        timeLabel.setForeground(Color.YELLOW);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);

        stopwatchButton.setBounds(50,50,70,50);
        stopwatchButton.setFont(new Font("Serif",Font.PLAIN,20));
        stopwatchButton.setBackground(Color.GRAY);
        stopwatchButton.setForeground(Color.WHITE);
        stopwatchButton.setFocusable(false);
        stopwatchButton.addActionListener(this);

        alarmb.setBounds(100,50,70,50);
        alarmb.setFont(new Font("Serif",Font.PLAIN,20));
        alarmb.setBackground(Color.MAGENTA);
        alarmb.setForeground(Color.WHITE);
        alarmb.setFocusable(false);
        alarmb.addActionListener(this);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Century gothic",Font.PLAIN,40));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(stopwatchButton);
        this.add(alarmb);
        this.setVisible(true);
        
        setTime();

    }

    public void actionPerformed(ActionEvent e) {
        if( e.getSource()==stopwatchButton){
            new Stopwatch();
        }
        if(e.getSource()==alarmb){
            new textbox();
        }
      
    }
    
    public void setTime() {
        while(true){
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        
                 
            
            
        }
        
    }

        
    }

