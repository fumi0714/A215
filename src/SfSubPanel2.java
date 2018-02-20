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

public class SfSubPanel2 extends JPanel implements ActionListener {

	private MainFrame frame;
	private MariaDbConnector m;
	private JButton Mbutton[] = new JButton[5];
	private JButton Kbutton[] = new JButton[3];// 決定ボタン
	private JLabel label[] = new JLabel[20];
	private JTextField text[] = new JTextField[10];// 入力
	private JPanel p[] = new JPanel[5];
	private String id;
	private String start[] = new String[7];
	private String end[] = new String[7];

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

		text[0] = new JTextField("1");
		text[0].setFont(new Font("ＭＳ ゴシック", 0, 30));

		label[2] = new JLabel("検索範囲(開始)");
		label[2].setFont(new Font("ＭＳ ゴシック", 0, 20));
		label[2].setHorizontalAlignment(SwingConstants.CENTER);
		label[2].setOpaque(true);

		text[1] = new JTextField("2018-01-15 18:00:00");
		text[1].setFont(new Font("ＭＳ ゴシック", 0, 30));

		label[3] = new JLabel("検索範囲(終了)");
		label[3].setFont(new Font("ＭＳ ゴシック", 0, 20));
		label[3].setHorizontalAlignment(SwingConstants.CENTER);
		label[3].setOpaque(true);

		text[2] = new JTextField("2018-01-17 23:59:59");
		text[2].setFont(new Font("ＭＳ ゴシック", 0, 30));

		//表示用ラベル

		//1
		label[4] = new JLabel("検索結果1日目を表示します");
		label[4].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[4].setHorizontalAlignment(SwingConstants.CENTER);
		label[4].setOpaque(true);
		//2
		label[5] = new JLabel();
		label[5].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[5].setHorizontalAlignment(SwingConstants.CENTER);
		label[5].setOpaque(true);
		//3
		label[6] = new JLabel("検索結果2日目を表示します");
		label[6].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[6].setHorizontalAlignment(SwingConstants.CENTER);
		label[6].setOpaque(true);
		//4
		label[7] = new JLabel();
		label[7].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[7].setHorizontalAlignment(SwingConstants.CENTER);
		label[7].setOpaque(true);
		//5
		label[8] = new JLabel("検索結果3日目を表示します");
		label[8].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[8].setHorizontalAlignment(SwingConstants.CENTER);
		label[8].setOpaque(true);
		//6
		label[9] = new JLabel();
		label[9].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[9].setHorizontalAlignment(SwingConstants.CENTER);
		label[9].setOpaque(true);
		//7
		label[10] = new JLabel("検索結果4日目を表示します");
		label[10].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[10].setHorizontalAlignment(SwingConstants.CENTER);
		label[10].setOpaque(true);
		//8
		label[11] = new JLabel();
		label[11].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[11].setHorizontalAlignment(SwingConstants.CENTER);
		label[11].setOpaque(true);
		//9
		label[12] = new JLabel("検索結果5日目を表示します");
		label[12].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[12].setHorizontalAlignment(SwingConstants.CENTER);
		label[12].setOpaque(true);
		//10
		label[13] = new JLabel();
		label[13].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[13].setHorizontalAlignment(SwingConstants.CENTER);
		label[13].setOpaque(true);
		//11
		label[14] = new JLabel("検索結果6日目を表示します");
		label[14].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[14].setHorizontalAlignment(SwingConstants.CENTER);
		label[14].setOpaque(true);
		//12
		label[15] = new JLabel();
		label[15].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[15].setHorizontalAlignment(SwingConstants.CENTER);
		label[15].setOpaque(true);
		//13
		label[16] = new JLabel("検索結果7日目を表示します");
		label[16].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[16].setHorizontalAlignment(SwingConstants.CENTER);
		label[16].setOpaque(true);
		//14
		label[17] = new JLabel();
		label[17].setFont(new Font("ＭＳ ゴシック", 0, 35));
		label[17].setHorizontalAlignment(SwingConstants.CENTER);
		label[17].setOpaque(true);

		Kbutton[0] = new JButton("決定");
		Kbutton[0].addActionListener(this);

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

		p[4] = new JPanel();
		p[4].setLayout(new GridLayout(7, 2));
		p[4].add(label[4]);//1
		p[4].add(label[5]);//2
		p[4].add(label[6]);//3
		p[4].add(label[7]);//4
		p[4].add(label[8]);//5
		p[4].add(label[9]);//6
		p[4].add(label[10]);//7
		p[4].add(label[11]);//8
		p[4].add(label[12]);//9
		p[4].add(label[13]);//10
		p[4].add(label[14]);//11
		p[4].add(label[15]);//12
		p[4].add(label[16]);//13
		p[4].add(label[17]);//14
		this.add(p[4], BorderLayout.CENTER);

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
					id = text[0].getText();
					start[0] = text[1].getText();
					end[0] = text[2].getText();

					m.SSelect(id, start, end);

					label[4].setText(start[0]);
					label[5].setText(end[0]);
					label[6].setText(start[1]);
					label[7].setText(end[1]);
					label[8].setText(start[2]);
					label[9].setText(end[2]);
					label[10].setText(start[3]);
					label[11].setText(end[3]);
					label[12].setText(start[4]);
					label[13].setText(end[4]);
					label[14].setText(start[5]);
					label[15].setText(end[5]);
					label[16].setText(start[6]);
					label[17].setText(end[6]);

				}
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				System.out.println(e1.toString());
				e1.printStackTrace();
			}
		}
	}
}