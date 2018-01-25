public class MainScreen {
	public static MariaDbConnector m;

	public static void main(String args[]) {
		// JFrame作成
		MainFrame frame = new MainFrame();
		m = new MariaDbConnector();
		// メイン画面を設定
		frame.changeWindow(new LoginPanel(frame));
	}
}
