import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class View {
	
	public void createLoginScreen() {
		JFrame frame1 = new JFrame("HangIt Main Menu");
		frame1.setSize(1100, 240);
		frame1.setResizable(false);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel1 = new JPanel();
		panel1.setSize(1100, 240);
		panel1.setLayout(new GridLayout(4, 1));
		frame1.add(panel1);

		ButtonGroup b1 = new ButtonGroup();

		JRadioButton easy = new JRadioButton("Easy");
		JRadioButton medium = new JRadioButton("Medium");
		JRadioButton hard = new JRadioButton("Hard");

		JButton start = new JButton("Start");
		start.setSize(50, 25);

		b1.add(easy);
		b1.add(medium);
		b1.add(hard);

		panel1.add(easy);
		panel1.add(medium);
		panel1.add(hard);

		panel1.add(start);
	}
}
