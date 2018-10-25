
import java.awt.Canvas;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Limewandold extends JFrame {
	
	private JPanel contentPane;

	Limewandold(int white, int higt,int x, int y) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		setBounds(x,y, white, higt);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		//contentPane.setLayout(null);
		
		Canvas canvas = new Canvas();		
		canvas.setBounds(x, y, white-30, higt-50);
		canvas.setBackground(Color.DARK_GRAY);		
		String imagepath = "C:\\Users\\srossmann.ISR\\Pictures\\AWE Bilder\\ball.png";
		
		   ImageIcon icon = new ImageIcon (imagepath);
	       JLabel l1 = new JLabel (icon);	
	      
		
		contentPane.add(canvas);
		
	}	
	
	
	
	
	

	
}
