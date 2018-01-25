import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SfSubPanel2 extends JPanel implements ActionListener {

	private MainFrame frame;
	private MariaDbConnector m;
	private JButton Mbutton[] = new JButton[5];
	private JButton Kbutton[] = new JButton[3];// 決定ボタン
	private JLabel label[] = new JLabel[5];
	private JTextField text[] = new JTextField[10];// 入力
	private JPanel p[] = new JPanel[5];

	public SfSubPanel2(MainFrame frame) {

		this.frame = frame;
		this.m = MainScreen.m;

		setLayout(new BorderLayout());

		Mbutton[0] = new JButton();
		Mbutton[0].setText("<html>メイン画面に戻る</html>");
		Mbutton[0].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 35));
		Mbutton[0].addActionListener(this);

		Mbutton[1] = new JButton();
		Mbutton[1].setText("<html>前に戻る</html>");
		Mbutton[1].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 35));
		Mbutton[1].addActionListener(this);

		label[0] = new JLabel("シフト参照画面");
		label[0].setFont(new Font("ＭＳ ゴシック", 0, 70));
		label[0].setHorizontalAlignment(SwingConstants.CENTER);
		label[0].setForeground(Color.GREEN);
		label[0].setBackground(Color.BLACK);
		label[0].setOpaque(true);

		label[1] = new JLabel("従業員ID");
		label[1].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[1].setHorizontalAlignment(SwingConstants.CENTER);
		label[1].setOpaque(true);

		text[0] = new JTextField();
		text[0].setFont(new Font("ＭＳ ゴシック", 0, 30));

		label[2] = new JLabel("検索範囲(開始)");
		label[2].setFont(new Font("ＭＳ ゴシック", 0, 20));
		label[2].setHorizontalAlignment(SwingConstants.CENTER);
		label[2].setOpaque(true);

		text[1] = new JTextField();
		text[1].setFont(new Font("ＭＳ ゴシック", 0, 30));

		label[3] = new JLabel("検索範囲(終了)");
		label[3].setFont(new Font("ＭＳ ゴシック", 0, 20));
		label[3].setHorizontalAlignment(SwingConstants.CENTER);
		label[3].setOpaque(true);

		text[2] = new JTextField();
		text[2].setFont(new Font("ＭＳ ゴシック", 0, 30));

		Kbutton[0] = new JButton("決定");

		// パネル設定

		p[0] = new JPanel();
		p[0].setLayout(new GridLayout(3, 0));
		this.add(p[0], BorderLayout.NORTH);

		p[1] = new JPanel();
		p[1].setLayout(new GridLayout(0, 2));
		p[1].add(Mbutton[0]);
		p[1].add(Mbutton[1]);
		Mbutton[0].addActionListener(this);
		p[0].add(p[1], BorderLayout.NORTH);

		p[2] = new JPanel();
		p[2].setLayout(new GridLayout(1, 0));
		p[2].add(label[0]);
		p[0].add(p[2], BorderLayout.CENTER);

		p[3] = new JPanel();
		p[3].setLayout(new GridLayout(1, 7));
		p[3].add(label[1]);
		p[3].add(text[0]);
		p[3].add(label[2]);
		p[3].add(text[1]);
		p[3].add(label[3]);
		p[3].add(text[2]);
		p[3].add(Kbutton[0]);
		p[0].add(p[3], BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		// メイン画面パネルの呼び出し
		if (object == Mbutton[0]) {
			MainPanel panel = new MainPanel(this.frame);
			frame.changeWindow(panel);
		}
		if (object == Mbutton[1]) {
			SfPanel panel = new SfPanel(this.frame);
			frame.changeWindow(panel);
		}
	}
}