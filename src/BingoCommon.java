import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public abstract class BingoCommon extends JFrame {

	protected JPanel contentPane;

	protected JLabel lblNewLabel;
	protected int Bingarr[][] = new int[5][5];
	protected int num = 0;
	protected int i, j, x, y, a;
	protected boolean flag = true;
	static JButton[][] btnNewButton = new JButton[5][5];
	JLabel[][] label = new JLabel[5][5];

	protected int[][] Bing = new int[5][5];
	protected int row[] = new int[5];
	protected int col[] = new int[5];
	protected int dig[] = new int[2];
	protected int r, p = 0, z = 0;

	protected JLabel[] Bingocross = new JLabel[5];
	protected JButton Chat;
	protected boolean Chatb = true;
	protected JTextField textFieldPinginBing;
	protected static TextArea textAreaPingInBing;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BingoCommon() {
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
		for (j = 0; j < 5; j++) {
			for (i = 0; i < 5; i++) {
				label[j][i] = new JLabel();
				Bing[j][i] = 0;
			}
			row[j] = 0;
			col[j] = 0;
		}
		dig[0] = 0;
		dig[1] = 0;
	}

	public abstract void creation();

	public abstract void action();

	public void Chatting() {
		setBounds(100, 100, 959, 636);
		Chatb = false;
	}

	public void check(String name) {
		for (int i = 0; i < 5; i++) {
			if (Bing[i][0] == 1 && Bing[i][1] == 1 && Bing[i][2] == 1 && Bing[i][3] == 1 && Bing[i][4] == 1
					&& col[i] == 0) {
				col[i] = 1;
				BingoCross(name);
			}
			if (Bing[0][i] == 1 && Bing[1][i] == 1 && Bing[2][i] == 1 && Bing[3][i] == 1 && Bing[4][i] == 1
					&& row[i] == 0) {
				row[i] = 1;
				BingoCross(name);
			}

		}
		if (Bing[0][0] == 1 && Bing[1][1] == 1 && Bing[2][2] == 1 && Bing[3][3] == 1 && Bing[4][4] == 1
				&& dig[0] == 0) {
			dig[0] = 1;
			BingoCross(name);
		}
		if (Bing[0][4] == 1 && Bing[1][3] == 1 && Bing[2][2] == 1 && Bing[3][1] == 1 && Bing[4][0] == 1
				&& dig[1] == 0) {
			dig[1] = 1;
			BingoCross(name);
		}

	}

	public void BingoCross(String name) {

		Image cros = new ImageIcon(this.getClass().getResource("/Cros.png")).getImage();
		Bingocross[p] = new JLabel("");
		lblNewLabel.add(Bingocross[p]);
		Bingocross[p].setBounds(157 + z, 50, 72, 71);
		Bingocross[p].setOpaque(false);
		Bingocross[p].setIcon(new ImageIcon(cros));
		z += 72;
		p++;

		if (p == 5) {
			JOptionPane.showMessageDialog(null, "Congratulation!!YOU won...");
			// System.exit(0);

		}

	}

	public void Search(int a,String name) {
		Image Tick = new ImageIcon(this.getClass().getResource("/check.png")).getImage();
		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5; j++) {
				if (Bingarr[i][j] == a) {
					label[i][j] = new JLabel();
					label[i][j].setIcon(new ImageIcon(Tick));
					label[i][j].setVisible(false);
					btnNewButton[i][j].add(label[i][j]);
					label[i][j].setOpaque(false);
					label[i][j].setVisible(true);
					Bing[i][j] = 1;
					check(name);
					break;
				}
			}
		}
	}

}
