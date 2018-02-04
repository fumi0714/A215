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
	private JButton Mbutton[] = new JButton[5]; //メニューボタン
	private JButton Kbutton[] = new JButton[3];// 決定ボタン
	private JLabel label[] = new JLabel[15]; //ラベル
	private JLabel Klabel[] = new JLabel[5]; // 空白用ラベル
	private JTextField text[] = new JTextField[10];// 入力
	private JPanel p[] = new JPanel[6]; //パネル用
	private double dtext[] = new double[10]; //浮動演算変換用変数
	private double nikyu[] = new double[4];
	//0]は勤務時間外倍率無し
	//[1]は休憩時間無し
	//[2]は休憩時間有り
	private double tm[] = new double[3];
	//[0]は時給
	//[1]は分給
	//[2]は勤務時間外のはみ出し金
	private double ktime;//勤務時間変数
	private double kyutime;//休憩時間
	private double kbai;//勤務時間外倍率
	private int n;//日給(計算結果後)

	public KmPanel(MainFrame frame) {

		this.frame = frame;
		this.m = MainScreen.m;

		setLayout(new BorderLayout());

		Mbutton[0] = new JButton();
		Mbutton[0].setText("<html>メイン画面に戻る</html>");
		Mbutton[0].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 35));
		Mbutton[0].addActionListener(this);

		label[0] = new JLabel("日給計算画面");
		label[0].setFont(new Font("ＭＳ ゴシック", 0, 70));
		label[0].setHorizontalAlignment(SwingConstants.CENTER);
		label[0].setForeground(Color.GREEN);
		label[0].setBackground(Color.BLACK);
		label[0].setOpaque(true);

		label[1] = new JLabel("勤務時間");
		label[1].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[1].setHorizontalAlignment(SwingConstants.CENTER);
		label[1].setOpaque(true);

		//文字列を整数変換
		//勤務時間用テキストフィールド
		text[0] = new JTextField("5");
		dtext[0] = Double.parseDouble(text[0].getText());
		text[0].setFont(new Font("ＭＳ ゴシック", 0, 30));
		text[0].setHorizontalAlignment(SwingConstants.CENTER);
		text[0].setOpaque(true);

		label[2] = new JLabel("時");
		label[2].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[2].setHorizontalAlignment(SwingConstants.CENTER);
		label[2].setOpaque(true);

		text[1] = new JTextField("0");
		dtext[1] = Double.parseDouble(text[1].getText());
		text[1].setFont(new Font("ＭＳ ゴシック", 0, 30));
		text[1].setHorizontalAlignment(SwingConstants.CENTER);
		text[1].setOpaque(true);

		label[3] = new JLabel("分");
		label[3].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[3].setHorizontalAlignment(SwingConstants.CENTER);
		label[3].setOpaque(true);

		label[4] = new JLabel("勤務時間外");
		label[4].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[4].setHorizontalAlignment(SwingConstants.CENTER);
		label[4].setOpaque(true);

		text[2] = new JTextField("1");
		dtext[2] = Double.parseDouble(text[2].getText());
		text[2].setFont(new Font("ＭＳ ゴシック", 0, 30));
		text[2].setHorizontalAlignment(SwingConstants.CENTER);
		text[2].setOpaque(true);

		label[5] = new JLabel("時");
		label[5].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[5].setHorizontalAlignment(SwingConstants.CENTER);
		label[5].setOpaque(true);

		text[3] = new JTextField("0");
		dtext[3] = Double.parseDouble(text[3].getText());
		text[3].setFont(new Font("ＭＳ ゴシック", 0, 30));
		text[3].setHorizontalAlignment(SwingConstants.CENTER);
		text[3].setOpaque(true);

		label[6] = new JLabel("分");
		label[6].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[6].setHorizontalAlignment(SwingConstants.CENTER);
		label[6].setOpaque(true);

		label[7] = new JLabel("勤務時間外倍率");
		label[7].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[7].setHorizontalAlignment(SwingConstants.CENTER);
		label[7].setOpaque(true);

		//文字列をDoubleに変換
		text[4] = new JTextField("1.25");
		dtext[4] = Double.parseDouble(text[4].getText());
		text[4].setFont(new Font("ＭＳ ゴシック", 0, 30));
		text[4].setHorizontalAlignment(SwingConstants.CENTER);
		text[4].setOpaque(true);

		label[8] = new JLabel("倍");
		label[8].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[8].setHorizontalAlignment(SwingConstants.CENTER);
		label[8].setOpaque(true);

		Klabel[0] = new JLabel("");
		Klabel[0].setFont(new Font("ＭＳ ゴシック", 0, 30));
		Klabel[0].setHorizontalAlignment(SwingConstants.CENTER);
		Klabel[0].setOpaque(true);

		Klabel[1] = new JLabel("");
		Klabel[1].setFont(new Font("ＭＳ ゴシック", 0, 30));
		Klabel[1].setHorizontalAlignment(SwingConstants.CENTER);
		Klabel[1].setOpaque(true);

		label[9] = new JLabel("休憩時間");
		label[9].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[9].setHorizontalAlignment(SwingConstants.CENTER);
		label[9].setOpaque(true);

		text[5] = new JTextField("1");
		dtext[5] = Double.parseDouble(text[5].getText());
		text[5].setFont(new Font("ＭＳ ゴシック", 0, 30));
		text[5].setHorizontalAlignment(SwingConstants.CENTER);
		text[5].setOpaque(true);

		label[10] = new JLabel("時");
		label[10].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[10].setHorizontalAlignment(SwingConstants.CENTER);
		label[10].setOpaque(true);

		text[6] = new JTextField("0");
		dtext[6] = Double.parseDouble(text[6].getText());
		text[6].setFont(new Font("ＭＳ ゴシック", 0, 30));
		text[6].setHorizontalAlignment(SwingConstants.CENTER);
		text[6].setOpaque(true);

		label[11] = new JLabel("分");
		label[11].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[11].setHorizontalAlignment(SwingConstants.CENTER);
		label[11].setOpaque(true);

		label[12] = new JLabel("時給");
		label[12].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[12].setHorizontalAlignment(SwingConstants.CENTER);
		label[12].setOpaque(true);

		text[7] = new JTextField("871");
		dtext[7] = Double.parseDouble(text[7].getText());
		text[7].setFont(new Font("ＭＳ ゴシック", 0, 30));
		text[7].setHorizontalAlignment(SwingConstants.CENTER);
		text[7].setOpaque(true);

		label[13] = new JLabel("円");
		label[13].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[13].setHorizontalAlignment(SwingConstants.CENTER);
		label[13].setOpaque(true);

		Klabel[2] = new JLabel("");
		Klabel[2].setFont(new Font("ＭＳ ゴシック", 0, 30));
		Klabel[2].setHorizontalAlignment(SwingConstants.CENTER);
		Klabel[2].setOpaque(true);

		Kbutton[0] = new JButton("計算開始");
		Kbutton[0].setFont(new Font("ＭＳ ゴシック", 0, 35));
		Kbutton[0].setOpaque(true);
		Kbutton[0].setHorizontalAlignment(SwingConstants.CENTER);
		Kbutton[0].addActionListener(this);

		//結果表示用ラベル
		label[14] = new JLabel("結果表示");
		label[14].setFont(new Font("ＭＳ ゴシック", 0, 30));
		label[14].setHorizontalAlignment(SwingConstants.CENTER);
		label[14].setOpaque(true);

		// パネル設定

		p[0] = new JPanel();
		p[0].setLayout(new GridLayout(2, 1));
		this.add(p[0], BorderLayout.NORTH);

		p[1] = new JPanel();
		p[1].setLayout(new GridLayout(2, 1));
		this.add(p[1], BorderLayout.CENTER);

		//メニューボタン用パネル
		p[2] = new JPanel();
		p[2].setLayout(new GridLayout(1, 0));
		p[2].add(Mbutton[0]);
		Mbutton[0].addActionListener(this);
		p[0].add(p[2], BorderLayout.NORTH);

		//ラベル用パネル
		p[3] = new JPanel();
		p[3].setLayout(new GridLayout(1, 0));
		p[3].add(label[0]);
		p[0].add(p[3], BorderLayout.CENTER);

		p[4] = new JPanel();
		p[4].setLayout(new GridLayout(5, 5));

		//勤務時間行
		p[4].add(label[1]);
		p[4].add(text[0]);
		p[4].add(label[2]);
		p[4].add(text[1]);
		p[4].add(label[3]);

		//勤務時間外行
		p[4].add(label[4]);
		p[4].add(text[2]);
		p[4].add(label[5]);
		p[4].add(text[3]);
		p[4].add(label[6]);

		//勤務時間外倍率行
		p[4].add(label[7]);
		p[4].add(text[4]);
		p[4].add(label[8]);
		p[4].add(Klabel[0]);
		p[4].add(Klabel[1]);

		//休憩時間行
		p[4].add(label[9]);
		p[4].add(text[5]);
		p[4].add(label[10]);
		p[4].add(text[6]);
		p[4].add(label[11]);

		//時給行
		p[4].add(label[12]);
		p[4].add(text[7]);
		p[4].add(label[13]);
		p[4].add(Klabel[2]);
		Kbutton[0] = new JButton("計算開始");
		Kbutton[0].setFont(new Font("ＭＳ ゴシック", 0, 35));
		Kbutton[0].setOpaque(true);
		Kbutton[0].setHorizontalAlignment(SwingConstants.CENTER);
		Kbutton[0].addActionListener(this);
		p[4].add(Kbutton[0]);
		p[1].add(p[4], BorderLayout.NORTH);

		p[5] = new JPanel();
		p[5].setLayout(new GridLayout(0, 1));
		p[5].add(label[14]);
		p[1].add(p[5], BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		// メイン画面パネルの呼び出し
		if (object == Mbutton[0]) {
			MainPanel panel = new MainPanel(this.frame);
			frame.changeWindow(panel);
		}
		if (object == Kbutton[0]) {
			tm[0] = dtext[7];//時給
			tm[1] = tm[0] / 60;//分給
			ktime = (dtext[0] * 60) + dtext[1];//勤務時間
			nikyu[0] = ktime * tm[1];//勤務時間倍率無し
			kbai = dtext[4];//勤務時間外倍率
			tm[2] = (kbai * tm[0]) - tm[0];//勤務時間外倍率の金額
			nikyu[1] = nikyu[0] + tm[2];//日給(休憩時間無し)
			kyutime = (dtext[5] * 60) + dtext[6];//休憩時間
			nikyu[2] = nikyu[1] - (kyutime * tm[1]);
			n = (int)nikyu[2];

			if(n != 0) {
				label[14].setText("<html>日給は "+ n +" 円です<br>労働基準を満たしています</html>");
			}
			else if(ktime >= 8 && kyutime == 0) {
				label[14].setText("<html>日給は "+ n +" 円です<br>労働基準を違反しています</html>");
			}
		}
	}
}
