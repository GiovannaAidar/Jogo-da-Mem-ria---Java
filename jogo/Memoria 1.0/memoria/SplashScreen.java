package memoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;


public class SplashScreen extends JWindow{
	
	private int duracao;
	
	public SplashScreen(int d) {
		
		duracao = d;
	}
	
	public void showSplash() {
		
		JPanel content = (JPanel)getContentPane();
		content.setBackground(getForeground());
		
		int width = 460;
		int height = 460;
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;
		
		setBounds(x,y,width,height);
		
		JLabel label = new JLabel(new ImageIcon("regras.png"));
        JLabel copyrt = new JLabel
                ("",JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color oraRed = new Color(156, 20, 20,  255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 10));
        
        setVisible(true);
        
        try {
        	
        	Thread.sleep(duracao);
        
        }catch(Exception e) {
        }
        
        setVisible(false);
	}
	
	public void showSplashAndExit() {
		
		showSplash();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		
		SplashScreen splash = new SplashScreen(10000);
		splash.showSplashAndExit();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		Menu objMenu = new Menu();
		objMenu.setVisible(true);
		dispose();
	}
	
}

