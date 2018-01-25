
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DbPanel extends JPanel implements ActionListener {

	private MainFrame frame;
	private MariaDbConnector m;
	private JButton button[] = new JButton[5];
	private JLabel label[] = new JLabel[5];
	private JPanel p[] = new JPanel[5];

	public DbPanel(MainFrame frame) {

		this.frame = frame;
		this.m = MainScreen.m;
		setLayout(new BorderLayout());

		button[0] = new JButton();
		button[0].setText("<html>入力<br/>変更<br/>削除</html>");
		button[0].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 35));
		button[0].addActionListener(this);

		button[1] = new JButton();
		button[1].setText("<html>参照<br/>検索</html>");
		button[1].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 35));
		button[1].addActionListener(this);

		button[2] = new JButton();
		button[2].setText("<html>メイン画面に戻る</html>");
		button[2].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 35));
		button[2].addActionListener(this);

		label[0] = new JLabel("");
		label[0].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 35));

		label[1] = new JLabel();
		label[1].setText("<html>従業員管理データベース画面</html>");
		label[1].setFont(new Font("ＭＳ ゴシック", 0, 70));
		label[1].setHorizontalAlignment(SwingConstants.CENTER);
		label[1].setForeground(Color.GREEN);
		label[1].setBackground(Color.BLACK);
		label[1].setOpaque(true);

		p[0] = new JPanel();
		p[0].setLayout(new GridLayout(2, 0));
		this.add(p[0], BorderLayout.NORTH);

		p[1] = new JPanel();
		p[1].setLayout(new GridLayout(1, 2));
		p[1].add(button[2]);
		p[0].add(p[1], BorderLayout.NORTH);

		p[2] = new JPanel();
		p[2].setLayout(new GridLayout(1, 0));
		p[2].add(label[1]);
		p[0].add(p[2], BorderLayout.CENTER);

		p[3] = new JPanel();
		p[3].setLayout(new GridLayout(1, 2));
		p[3].add(button[0]);
		p[3].add(button[1]);
		this.add(p[3], BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		// 入力画面の呼び出し
		if (object == button[0]) {
			DbSubPanel1 panel = new DbSubPanel1(this.frame);
			frame.changeWindow(panel);
		}
		// 参照画面パネルの呼び出し
		if (object == button[1]) {
			DbSubPanel2 panel = new DbSubPanel2(this.frame);
			frame.changeWindow(panel);
		}
		// メイン画面パネルの呼び出し
		if (object == button[2]) {
			MainPanel panel = new MainPanel(this.frame);
			frame.changeWindow(panel);
		}
	}
}
