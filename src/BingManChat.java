import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.JTextArea;

public class BingManChat extends BingoCommon {
	///////////////////////////////////////////////////////////////
	static Socket s,sChat;
	static DataInputStream din,dinChat;
	static DataOutputStream dout,doutChat;
	int send1;
	static String got = "";
	String name = "Manual";
	static TextArea textAreaPingInBing1 = new TextArea();
	////////////////////////////////////////////////////////////// client

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BingManChat frame = new BingManChat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//////////////////////////////////////////////////////////////////////////////////////

	/*	try {
			s = new Socket("172.16.113.184", 1201);
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			System.out.println("Connection Successful");

		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*try {
			while (!got.equals("exit")) {
				got = din.readUTF();
				// }
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (Integer.parseInt(btnNewButton[i][j].getText()) == Integer.parseInt(got)) {
							btnNewButton[i][j].doClick();
							btnNewButton[i][j].setEnabled(false);
						}
					}
				}
			}

			// System.out.println("gotcha");
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		////////For Chatting //////////////////////////////////////////////////////////
		
		try{
			sChat= new Socket("192.168.43.196",2425);
			dinChat = new DataInputStream(sChat.getInputStream());
			doutChat= new DataOutputStream(sChat.getOutputStream());
			System.out.println("Connection Successful");
			 String msgin= "";
			while (!msgin.equals("exit")) {
				msgin = dinChat.readUTF();
				textAreaPingInBing1.setText(textAreaPingInBing1.getText().trim() + "\n Random:\t" + msgin);

			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public BingManChat() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 647, 595);
		Image Background = new ImageIcon(this.getClass().getResource("/BackgroundNew.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(Background));
		contentPane.add(lblNewLabel);
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

		
		textAreaPingInBing1.setBackground(new Color(255, 250, 240));
		textAreaPingInBing1.setEditable(false);
		textAreaPingInBing1.setBounds(653, 36, 288, 490);
		contentPane.add(textAreaPingInBing1);
		
		JTextField textFieldPinginBing1 = new JTextField();
		textFieldPinginBing1.setBounds(653, 544, 217, 32);
		contentPane.add(textFieldPinginBing1);
		textFieldPinginBing1.setColumns(10);

		JButton btnPingInBing1 = new JButton("Send");
		btnPingInBing1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPingInBing1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String msgout = "";
					msgout = textFieldPinginBing1.getText().trim();
					textFieldPinginBing1.setText("");
					doutChat.writeUTF(msgout);
					textAreaPingInBing1.setText(textAreaPingInBing1.getText().trim() + "\n ME:\t" + msgout);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPingInBing1.setBounds(870, 544, 64, 32);
		contentPane.add(btnPingInBing1);

		JLabel lblPingInBing = new JLabel("Ping in Bing!!");
		lblPingInBing.setHorizontalAlignment(SwingConstants.CENTER);
		lblPingInBing.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPingInBing.setBounds(653, 0, 276, 30);
		contentPane.add(lblPingInBing);

		creation();
		action();

	}

	public void creation() {
		x = 0;
		y = 0;
		for (j = 0; j < 5; j++) {
			for (i = 0; i < 5; i++) {

				btnNewButton[i][j] = new JButton();
				// btnNewButton[i][j].setIcon(new ImageIcon(I));
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

	public void enableButton() {
		for (j = 0; j < 5; j++) {
			for (i = 0; i < 5; i++) {
				btnNewButton[i][j].setEnabled(true);
			}
		}

	}

	public void action() {

		btnNewButton[0][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[0][0].setText(Integer.toString(++num));
					Bingarr[0][0] = num;
					btnNewButton[0][0].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();

					}

				} else {
					a = Integer.parseInt(btnNewButton[0][0].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		// x+=60;
		btnNewButton[0][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[0][1].setText(Integer.toString(++num));
					Bingarr[0][1] = num;
					btnNewButton[0][1].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[0][1].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		// x+=60;

		btnNewButton[0][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[0][2].setText(Integer.toString(++num));
					Bingarr[0][2] = num;
					btnNewButton[0][2].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();

					}

				} else {
					a = Integer.parseInt(btnNewButton[0][2].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton[0][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[0][3].setText(Integer.toString(++num));
					Bingarr[0][3] = num;
					btnNewButton[0][3].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();

					}

				} else {
					a = Integer.parseInt(btnNewButton[0][3].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;
		btnNewButton[0][4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[0][4].setText(Integer.toString(++num));
					Bingarr[0][4] = num;
					btnNewButton[0][4].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[0][4].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		// y+=60;
		// x=0;
		btnNewButton[1][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[1][0].setText(Integer.toString(++num));
					Bingarr[1][0] = num;
					btnNewButton[1][0].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[1][0].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		// x+=60;
		btnNewButton[1][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[1][1].setText(Integer.toString(++num));
					Bingarr[1][1] = num;
					btnNewButton[1][1].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[1][1].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;
		btnNewButton[1][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[1][2].setText(Integer.toString(++num));
					Bingarr[1][2] = num;
					btnNewButton[1][2].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[1][2].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;
		btnNewButton[1][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[1][3].setText(Integer.toString(++num));
					Bingarr[1][3] = num;
					btnNewButton[1][3].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[1][3].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;
		btnNewButton[1][4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[1][4].setText(Integer.toString(++num));
					Bingarr[1][4] = num;
					btnNewButton[1][4].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[1][4].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		// y+=60;
		// x=0;
		btnNewButton[2][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[2][0].setText(Integer.toString(++num));
					Bingarr[2][0] = num;
					btnNewButton[2][0].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[2][0].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		// x+=60;
		btnNewButton[2][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[2][1].setText(Integer.toString(++num));
					Bingarr[2][1] = num;
					btnNewButton[2][1].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[2][1].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;
		btnNewButton[2][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[2][2].setText(Integer.toString(++num));
					btnNewButton[2][2].setEnabled(false);
					Bingarr[2][2] = num;
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[2][2].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;
		btnNewButton[2][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[2][3].setText(Integer.toString(++num));
					Bingarr[2][3] = num;
					btnNewButton[2][3].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[2][3].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;
		btnNewButton[2][4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[2][4].setText(Integer.toString(++num));
					Bingarr[2][4] = num;
					btnNewButton[2][4].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[2][4].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// y+=60;
		// x=0;
		btnNewButton[3][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[3][0].setText(Integer.toString(++num));
					Bingarr[3][0] = num;
					btnNewButton[3][0].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[3][0].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;
		btnNewButton[3][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[3][1].setText(Integer.toString(++num));
					Bingarr[3][1] = num;
					btnNewButton[3][1].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[3][1].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;

		btnNewButton[3][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[3][2].setText(Integer.toString(++num));
					Bingarr[3][2] = num;
					btnNewButton[3][2].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[3][2].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;
		btnNewButton[3][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[3][3].setText(Integer.toString(++num));
					Bingarr[3][3] = num;
					btnNewButton[3][3].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[3][3].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;
		btnNewButton[3][4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[3][4].setText(Integer.toString(++num));
					Bingarr[3][4] = num;
					btnNewButton[3][4].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[3][4].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// y+=60;
		// x=0;
		btnNewButton[4][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[4][0].setText(Integer.toString(++num));
					Bingarr[4][0] = num;
					btnNewButton[4][0].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[4][0].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;
		btnNewButton[4][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[4][1].setText(Integer.toString(++num));
					Bingarr[4][1] = num;
					btnNewButton[4][1].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[4][1].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		// x+=60;

		btnNewButton[4][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[4][2].setText(Integer.toString(++num));
					Bingarr[4][2] = num;
					btnNewButton[4][2].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[4][2].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;
		btnNewButton[4][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[4][3].setText(Integer.toString(++num));
					Bingarr[4][3] = num;
					btnNewButton[4][3].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[4][3].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// x+=60;
		btnNewButton[4][4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					btnNewButton[4][4].setText(Integer.toString(++num));
					Bingarr[4][4] = num;
					btnNewButton[4][4].setEnabled(false);
					if (num == 25) {
						flag = false;
						enableButton();
					}

				} else {
					a = Integer.parseInt(btnNewButton[4][4].getText());
					Search(a,name);
					try {
						dout.writeUTF(Integer.toString(a));
						System.out.println("sent");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

	}
}

