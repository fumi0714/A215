
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPanel extends JPanel implements ActionListener {

	private MainFrame frame;
	private MariaDbConnector m;
	private JButton Lbutton[] = new JButton[1];// ログインボタン
	private JLabel label01;
	private JLabel label[] = new JLabel[10];
	private JTextField text[] = new JTextField[5];
	private JPanel p[] = new JPanel[3];

	public LoginPanel(MainFrame frame) {

		this.frame = frame;
		this.m = MainScreen.m;

		setLayout(new BorderLayout());

		//パーツ設定

		Lbutton[0] = new JButton();
		Lbutton[0].setText("ログイン");
		Lbutton[0].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 35));
		Lbutton[0].addActionListener(this);

		label01 = new JLabel("従業員管理ログイン画面");
		label01.setFont(new Font("ＭＳ ゴシック", 0, 70));
		label01.setHorizontalAlignment(SwingConstants.CENTER);
		label01.setForeground(Color.GREEN);
		label01.setBackground(Color.BLACK);
		label01.setOpaque(true);

		label[0] = new JLabel("IPアドレス");
		label[0].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[0].setBackground(Color.GREEN);
		label[0].setOpaque(true);
		label[0].setHorizontalAlignment(SwingConstants.CENTER);

		text[0] = new JTextField("192.168.91.133");
		text[0].setFont(new Font("ＭＳ ゴシック", 0, 45));

		label[1] = new JLabel("");
		label[1].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[1].setBackground(Color.GREEN);
		label[1].setOpaque(true);
		label[1].setHorizontalAlignment(SwingConstants.CENTER);

		label[2] = new JLabel("ユーザー名");
		label[2].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[2].setBackground(Color.GREEN);
		label[2].setOpaque(true);
		label[2].setHorizontalAlignment(SwingConstants.CENTER);

		text[1] = new JTextField("xperia");
		text[1].setFont(new Font("ＭＳ ゴシック", 0, 45));

		label[3] = new JLabel("");
		label[3].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[3].setBackground(Color.GREEN);
		label[3].setOpaque(true);
		label[3].setHorizontalAlignment(SwingConstants.CENTER);

		label[4] = new JLabel("パスワード");
		label[4].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[4].setBackground(Color.GREEN);
		label[4].setOpaque(true);
		label[4].setHorizontalAlignment(SwingConstants.CENTER);

		text[2] = new JTextField("password");
		text[2].setFont(new Font("ＭＳ ゴシック", 0, 45));

		label[5] = new JLabel("ログインしてください");
		label[5].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[5].setBackground(Color.GREEN);
		label[5].setOpaque(true);
		label[5].setHorizontalAlignment(SwingConstants.CENTER);

		//パネル設定
		p[0] = new JPanel();
		p[0].setLayout(new GridLayout(1, 1));
		p[0].add(label01);
		this.add(p[0], BorderLayout.NORTH);

		p[1] = new JPanel();
		p[1].setLayout(new GridLayout(3, 3));
		p[1].add(label[0]);
		p[1].add(text[0]);
		p[1].add(label[1]);
		p[1].add(label[2]);
		p[1].add(text[1]);
		p[1].add(label[3]);
		p[1].add(label[4]);
		p[1].add(text[2]);
		p[1].add(Lbutton[0]);
		this.add(p[1], BorderLayout.CENTER);

		p[2] = new JPanel();
		p[2].setLayout(new GridLayout(1, 1));
		p[2].add(label[5]);
		this.add(p[2], BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		boolean handan = false;

		if (object == Lbutton[0]) {

			try {
				handan = m.Login(text[0].getText(), text[1].getText(), text[2].getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			if (handan == true) {
				MainPanel panel = new MainPanel(this.frame);
				frame.changeWindow(panel);
			} else {
				label[5].setText("ログインできませんでした");
			}
		}
	}
}
