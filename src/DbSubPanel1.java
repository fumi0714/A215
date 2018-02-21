
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DbSubPanel1 extends JPanel implements ActionListener {

	private MainFrame frame;
	private MariaDbConnector m;
	private JLabel label[] = new JLabel[30];
	private JButton Mbutton[] = new JButton[2];// メニューボタン
	private JButton Kbutton[] = new JButton[5];// 決定ボタン
	private JTextField text[] = new JTextField[15];// 入力
	private JTextArea area = new JTextArea();
	private JPanel p[] = new JPanel[5];

	public DbSubPanel1(MainFrame frame) {

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
		label[0] = new JLabel("従業員管理DB入力画面");
		label[0].setFont(new Font("ＭＳ ゴシック", 0, 100));
		label[0].setHorizontalAlignment(SwingConstants.CENTER);
		label[0].setForeground(Color.GREEN);
		label[0].setBackground(Color.BLACK);
		label[0].setOpaque(true);

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
//
		p[2] = new JPanel();
		p[2].setLayout(new GridLayout(1, 0));
		p[2].add(label[0]);
		p[0].add(p[2], BorderLayout.CENTER);

		p[3] = new JPanel();
		p[3].setLayout(new GridLayout(6, 6));

		// p[3]パネルの部品

		label[0] = new JLabel("新規登録");
		label[0].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[0].setOpaque(true);
		label[0].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[0]);

		label[1] = new JLabel("氏名");
		label[1].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[1].setOpaque(true);
		label[1].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[1]);

		text[0] = new JTextField("杜元計助");
		text[0].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(text[0]);

		label[2] = new JLabel("生年月日");
		label[2].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[2].setOpaque(true);
		label[2].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[2]);

		text[1] = new JTextField("19971007");
		text[1].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(text[1]);

		label[3] = new JLabel("");
		p[3].add(label[3]);

		label[4] = new JLabel("");
		p[3].add(label[4]);

		label[5] = new JLabel("住所");
		label[5].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[5].setOpaque(true);
		label[5].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[5]);

		area = new JTextArea("埼玉県上尾市");
		area.setFont(new Font("ＭＳ ゴシック", 0, 35));
	    area.setLineWrap(true);
		p[3].add(area);

		label[6] = new JLabel("入社日");
		label[6].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[6].setOpaque(true);
		label[6].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[6]);

		text[3] = new JTextField("20180222");
		text[3].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(text[3]);

		label[7] = new JLabel("");
		p[3].add(label[7]);

		label[8] = new JLabel("");
		p[3].add(label[8]);

		label[9] = new JLabel("時給");
		label[9].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[9].setOpaque(true);
		label[9].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[9]);

		text[4] = new JTextField("1");
		text[4].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(text[4]);

		label[10] = new JLabel();
		p[3].add(label[10]);

		label[11] = new JLabel();
		p[3].add(label[11]);

		Kbutton[0] = new JButton("決定");
		Kbutton[0].setFont(new Font("ＭＳ ゴシック", 0, 35));
		Kbutton[0].setOpaque(true);
		Kbutton[0].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(Kbutton[0]);
		Kbutton[0].addActionListener(this);

		//変更処理

		label[12] = new JLabel("変更項目");
		label[12].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[12].setOpaque(true);
		label[12].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[12]);

		label[13] = new JLabel("従業員ID");
		label[13].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[13].setOpaque(true);
		label[13].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[13]);

		text[6] = new JTextField("2");
		text[6].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(text[6]);

		label[14] = new JLabel("項目");
		label[14].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[14].setOpaque(true);
		label[14].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[14]);

		text[7] = new JTextField("NAME");
		text[7].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(text[7]);

		label[15] = new JLabel("");
		p[3].add(label[15]);

		label[16] = new JLabel("");
		p[3].add(label[16]);

		label[17] = new JLabel("値");
		label[17].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[17].setOpaque(true);
		label[17].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[17]);

		text[8] = new JTextField("森本啓介");
		text[8].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(text[8]);

		label[18] = new JLabel("");
		p[3].add(label[18]);

		label[19] = new JLabel("");
		p[3].add(label[19]);

		Kbutton[1] = new JButton("決定");
		Kbutton[1].setFont(new Font("ＭＳ ゴシック", 0, 35));
		Kbutton[1].setOpaque(true);
		Kbutton[1].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(Kbutton[1]);
		Kbutton[1].addActionListener(this);

		label[20] = new JLabel("退職");
		label[20].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[20].setOpaque(true);
		label[20].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[20]);

		label[21] = new JLabel("従業員ID");
		label[21].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[21].setOpaque(true);
		label[21].setHorizontalAlignment(SwingConstants.CENTER);
		p[3].add(label[21]);

		text[9] = new JTextField();
		text[9].setFont(new Font("ＭＳ ゴシック", 0, 35));
		p[3].add(text[9]);

		label[22] = new JLabel("");
		p[3].add(label[22]);

		label[23] = new JLabel("");
		p[3].add(label[23]);

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
			DbPanel panel = new DbPanel(this.frame);
			frame.changeWindow(panel);
		}
		if(object == Kbutton[0]) {
			try {
				if(m!=null) {
					m.Insert(text[0].getText(),text[1].getText(),area.getText(),
							text[3].getText(),text[4].getText());
				}
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				System.out.println(e1.toString());
				e1.printStackTrace();
			}
		}
		if(object == Kbutton[1]) {
			try {
				if(m!=null) {
					m.Update(text[6].getText(),text[7].getText(),text[8].getText());
				}
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				System.out.println(e1.toString());
				e1.printStackTrace();
			}
		}
		if(object == Kbutton[2]) {
			try {
				if(m!=null) {
					m.Delete(text[9].getText());
				}
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				System.out.println(e1.toString());
				e1.printStackTrace();
			}
		}
	}
}
