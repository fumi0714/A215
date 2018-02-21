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

public class SfSubPanel1 extends JPanel implements ActionListener {

	private MainFrame frame;
	private MariaDbConnector m;
	private JLabel label[] = new JLabel[30];
	private JButton Mbutton[] = new JButton[3];// メニューボタン
	private JButton Kbutton[] = new JButton[5];// 決定ボタン
	private JTextField text[] = new JTextField[20];// 入力
	private JPanel p[] = new JPanel[5];

	public SfSubPanel1(MainFrame frame) {

		this.frame = frame;
		this.m = MainScreen.m;

		setLayout(new BorderLayout());

		// メニューボタン
		Mbutton[0] = new JButton();
		Mbutton[0].setText("<html>メイン画面に戻る</html>");
		Mbutton[0].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 35));

		Mbutton[1] = new JButton();
		Mbutton[1].setText("<html>前に戻る</html>");
		Mbutton[1].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 35));

		// タイトルラベル
		label[0] = new JLabel("シフト管理入力画面");
		label[0].setFont(new Font("ＭＳ ゴシック", 0, 100));
		label[0].setHorizontalAlignment(SwingConstants.CENTER);
		label[0].setForeground(Color.GREEN);
		label[0].setBackground(Color.BLACK);
		label[0].setOpaque(true);

		label[1] = new JLabel("参照");
		label[1].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[1].setHorizontalAlignment(SwingConstants.CENTER);
		label[1].setOpaque(true);

		label[2] = new JLabel("ID");
		label[2].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[2].setHorizontalAlignment(SwingConstants.CENTER);
		label[2].setOpaque(true);

		text[0] = new JTextField();

		// パネル設定

		p[0] = new JPanel();
		p[0].setLayout(new GridLayout(2, 0));
		this.add(p[0], BorderLayout.NORTH);

		p[1] = new JPanel();
		p[1].setLayout(new GridLayout(0, 2));
		p[1].add(Mbutton[0]);
		Mbutton[0].addActionListener(this);
		p[1].add(Mbutton[1]);
		Mbutton[1].addActionListener(this);
		p[0].add(p[1], BorderLayout.NORTH);

		p[2] = new JPanel();
		p[2].setLayout(new GridLayout(1, 0));
		p[2].add(label[0]);
		p[0].add(p[2], BorderLayout.CENTER);

		p[3] = new JPanel();
		p[3].setLayout(new GridLayout(5, 6));

		// 入力列

		label[0] = new JLabel("入力");
		label[0].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[0].setOpaque(true);
		label[0].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[0]);

		label[1] = new JLabel("従業員ID");
		label[1].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[1].setOpaque(true);
		label[1].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[1]);

		text[0] = new JTextField("1");
		text[0].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(text[0]);

		label[2] = new JLabel("");
		p[3].add(label[2]);

		label[3] = new JLabel("");
		p[3].add(label[3]);

		label[4] = new JLabel("");
		label[4].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(label[4]);

		label[5] = new JLabel("");
		label[5].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(label[5]);

		label[6] = new JLabel("勤務開始時間");
		label[6].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[6].setOpaque(true);
		label[6].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[6]);

		text[2] = new JTextField("2018-01-14 18:00:00");
		text[2].setFont(new Font("ＭＳ ゴシック", 0, 30));
		p[3].add(text[2]);

		label[7] = new JLabel("勤務終了時間");
		label[7].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[7].setOpaque(true);
		label[7].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[7]);

		text[3] = new JTextField("2018-01-14 22:00:00");
		text[3].setFont(new Font("ＭＳ ゴシック", 0, 30));
		p[3].add(text[3]);

		Kbutton[0] = new JButton("決定");
		Kbutton[0].setFont(new Font("ＭＳ ゴシック", 0, 35));
		Kbutton[0].setOpaque(true);
		Kbutton[0].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(Kbutton[0]);
		Kbutton[0].addActionListener(this);

		// 変更列

		label[8] = new JLabel("変更");
		label[8].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[8].setOpaque(true);
		label[8].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[8]);

		label[9] = new JLabel("シフトID");
		label[9].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[9].setOpaque(true);
		label[9].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[9]);

		text[4] = new JTextField("1");
		text[4].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(text[4]);

		label[10] = new JLabel("");
		p[3].add(label[10]);

		label[11] = new JLabel("");
		p[3].add(label[11]);

		label[12] = new JLabel("");
		label[12].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(label[12]);

		label[13] = new JLabel("");
		label[13].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(label[13]);

		label[14] = new JLabel("勤務開始時間");
		label[14].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[14].setOpaque(true);
		label[14].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[14]);

		text[6] = new JTextField("2018-01-14 18:00:00");
		text[6].setFont(new Font("ＭＳ ゴシック", 0, 30));
		p[3].add(text[6]);

		label[15] = new JLabel("勤務終了時間");
		label[15].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[15].setOpaque(true);
		label[15].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[15]);

		text[7] = new JTextField("2018-01-14 23:00:00");
		text[7].setFont(new Font("ＭＳ ゴシック", 0, 30));
		p[3].add(text[7]);

		Kbutton[1] = new JButton("決定");
		Kbutton[1].setFont(new Font("ＭＳ ゴシック", 0, 35));
		Kbutton[1].setOpaque(true);
		Kbutton[1].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(Kbutton[1]);
		Kbutton[1].addActionListener(this);

		// 削除列

		label[16] = new JLabel("削除");
		label[16].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[16].setOpaque(true);
		label[16].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[16]);

		label[17] = new JLabel("シフトID");
		label[17].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[17].setOpaque(true);
		label[17].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[17]);

		text[8] = new JTextField("1");
		text[8].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(text[8]);

		label[18] = new JLabel();
		p[3].add(label[18]);

		label[19] = new JLabel();
		p[3].add(label[19]);

		Kbutton[2] = new JButton("決定");
		Kbutton[2].setFont(new Font("ＭＳ ゴシック", 0, 35));
		Kbutton[2].setOpaque(true);
		Kbutton[2].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(Kbutton[2]);
		Kbutton[2].addActionListener(this);

		this.add(p[3], BorderLayout.CENTER);
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
		if (object == Kbutton[0]) {
			try {
				if (m != null) {
					System.out.println("Kbutton[0]in");
					m.SInsert(text[0].getText(), text[2].getText(), text[3].getText());
					System.out.println("Kbutton[0]out");
				}
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				System.out.println(e1.toString());
				e1.printStackTrace();
			}
		}
		if (object == Kbutton[2]) {
			try {
				if (m != null) {
					m.SDelete(text[8].getText());
				}
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				System.out.println(e1.toString());
				e1.printStackTrace();
			}
		}
	}
}
