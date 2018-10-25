import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainFrame2old extends JFrame {

	public Ballold myBall; //= new Ball(40, 25, this);
    public JPanel myJPanel;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame2old frame = new MainFrame2old();
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
	public MainFrame2old() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {				
				
			}
		});
		 myBall = new Ballold(40, 25, this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		myJPanel = new JPanel() {
			@Override
            public void paint(final Graphics g) {
                super.paint(g);
//                myBall.paintBild(g);
                myBall.paintBall(g);
            };
		};
				
		myJPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(myJPanel);
		myJPanel.setLayout(null);
		
		JButton btnDone = new JButton("done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				myBall.moveBall();
			}
		});
		btnDone.setBounds(335, 227, 89, 23);
		myJPanel.add(btnDone);
		
		JButton btnStart = new JButton("start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myBall.paintBall(myJPanel.getGraphics());				
			}
		});
		btnStart.setBounds(20, 227, 89, 23);
		myJPanel.add(btnStart);
	}
}
