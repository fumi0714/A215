
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private JPanel currentPanel;
	private ImageIcon icon;

	public MainFrame() {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1280, 1024);
		this.setTitle("従業員管理ツール");
		currentPanel = null;
		icon = new ImageIcon("img/m.jpg");
		setIconImage(icon.getImage());

	}

	// 画面遷移するメソッド
	public void changeWindow(JPanel changeTo) {

		// 現在表示中の画面をフレームから取り除く
		if (currentPanel != null) {

			this.remove(currentPanel);
		}

		// 表示するパネルを保存しておく
		currentPanel = changeTo;

		// 新しい画面を表示
		this.add(changeTo);
		this.setVisible(true);
	}
}
