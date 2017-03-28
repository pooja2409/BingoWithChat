import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BingSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BingSelection frame = new BingSelection();
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
	public BingSelection() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 659, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//HOW WOULD YOU JLabel
		JLabel lblHowWouldYou = new JLabel("How Would You Like To Fill Your");
		lblHowWouldYou.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHowWouldYou.setForeground(new Color(255, 192, 203));
		lblHowWouldYou.setBounds(118, 27, 428, 79);
		contentPane.add(lblHowWouldYou);
		
		//BINGO JLabel
		JLabel lblBingo = new JLabel("BINGO!!");
		lblBingo.setForeground(new Color(0, 0, 205));
		lblBingo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 45));
		lblBingo.setBounds(219, 96, 215, 79);
		contentPane.add(lblBingo);
		
		// Action Performed for the Randomly Button
		JButton btnRandomly = new JButton("Randomly");
		btnRandomly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BingRandThread b3 = new BingRandThread();
				b3.setVisible(true);
				BingRandThread.server();
			}
		});

		Image button = new ImageIcon(this.getClass().getResource("/buttonb.png")).getImage();
		btnRandomly.setIcon(new ImageIcon(button));
		btnRandomly.setBackground(new Color(255, 218, 185));
		btnRandomly.setForeground(new Color(0, 0, 128));
		btnRandomly.setBounds(238, 314, 170, 47);
		contentPane.add(btnRandomly);

		JLabel lblRandomly = new JLabel("Randomly");
		lblRandomly.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblRandomly.setBounds(172, 130, 106, 23);
		btnRandomly.add(lblRandomly);
		// Action Listener For the Manually Button
		JButton btnManually = new JButton("");
		btnManually.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BingMan b2 = new BingMan();
				b2.setVisible(true);
				BingMan.server();
			}
		});
		
		btnManually.setIcon(new ImageIcon(button));
		btnManually.setForeground(new Color(0, 0, 128));
		btnManually.setBackground(new Color(255, 218, 185));
		btnManually.setOpaque(false);
		btnManually.setBounds(238, 212, 170, 47);
		contentPane.add(btnManually);
		JLabel lblManually = new JLabel("Manually");
		lblManually.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblManually.setBounds(172, 85, 106, 23);
		btnManually.add(lblManually);

		// Label For the Background
		JLabel lbl = new JLabel("");
		lbl.setBounds(0, 0, 647, 595);
		Image img1 = new ImageIcon(this.getClass().getResource("/FBackground.png")).getImage();
		lbl.setIcon(new ImageIcon(img1));
		contentPane.add(lbl);
		
		

	}

}
