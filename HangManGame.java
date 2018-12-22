import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Random;

public class HangManGame {

	public static void main() {
		JFrame game = new JFrame("HangIt Game");
		game.setSize(500, 400);
		game.setLocationRelativeTo(null);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setLayout(new GridLayout(5, 1));

		JLabel remainingGuesses = new JLabel("# of remaining letter guesses: ");
		JLabel guessedLetters = new JLabel("# of letters already guessed: ");
		JLabel answerLabel = new JLabel();
		drawAnswer(answerLabel);

		JTextField answerField = new JTextField();
		answerField.setSize(200, 100);
		JButton guess = new JButton("Guess the letter");

		JPanel answerPanel = new JPanel();
		answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.PAGE_AXIS));
		answerPanel.add(remainingGuesses);
		answerPanel.add(guessedLetters);
		answerPanel.add(answerLabel);
		game.add(answerPanel);

		JPanel competitorPanel = new JPanel(new BorderLayout());
		competitorPanel.add(BorderLayout.CENTER, answerField);
		competitorPanel.add(BorderLayout.EAST, guess);
		answerPanel.add(competitorPanel);

		game.setVisible(true);
	}

	static void drawAnswer(JLabel answerLabel) {
		Random r = new Random();
		boolean lettersRevealed[] = new boolean[10];
		String answer = "";
		for (int i = 0; i < r.nextInt(15); i++) { 
			answer += (char) r.nextInt();
		}
		StringBuilder word = new StringBuilder();
		for (int i = 0; i < r.nextInt(15); i++) { 

			if (lettersRevealed[i]) {
				String s = answer.charAt(i) + " ";
				word.append(s);
			} else {
				word.append("_ ");
			}
		}

		JLabel secretWordLabel = answerLabel; 
		final String w = word.toString();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				secretWordLabel.setText(w);
			}
		});
	}
}
