
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

public class MainPanel extends JPanel implements ActionListener {

	private MainFrame frame;
	private MariaDbConnector m;
	private JButton button[] = new JButton[5];
	private JLabel label01;
	private JPanel p[] = new JPanel[3];

	public MainPanel(MainFrame frame) {

		this.frame = frame;
		this.m = MainScreen.m;

		setLayout(new BorderLayout());

		button[0] = new JButton();
		button[0].setText("<html>従業員管理<br/>データベース</html>");
		button[0].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
		button[0].addActionListener(this);

		button[1] = new JButton();
		button[1].setText("<html>給与明細管理</html>");
		button[1].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
		button[1].addActionListener(this);

		button[2] = new JButton();
		button[2].setText("<html>シフト管理</html>");
		button[2].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
		button[2].addActionListener(this);

		label01 = new JLabel("従業員管理ツール画面");

		label01.setFont(new Font("ＭＳ ゴシック", 0, 100));
		label01.setHorizontalAlignment(SwingConstants.CENTER);
		label01.setForeground(Color.GREEN);
		label01.setBackground(Color.BLACK);
		label01.setOpaque(true);

		p[0] = new JPanel();
		p[0].setLayout(new GridLayout(1, 0));

		p[1] = new JPanel();
		p[1].setLayout(new GridLayout(1, 3));

		p[0].add(label01);
		p[1].add(button[0]);
		p[1].add(button[1]);
		p[1].add(button[2]);

		this.add(p[0], BorderLayout.NORTH);
		this.add(p[1], BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		// 従業員管理データベースパネルの呼び出し
		if (object == button[0]) {
			DbPanel panel = new DbPanel(this.frame);
			frame.changeWindow(panel);
		}
		// 給与明細パネルの呼び出し
		if (object == button[1]) {
			KmPanel panel = new KmPanel(this.frame);
			frame.changeWindow(panel);
		}
		// シフト管理パネルの呼び出し
		if (object == button[2]) {
			SfPanel panel = new SfPanel(this.frame);
			frame.changeWindow(panel);
		}
	}
}
