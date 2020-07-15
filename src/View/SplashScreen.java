package View;

//import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

@SuppressWarnings("serial")
public class SplashScreen extends JFrame {

private JPanel contentPane;
private JProgressBar progressBar;
private JLabel percentageLbl;

/**
 * Launch the application.
* @param args
 */
public static void main(String[] args) {
        SplashScreen frame = new SplashScreen();
        EventQueue.invokeLater(() -> {
            try {
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            } catch (Exception e) {

            }
        });
		
    MainPageView mp = new MainPageView();
    try {
        for (int i = 0; i <= 100 ; i++) {
                Thread.sleep(10);
                frame.progressBar.setValue(i);
                frame.percentageLbl.setText(Integer.toString(i)+ "%");


        }

        } catch (InterruptedException e) {

        }
        frame.setVisible(false);

        mp.setVisible(true);

        frame.dispose();
    }

    /**
     * Create the frame.
     */
    public SplashScreen() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setUndecorated(true);

            setBounds(100, 100, 695, 379);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 695, 379);
            contentPane.add(panel);
            panel.setLayout(null);

            percentageLbl = new JLabel("0%");
            percentageLbl.setForeground(Color.WHITE);
            percentageLbl.setBounds(340, 264, 56, 16);
            panel.add(percentageLbl);

            progressBar = new JProgressBar();
            progressBar.setForeground(new Color(173, 255, 47));
            progressBar.setBounds(213, 248, 275, 14);
            panel.add(progressBar);

            JLabel titleLbl = new JLabel("Online Ordering System");

            titleLbl.setForeground(new java.awt.Color(255,102,0));
            titleLbl.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 32));
            titleLbl.setBounds(153, 32, 398, 113);
            panel.add(titleLbl);

            JLabel imagelbl = new JLabel("");
            imagelbl.setIcon(new ImageIcon(SplashScreen.class.getResource("/ProductImages/splashimage.jpg")));
            imagelbl.setBounds(0, 0, 695, 379);
            panel.add(imagelbl);
    }
}
