import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.ImageView;

import java.awt.Canvas;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("test");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(0, 0, 434, 217);
		canvas.setBackground(Color.RED);
		contentPane.add(canvas);
		
		JButton btnClose = new JButton("close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnClose.setBounds(323, 227, 89, 23);
		contentPane.add(btnClose);
		
		JButton btnDone = new JButton("done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Canvas csStatusImage = new Canvas();
//		        csStatusImage.setBounds(393, 36, 200, 200);		        
//		        getContentPane().add(csStatusImage);

		        Image iMg;
		        Image iMg2;
		        Image iMg3;
		        int x=0;
		        int y=0;
		        int xold=0;
		        int yold=0;		        
		        int z =0;
		        int z1 =0;
		        
		        try {
		            iMg = ImageIO.read(new File("C:\\Users\\sven\\Pictures\\ball.png")); 
		            iMg2 = ImageIO.read(new File("C:\\Users\\sven\\Pictures\\ball.png")); 
		            iMg3 = ImageIO.read(new File("C:\\Users\\sven\\Pictures\\ball.png"));
		            Graphics gw = canvas.getGraphics();
		            canvas.getGraphics().drawImage(iMg3,z1, 10, null);
		            canvas.setBackground(Color.RED);
		            for (x = 0; x < 10000; x++) {	
		            	z++;
		            			
		            	
		            	if (z>100) {
		            		z1++;
		            		z=0;		
		            		
						}
		            	
	            	
		            	xold=x;
		            	yold=y;
		            	Thread.sleep(10);
		            	canvas.update(gw);		            	
		            	canvas.getGraphics().drawImage(iMg3,z1, 10, null);
					}

		        } catch (IOException | InterruptedException e1) {
		            e1.printStackTrace();
		        }
			}
		});
		btnDone.setBounds(10, 227, 89, 23);
		contentPane.add(btnDone);
	}

}
