
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

public class BingRandChat extends BingoCommon {
	static ServerSocket ssChat;
	static Socket sChat;
	static String got1="";
	static DataInputStream dinChat,din;
	static DataOutputStream doutChat,dout;
	String name = "Random";
	//private JPanel contentPane;
	
	ArrayList<Integer> numbers = new ArrayList<Integer>();
	static TextArea textAreaPingInBing2 = new TextArea();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BingRandChat frame = new BingRandChat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/*try {
			ss = new ServerSocket(1201);//comment this line to make it client
			s = ss.accept();//comment this line to make it client
		//	s = new Socket("172.16.115.215", 2425);// uncomment this line to make it client
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			System.out.println(" Connection Successful");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		try {
			while (!got1.equals("exit")) {
			got1 = din.readUTF();

			for (int i = 0; i < 5; i++) {
					for ( int j = 0; j < 5; j++) {
							if(Integer.parseInt(btnNewButton[i][j].getText())==Integer.parseInt(got1)){
								btnNewButton[i][j].doClick();
								btnNewButton[i][j].setEnabled(false);
				//gameLock.lock();
				}
									}
			}
			}
			
		//	System.out.println("gotcha");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		///////For Chatting//////////////////////////////////////////
		
		String msgin = "";
		try {
			ssChat = new ServerSocket(2425);
			sChat = ssChat.accept();
			dinChat = new DataInputStream(sChat.getInputStream());
			doutChat = new DataOutputStream(sChat.getOutputStream());

			while (!msgin.equals("exit")) {
				msgin = dinChat.readUTF();
				textAreaPingInBing2.setText(textAreaPingInBing2.getText().trim() + "\n Manual:\t" + msgin);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	////////////////////////////////////////////////////////////////
	
	

	/**
	 * Create the frame.
	 */
	public BingRandChat() {
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
		
		Image button =new ImageIcon(this.getClass().getResource("/ButtonChat.png")).getImage();
		Chat = new JButton("Chat");
		//Chat.setBackground(Color.BLACK);
		Chat.setIcon(new ImageIcon(button));
		Chat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Chatb == true){
					Chatting();
				}
				else{
					setBounds(100, 100, 665, 636);
					Chatb=true;
				}
			}
		});
		Chat.setBounds(617, 258, 30, 100);
		lblNewLabel.add(Chat);
		
		
		textAreaPingInBing2.setBackground(new Color(255, 250, 240));
		textAreaPingInBing2.setEditable(false);
		textAreaPingInBing2.setBounds(665, 36, 275, 490);
		contentPane.add(textAreaPingInBing2);
		
		JTextField textFieldPinginBing2 = new JTextField();
		textFieldPinginBing2.setBounds(653, 544, 217, 32);
		contentPane.add(textFieldPinginBing2);
		textFieldPinginBing2.setColumns(10);
		
		JButton btnPingInBing2 = new JButton("Send");
		btnPingInBing2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPingInBing2.addActionListener(new ActionListener() {
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
		btnPingInBing2.setBounds(870, 544, 64, 32);
		contentPane.add(btnPingInBing2);
		
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
				Search(a,name);

			}
		});
		btnNewButton[0][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(btnNewButton[0][1].getText());
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
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
				Search(a,name);
				try {
					dout.writeUTF(Integer.toString(a));
					System.out.println("sent");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

	}
}
