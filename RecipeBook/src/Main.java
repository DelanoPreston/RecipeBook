import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ContentBank.ContentLoader();
		JFrame frame = new JFrame();
		JPanel gamePanel = new JPanel();
		frame.setSize(550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(gamePanel);
		frame.setVisible(true);
	}
}