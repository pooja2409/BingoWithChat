
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BingRandThread extends BingoCommon {
	static ServerSocket ss;
	static Socket s;
	//static String got1 = "";
	static DataInputStream din;
	static DataOutputStream dout;
	private static ServerSocket ssChat;
	private static DataInputStream dinChat;
	private static DataOutputStream doutChat;
	private static Socket sChat;
	// private JPanel contentPane;
	String name = "Random";
	private int click=-1;
	JTextField TurnField;
	TextArea PinginBing;
	static TextArea textAreaPingInBing2;

	ArrayList<Integer> numbers = new ArrayList<Integer>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BingRandThread frame = new BingRandThread();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		server();

	}
	////////////////////////////////////////////////////////////////

	/**
	 * Create the frame.
	 */
	public BingRandThread() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Random randomGenerator = new Random();
		// Array [] numbers;
		while (numbers.size() < 25) {

			r = randomGenerator.nextInt(25);
			if (!numbers.contains(r)) {
				numbers.add(r);
			}

		}
		for (i = 0; i < 25; i++) {
			x = 25;
			if (numbers.get(i) == 0) {
				numbers.set(i, 25);
			}
		}

		lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 665, 595);
		Image Background = new ImageIcon(this.getClass().getResource("/BackgroundNew.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(Background));
		contentPane.add(lblNewLabel);
		
		TurnField = new JTextField("Plz wait!");
		TurnField.setHorizontalAlignment(SwingConstants.CENTER);
		TurnField.setBackground(new Color(0, 0, 0));
		TurnField.setForeground(new Color(255, 255, 255));
		TurnField.setFont(new Font("Tahoma", Font.BOLD, 21));
		TurnField.setEditable(false);
		TurnField.setBounds(215, 123, 210, 50);
		lblNewLabel.add(TurnField);
		TurnField.setColumns(10);
		
		Image button = new ImageIcon(this.getClass().getResource("/ButtonChat.png")).getImage();
		Chat = new JButton("Chat");
		// Chat.setBackground(Color.BLACK);
		Chat.setIcon(new ImageIcon(button));
		Chat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Chatb == true) {
					Chatting();
				} else {
					setBounds(100, 100, 665, 636);
					Chatb = true;
				}
			}
		});
		Chat.setBounds(617, 258, 30, 100);
		lblNewLabel.add(Chat);
		 textAreaPingInBing2 = new TextArea();
		textAreaPingInBing2.setBackground(new Color(255, 250, 240));
		textAreaPingInBing2.setEditable(false);
		textAreaPingInBing2.setBounds(665, 36, 275, 490);
		contentPane.add(textAreaPingInBing2);

		JTextField textFieldPinginBing2 = new JTextField();
		textFieldPinginBing2.setBounds(653, 544, 217, 32);
		contentPane.add(textFieldPinginBing2);
		textFieldPinginBing2.setColumns(10);

		JButton btnPingInBing = new JButton("Send");
		btnPingInBing.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPingInBing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String msgout = "";
					msgout = textFieldPinginBing2.getText().trim();
					textFieldPinginBing2.setText("");
					doutChat.writeUTF(msgout);
					textAreaPingInBing2.setText(textAreaPingInBing2.getText().trim() + "\n ME:\t" + msgout);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnPingInBing.setBounds(870, 544, 64, 32);
		contentPane.add(btnPingInBing);

		JLabel lblPingInBing = new JLabel("Ping in Bing!!");
		lblPingInBing.setHorizontalAlignment(SwingConstants.CENTER);
		lblPingInBing.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPingInBing.setBounds(653, 0, 276, 30);
		contentPane.add(lblPingInBing);

		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5; j++) {
				Bing[i][j] = 0;
			}
			row[i] = 0;
			col[i] = 0;
		}
		dig[0] = 0;
		dig[1] = 0;

		creation();

		action();

	}

	public void creation() {
		x = 0;
		y = 0;
		for (j = 0; j < 5; j++) {
			for (i = 0; i < 5; i++) {

				Bingarr[i][j] = numbers.get(j * 5 + i);
				btnNewButton[i][j] = new JButton(Integer.toString(numbers.get(j * 5 + i)));
				btnNewButton[i][j].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 29));
				btnNewButton[i][j].setForeground(new Color(0, 0, 0));
				btnNewButton[i][j].setBackground(new Color(255, 218, 185));
				btnNewButton[i][j].setOpaque(false);
				btnNewButton[i][j].setBounds(145 + x, 175 + y, 70, 70);
				lblNewLabel.add(btnNewButton[i][j]);
				x += 70;
			}
			y += 70;
			x = 0;
		}
	}

	public void action() {
		btnNewButton[0][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[0][0].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[0][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[0][1].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[0][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[0][2].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[0][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[0][3].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[0][4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[0][4].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		btnNewButton[1][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[1][0].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[1][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[1][1].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[1][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[1][2].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[1][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[1][3].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[1][4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[1][4].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[2][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[2][0].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[2][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[2][1].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[2][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[2][2].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[2][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[2][3].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[2][4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[2][4].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[3][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[3][0].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[3][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[3][1].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[3][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[3][2].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[3][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[3][3].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[3][4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[3][4].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		btnNewButton[4][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[4][0].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		btnNewButton[4][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[4][1].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[4][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[4][2].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[4][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[4][3].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton[4][4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[4][4].getText());
				Search(a, name);
				Turn();
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

	}

	public static void server() {
		
		try {
			//ss = new ServerSocket(1201);// comment this line to make it client
			//s = ss.accept();// comment this line to make it client
			s = new Socket("192.168.1.39", 2425);// uncomment this line to
			// make it client
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			System.out.println(" Connection Successful for Gaming");
			sChat= new Socket("192.168.1.39",1201);
			dinChat = new DataInputStream(sChat.getInputStream());
			doutChat = new DataOutputStream(sChat.getOutputStream());
			System.out.println(" Connection Successful for Chatting");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread t1 = new Thread(){
			public void run(){
				try {String got1 = "";
				while (!got1.equals("exit")) {
					got1 = din.readUTF();

					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							if (Integer.parseInt(btnNewButton[i][j].getText()) == Integer.parseInt(got1)) {
								btnNewButton[i][j].doClick();
								btnNewButton[i][j].setEnabled(false);
								// gameLock.lock();
							}
						}
					}
				}

					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		/*try {
			String got1 = "";
			while (!got1.equals("exit")) {
				got1 = din.readUTF();

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (Integer.parseInt(btnNewButton[i][j].getText()) == Integer.parseInt(got1)) {
							btnNewButton[i][j].doClick();
							btnNewButton[i][j].setEnabled(false);
							// gameLock.lock();
						}
					}
				}
			}

			// System.out.println("gotcha");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		/////// For Chatting//////////////////////////////////////////
		Thread t2 = new Thread(){
		public void run(){
			String msgin = "";
			try {
				
				while (!msgin.equals("exit")) {
					msgin = dinChat.readUTF();
					textAreaPingInBing2.setText(textAreaPingInBing2.getText().trim() + "\n Manual:\t" + msgin);

				}
				Thread.sleep(100);
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
		}
		};
		
	/*	String msgin = "";
		try {
			

			while (!msgin.equals("exit")) {
				msgin = dinChat.readUTF();
				textAreaPingInBing.setText(textAreaPingInBing.getText().trim() + "\n Manual:\t" + msgin);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		t1.start();
		t2.start();
		 
	}

	public void Turn() {
		if (click == -1) {
			TurnField.setText("Your Turn");
			click *= -1;
		} else {
			TurnField.setText("Opponent's Turn");
			click *= -1;
		}
	}
}
