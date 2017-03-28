import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bingo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bingo window = new Bingo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bingo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("BINGO!!");
		frame.setBounds(100, 100, 659, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLetsBingo = new JLabel("Lets BINGO!!");
		lblLetsBingo.setForeground(Color.BLUE);
		lblLetsBingo.setBackground(Color.LIGHT_GRAY);
		lblLetsBingo.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 55));
		lblLetsBingo.setBounds(173, 13, 400, 100);
		frame.getContentPane().add(lblLetsBingo);
		
		JLabel lblSelectYourAction = new JLabel("Select your Action.");
		lblSelectYourAction.setForeground(new Color(219, 112, 147));
		lblSelectYourAction.setFont(new Font("Tw Cen MT", Font.BOLD, 32));
		lblSelectYourAction.setBounds(213, 113, 250, 75);
		frame.getContentPane().add(lblSelectYourAction);
		
		JButton btnNewGame = new JButton();//newgame button
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BingSelection b1 =new BingSelection();
				b1.setVisible(true);
			}
		});
		btnNewGame.setForeground(new Color(0, 0, 139));
		btnNewGame.setBackground(new Color(255, 218, 185));
		Image button =new ImageIcon(this.getClass().getResource("/buttonb.png")).getImage();
		btnNewGame.setIcon(new ImageIcon(button));
		btnNewGame.setBounds(238, 201, 170, 47);
		
		frame.getContentPane().add(btnNewGame);
		JLabel lblNewGame = new JLabel("New Game");
		lblNewGame.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewGame.setBounds(238, 201, 170, 47);
		btnNewGame.add(lblNewGame);
		
		//Instruction button
		JButton btnInstruction = new JButton();
		btnInstruction.setForeground(new Color(0, 0, 139));
		btnInstruction.setBackground(new Color(255, 218, 185));
		btnInstruction.setBounds(238, 281, 170, 47);
		btnInstruction.setIcon(new ImageIcon(button));
		frame.getContentPane().add(btnInstruction);
		JLabel lblInstruction = new JLabel("Instruction");
		lblInstruction.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblInstruction.setBounds(238, 281, 170, 47);
		btnInstruction.add(lblInstruction);
		
		//About button
		JButton btnAbout = new JButton();
		btnAbout.setForeground(new Color(0, 0, 139));
		btnAbout.setBackground(new Color(255, 218, 185));
		btnAbout.setBounds(238, 361, 170, 47);
		btnAbout.setIcon(new ImageIcon(button));
		frame.getContentPane().add(btnAbout);
		JLabel lbl2 = new JLabel("About");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 24));		
		lbl2.setBounds(238, 361, 170, 47);
		btnAbout.add(lbl2);
		
		//Help button
		JButton btnHelp = new JButton();
		btnHelp.setBackground(new Color(255, 218, 185));
		btnHelp.setForeground(new Color(0, 0, 139));
		btnHelp.setBounds(238, 441, 170, 47);
		frame.getContentPane().add(btnHelp);
		btnHelp.setIcon(new ImageIcon(button));
		frame.getContentPane().add(btnHelp);
		JLabel help = new JLabel("Help");
		help.setFont(new Font("Tahoma", Font.BOLD, 24));
		help.setBounds(238, 441, 170, 47);
		btnHelp.add(help);
		
		//Exit button
		JButton btnExit = new JButton();
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(new Color(0, 0, 139));
		btnExit.setBackground(new Color(255, 218, 185));
		btnExit.setBounds(238, 521, 170, 47);
		frame.getContentPane().add(btnExit);
		btnExit.setIcon(new ImageIcon(button));
		frame.getContentPane().add(btnExit);
		JLabel lblExit = new JLabel("Exit");
		lblExit.setFont(new Font("Tahoma", Font.BOLD, 24));	
		lblExit.setBounds(238, 521, 170, 47);
		btnExit.add(lblExit);
		
		//Label to set the background Image
		JLabel lbl = new JLabel("");
		lbl.setBounds(0, 0, 647, 595);
		Image Background =new ImageIcon(this.getClass().getResource("/FBackground.png")).getImage();
		lbl.setIcon(new ImageIcon(Background));
		frame.getContentPane().add(lbl);
		
		
	}
}
