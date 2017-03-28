import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BingManPlay extends BingMan {
	private int x,y;
	BingMan b5= new BingMan();
//	b5.action();

public BingManPlay(){
	//action();
}

public  void action(){
	btnNewButton[0][0].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			x=0;y=0;
			label[0][0] = new JLabel();
			label[0][0].setBounds(145+x, 175+y, 60, 60);
			label[0][0].setVisible(false);
			Image tick = new ImageIcon(this.getClass().getResource("/check.png")).getImage();
			label[0][0].setIcon(new ImageIcon(tick));
			btnNewButton[0][0].add(label[0][0]);
			label[0][0].setVisible(true);
			
		}
	});
	//x+=60;
	btnNewButton[0][1].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[0][1] = new JLabel();
			label[0][1].setText(Integer.toString(++num));
			label[0][1].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[0][1].setBounds(145+x, 175+y, 60, 60);
			label[0][1].setVisible(false);
			btnNewButton[0][1].add(label[0][1]);
			label[0][1].setVisible(true);*/
			
		}
	});
	//x+=60;
	
	btnNewButton[0][2].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[0][2] = new JLabel();
			label[0][2].setText(Integer.toString(++num));
			label[0][2].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[0][2].setBounds(145+x, 175+y, 60, 60);
			label[0][2].setVisible(false);
			btnNewButton[0][2].add(label[0][2]);
			label[0][2].setVisible(true);*/
		}
	});
	//x+=60;
	btnNewButton[0][3].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[0][3] = new JLabel();
			label[0][3].setText(Integer.toString(++num));
			label[0][3].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[0][3].setBounds(145+x, 175+y, 60, 60);
			label[0][3].setVisible(false);
			btnNewButton[0][3].add(label[0][3]);
			label[0][3].setVisible(true);*/
		
		}
	});
	//x+=60;
	btnNewButton[0][4].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[0][4] = new JLabel();
			label[0][4].setText(Integer.toString(++num));
			label[0][4].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[0][4].setBounds(145+x, 175+y, 60, 60);
			label[0][4].setVisible(false);
			btnNewButton[0][4].add(label[0][4]);
			label[0][4].setVisible(true);*/
			
		}
	});
	//y+=60;
	//x=0;
	btnNewButton[1][0].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[1][0] = new JLabel();
			label[1][0].setText(Integer.toString(++num));
			label[1][0].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[1][0].setBounds(145+x, 175+y, 60, 60);
			label[1][0].setVisible(false);
			btnNewButton[1][0].add(label[1][0]);
			label[1][0].setVisible(true);*/
			
		}
	});
	//x+=60;
	btnNewButton[1][1].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[1][1] = new JLabel();
			label[1][1].setText(Integer.toString(++num));
			label[1][1].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[1][1].setBounds(145+x, 175+y, 60, 60);
			label[1][1].setVisible(false);
			btnNewButton[1][1].add(label[1][1]);
			label[1][1].setVisible(true);*/
		
		}
	});
	//x+=60;
	btnNewButton[1][2].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[1][2] = new JLabel();
			label[1][2].setText(Integer.toString(++num));
			label[1][2].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[1][2].setBounds(145+x, 175+y, 60, 60);
			label[1][2].setVisible(false);
			btnNewButton[1][2].add(label[1][2]);
			label[1][2].setVisible(true);*/
		
		}
	});
	//x+=60;
	btnNewButton[1][3].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[1][3] = new JLabel();
			label[1][3].setText(Integer.toString(++num));
			label[1][3].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[1][3].setBounds(145+x, 175+y, 60, 60);
			label[1][3].setVisible(false);
			btnNewButton[1][3].add(label[1][3]);
			label[1][3].setVisible(true);*/
		
		}
	});
	//x+=60;
	btnNewButton[1][4].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[1][4] = new JLabel();
			label[1][4].setText(Integer.toString(++num));
			label[1][4].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[1][4].setBounds(145+x, 175+y, 60, 60);
			label[1][4].setVisible(false);
			btnNewButton[1][4].add(label[1][4]);
			label[1][4].setVisible(true);*/
		
		}
	});
	//y+=60;
	//x=0;
	btnNewButton[2][0].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[2][0] = new JLabel();
			label[2][0].setText(Integer.toString(++num));
			label[2][0].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[2][0].setBounds(145+x, 175+y, 60, 60);
			label[2][0].setVisible(false);
			btnNewButton[2][0].add(label[2][0]);
			label[2][0].setVisible(true);*/
		
		}
	});
	//x+=60;
	btnNewButton[2][1].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[2][1] = new JLabel();
			label[2][1].setText(Integer.toString(++num));
			label[2][1].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[2][1].setBounds(145+x, 175+y, 60, 60);
			label[2][1].setVisible(false);
			btnNewButton[2][1].add(label[2][1]);
			label[2][1].setVisible(true);*/
		
		}
	});
	//x+=60;
	btnNewButton[2][2].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[2][2] = new JLabel();
			label[2][2].setText(Integer.toString(++num));
			label[2][2].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[2][2].setBounds(145+x, 175+y, 60, 60);
			label[2][2].setVisible(false);
			btnNewButton[2][2].add(label[2][2]);
			label[2][2].setVisible(true);*/
		
		}
	});
	//x+=60;
	btnNewButton[2][3].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[2][3] = new JLabel();
			label[2][3].setText(Integer.toString(++num));
			label[2][3].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[2][3].setBounds(145+x, 175+y, 60, 60);
			label[2][3].setVisible(false);
			btnNewButton[2][3].add(label[2][3]);
			label[2][3].setVisible(true);*/

		}
	});
	//x+=60;
	btnNewButton[2][4].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[2][4] = new JLabel();
			label[2][4].setText(Integer.toString(++num));
			label[2][4].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[2][4].setBounds(145+x, 175+y, 60, 60);
			label[2][4].setVisible(false);
			btnNewButton[2][4].add(label[2][4]);
			label[2][4].setVisible(true);*/

		}
	});
	//y+=60;
	//x=0;			
	btnNewButton[3][0].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[3][0] = new JLabel();
			label[3][0].setText(Integer.toString(++num));
			label[3][0].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[3][0].setBounds(145+x, 175+y, 60, 60);
			label[3][0].setVisible(false);
			btnNewButton[3][0].add(label[3][0]);
			label[3][0].setVisible(true);*/

		}
	});
	//x+=60;
	btnNewButton[3][1].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[3][1] = new JLabel();
			label[3][1].setText(Integer.toString(++num));
			label[3][1].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[3][1].setBounds(145+x, 175+y, 60, 60);
			label[3][1].setVisible(false);
			btnNewButton[3][1].add(label[3][1]);
			label[3][1].setVisible(true);*/

		}
	});
	//x+=60;
	
	btnNewButton[3][2].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[3][2] = new JLabel();
			label[3][2].setText(Integer.toString(++num));
			label[3][2].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[3][2].setBounds(145+x, 175+y, 60, 60);
			label[3][2].setVisible(false);
			btnNewButton[3][2].add(label[3][2]);
			label[3][2].setVisible(true);*/

		}
	});
	//x+=60;
	btnNewButton[3][3].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[3][3] = new JLabel();
			label[3][3].setText(Integer.toString(++num));
			label[3][3].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[3][3].setBounds(145+x, 175+y, 60, 60);
			label[3][3].setVisible(false);
			btnNewButton[3][3].add(label[3][3]);
			label[3][3].setVisible(true);*/

		}
	});
	//x+=60;
	btnNewButton[3][4].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[3][4] = new JLabel();
			label[3][4].setText(Integer.toString(++num));
			label[3][4].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[3][4].setBounds(145+x, 175+y, 60, 60);
			label[3][4].setVisible(false);
			btnNewButton[3][4].add(label[3][4]);
			label[3][4].setVisible(true);*/

		}
	});
	//y+=60;
	//x=0;
	btnNewButton[4][0].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[4][0] = new JLabel();
			label[4][0].setText(Integer.toString(++num));
			label[4][0].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[4][0].setBounds(145+x, 175+y, 60, 60);
			label[4][0].setVisible(false);
			btnNewButton[4][0].add(label[4][0]);
			label[4][0].setVisible(true);*/

		}
	});
	//x+=60;
	btnNewButton[4][1].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[4][1] = new JLabel();
			label[4][1].setText(Integer.toString(++num));
			label[4][1].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[4][1].setBounds(145+x, 175+y, 60, 60);
			label[4][1].setVisible(false);
			btnNewButton[4][1].add(label[4][1]);
			label[4][1].setVisible(true);*/

		}
	});
	//x+=60;
	
	btnNewButton[4][2].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[4][2] = new JLabel();
			label[4][2].setText(Integer.toString(++num));
			label[4][2].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[4][2].setBounds(145+x, 175+y, 60, 60);
			label[4][2].setVisible(false);
			btnNewButton[4][2].add(label[4][2]);
			label[4][2].setVisible(true);*/
			
		}
	});
	//x+=60;
	btnNewButton[4][3].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[4][3] = new JLabel();
			label[4][3].setText(Integer.toString(++num));
			label[4][3].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[4][3].setBounds(145+x, 175+y, 60, 60);
			label[4][3].setVisible(false);
			btnNewButton[4][3].add(label[4][3]);
			label[4][3].setVisible(true);*/
			
		}
	});
	//x+=60;
	btnNewButton[4][4].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*label[4][4] = new JLabel();
			label[4][4].setText(Integer.toString(++num));
			label[4][4].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
			label[4][4].setBounds(145+x, 175+y, 60, 60);
			label[4][4].setVisible(false);
			btnNewButton[4][4].add(label[4][4]);
			label[4][4].setVisible(true);*/
		
		}
	});

}
	
}
