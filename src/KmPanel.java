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

public class KmPanel extends JPanel implements ActionListener {

	private MainFrame frame;
	private MariaDbConnector m;
	private JButton Mbutton[] = new JButton[5];
	private JButton Kbutton[] = new JButton[3];// 決定ボタン
	private JLabel label[] = new JLabel[6];
	private JLabel Klabel[] = new JLabel[5]; // 空白用ラベル
	private JTextField text[] = new JTextField[10];// 入力
	private JPanel p[] = new JPanel[6];
	private int Itext0,Itext1,Jikyu;
	private String Stext0,Stext1,Sjikyu;

	public KmPanel(MainFrame frame) {

		this.frame = frame;
		this.m = MainScreen.m;

		setLayout(new BorderLayout());

		Mbutton[0] = new JButton("Button3");
		Mbutton[0].setText("<html>メイン画面に戻る</html>");
		Mbutton[0].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 35));
		Mbutton[0].addActionListener(this);

		label[0] = new JLabel("給与明細画面");
		label[0].setFont(new Font("ＭＳ ゴシック", 0, 70));
		label[0].setHorizontalAlignment(SwingConstants.CENTER);
		label[0].setForeground(Color.GREEN);
		label[0].setBackground(Color.BLACK);
		label[0].setOpaque(true);

		label[1] = new JLabel("勤務開始時間");
		label[1].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[1].setHorizontalAlignment(SwingConstants.CENTER);
		label[1].setOpaque(true);

		text[0] = new JTextField("0");
		Stext0 = text[0].getText();
		Itext0 = Integer.parseInt(Stext0);

		label[2] = new JLabel("勤務終了時間");
		label[2].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[2].setHorizontalAlignment(SwingConstants.CENTER);
		label[2].setOpaque(true);

		text[1] = new JTextField("0");
		Stext1 = text[1].getText();
		Itext1 = Integer.parseInt(Stext1);

		Klabel[0] = new JLabel("");

		label[3] = new JLabel("休憩時間");
		label[3].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[3].setHorizontalAlignment(SwingConstants.CENTER);
		label[3].setOpaque(true);

		text[2] = new JTextField();

		label[4] = new JLabel("時給");
		label[4].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[4].setHorizontalAlignment(SwingConstants.CENTER);
		label[4].setOpaque(true);

		text[3] = new JTextField("0");
		Sjikyu = text[3].getText();
		Jikyu = Integer.parseInt(Sjikyu);

		label[5] = new JLabel("日給の計算結果");
		label[5].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[5].setHorizontalAlignment(SwingConstants.CENTER);
		label[5].setOpaque(true);


		Kbutton[0] = new JButton("決定");

		// パネル設定

		p[0] = new JPanel();
		p[0].setLayout(new GridLayout(2, 1));
		this.add(p[0], BorderLayout.NORTH);

		p[1] = new JPanel();
		p[1].setLayout(new GridLayout(2, 1));
		this.add(p[1], BorderLayout.CENTER);

		p[2] = new JPanel();
		p[2].setLayout(new GridLayout(1, 0));
		p[2].add(Mbutton[0]);
		Mbutton[0].addActionListener(this);
		p[0].add(p[2], BorderLayout.NORTH);

		p[3] = new JPanel();
		p[3].setLayout(new GridLayout(1, 0));
		p[3].add(label[0]);
		p[0].add(p[3], BorderLayout.CENTER);

		p[4] = new JPanel();
		p[4].setLayout(new GridLayout(2, 5));
		p[4].add(label[1]);
		p[4].add(text[0]);
		p[4].add(label[2]);
		p[4].add(text[1]);
		p[4].add(Klabel[0]);
		p[4].add(label[3]);
		p[4].add(text[2]);
		p[4].add(label[4]);
		p[4].add(text[3]);
		p[4].add(Kbutton[0]);
		p[1].add(p[4], BorderLayout.NORTH);

		p[5] = new JPanel();
		p[5].setLayout(new GridLayout(0, 1));
		p[5].add(label[5]);
		p[1].add(p[5], BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		// メイン画面パネルの呼び出し
		if (object == Mbutton[0]) {
			MainPanel panel = new MainPanel(this.frame);
			frame.changeWindow(panel);
		}
		if(object == Kbutton[0]) {
			int nikyu = 0;
			int roudou = 0;
			roudou = Itext1 - Itext0;
			nikyu = roudou * Jikyu;
			System.out.println(nikyu);

		}
	}
}
