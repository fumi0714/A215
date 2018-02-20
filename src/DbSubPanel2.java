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
import javax.swing.SwingConstants;

public class DbSubPanel2 extends JPanel implements ActionListener {

	private MainFrame frame;
	private MariaDbConnector m;
	private JLabel label[] = new JLabel[30];
	private JButton Mbutton[] = new JButton[2];// メニューボタン
	private JButton Kbutton[] = new JButton[5];// 決定ボタン
	private JTextArea area = new JTextArea();
	private JPanel p[] = new JPanel[5];
	private String K[] = new String[6];

	public DbSubPanel2(MainFrame frame) {

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
		label[0] = new JLabel("従業員管理DB参照画面");
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

		label[3] = new JLabel("従業員ID");
		label[3].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[3].setHorizontalAlignment(SwingConstants.CENTER);
		label[3].setOpaque(true);

		label[4] = new JLabel("");
		label[4].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[4].setHorizontalAlignment(SwingConstants.CENTER);
		label[4].setOpaque(true);

		label[5] = new JLabel("氏名");
		label[5].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[5].setHorizontalAlignment(SwingConstants.CENTER);
		label[5].setOpaque(true);

		label[6] = new JLabel("");
		label[6].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[6].setHorizontalAlignment(SwingConstants.CENTER);
		label[6].setOpaque(true);

		label[7] = new JLabel("生年月日");
		label[7].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[7].setHorizontalAlignment(SwingConstants.CENTER);
		label[7].setOpaque(true);

		label[8] = new JLabel("");
		label[8].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[8].setHorizontalAlignment(SwingConstants.CENTER);
		label[8].setOpaque(true);

		label[9] = new JLabel("住所");
		label[9].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[9].setHorizontalAlignment(SwingConstants.CENTER);
		label[9].setOpaque(true);

		label[10] = new JLabel("");
		label[10].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[10].setHorizontalAlignment(SwingConstants.CENTER);
		label[10].setOpaque(true);

		label[11] = new JLabel("入社日");
		label[11].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[11].setHorizontalAlignment(SwingConstants.CENTER);
		label[11].setOpaque(true);

		label[12] = new JLabel("");
		label[12].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[12].setHorizontalAlignment(SwingConstants.CENTER);
		label[12].setOpaque(true);

		label[13] = new JLabel("時給");
		label[13].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[13].setHorizontalAlignment(SwingConstants.CENTER);
		label[13].setOpaque(true);

		label[14] = new JLabel("");
		label[14].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[14].setHorizontalAlignment(SwingConstants.CENTER);
		label[14].setOpaque(true);

		area = new JTextArea();
		area.setFont(new Font("ＭＳ ゴシック", 0, 40));
	    area.setLineWrap(true);

		Kbutton[0] = new JButton("決定");
		Kbutton[0].setFont(new Font("ＭＳ ゴシック", 0, 35));
		Kbutton[0].setOpaque(true);
		Kbutton[0].setHorizontalAlignment(SwingConstants.CENTER);
		Kbutton[0].addActionListener(this);

		p[0] = new JPanel();
		p[0].setLayout(new GridLayout(3, 0));
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
		p[3].setLayout(new GridLayout(1, 3));
		p[3].add(label[1]);
		p[3].add(label[2]);
		p[3].add(area);
		p[3].add(Kbutton[0]);
		p[0].add(p[3], BorderLayout.SOUTH);

		p[4] = new JPanel();
		p[4].setLayout(new GridLayout(6, 2));
		p[4].add(label[3]);
		p[4].add(label[4]);
		p[4].add(label[5]);
		p[4].add(label[6]);
		p[4].add(label[7]);
		p[4].add(label[8]);
		p[4].add(label[9]);
		p[4].add(label[10]);
		p[4].add(label[11]);
		p[4].add(label[12]);
		p[4].add(label[13]);
		p[4].add(label[14]);
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
			DbPanel panel = new DbPanel(this.frame);
			frame.changeWindow(panel);
		}
		if (object == Kbutton[0]) {
			try {
				if(m!=null) {
					K[0] = area.getText();
					m.Select(K);
					label[4].setText(K[0]);
					label[6].setText(K[1]);
					label[8].setText(K[2]);
					label[10].setText(K[3]);
					label[12].setText(K[4]);
					label[14].setText(K[5]);
				}
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				System.out.println(e1.toString());
				e1.printStackTrace();
			}
		}
	}
}
