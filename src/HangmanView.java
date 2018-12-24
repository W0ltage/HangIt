import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class HangmanView {

	JFrame endGame;
	JFrame mainFrame;
	JFrame game;
	JPanel firstPanel;
	ButtonGroup buttonGroup;
	JButton startButton;
	JButton guess;
	JTextField answerField;
	JButton[] answerButtons = new JButton[26];
	JLabel remainingGuesses;
	JLabel guessedLetters;
	JLabel secretWordLabel;
	String secret;
	JButton quit;
	JButton restart;

	public HangmanView() {
		// TODO Auto-generated constructor stub
		createLoginScreen();
	}

	public void createLoginScreen() {
		mainFrame = new JFrame("HangIt Main Menu");
		mainFrame.setSize(1100, 240);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		firstPanel = new JPanel();
		firstPanel.setSize(1100, 240);
		firstPanel.setLayout(new GridLayout(4, 1));
		mainFrame.add(firstPanel);

		buttonGroup = new ButtonGroup();

		JRadioButton easy = new JRadioButton("Easy");
		JRadioButton medium = new JRadioButton("Medium");
		JRadioButton hard = new JRadioButton("Hard");

		startButton = new JButton("Start");
		startButton.setSize(50, 25);

		buttonGroup.add(easy);
		buttonGroup.add(medium);
		buttonGroup.add(hard);

		firstPanel.add(easy);
		firstPanel.add(medium);
		firstPanel.add(hard);

		firstPanel.add(startButton);

		mainFrame.setVisible(true);
	}

	public JButton getStartButton() {
		return startButton;
	}

	public ButtonGroup getButtonGroup() {
		// TODO Auto-generated method stub
		return buttonGroup;
	}

	public void createGameScreen(String secretWord) {
		// TODO Auto-generated method stub
		secret = secretWord;
		game = new JFrame("HangIt Game");
		game.setSize(1100, 240);
		game.setLocationRelativeTo(null);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setLayout(new GridLayout(3, 1));

		JPanel topPanel = new JPanel();
		remainingGuesses = new JLabel("# of remaining letter guesses: ");
		guessedLetters = new JLabel("# of letters already guessed: ");
		JLabel answerLabel = new JLabel();
		topPanel.setLayout(new GridLayout(3, 1));
		topPanel.add(remainingGuesses);
		topPanel.add(guessedLetters);
		topPanel.add(answerLabel);
		drawAnswer(answerLabel, secretWord);
		game.add(topPanel);

		JPanel answerPanel = new JPanel();
		answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.LINE_AXIS));
		answerField = new JTextField();
		guess = new JButton("Guess the letter");
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(2, 13));

		for (int i = 0; i < 26; i++) {
			char word = (char) ('a' + i);
			String sWord = word + "";
			JButton button = new JButton(sWord);
			answerButtons[i] = button;
			buttonsPanel.add(button);
		}

		JPanel competitorPanel = new JPanel(new BorderLayout());
		competitorPanel.add(BorderLayout.CENTER, answerField);
		competitorPanel.add(BorderLayout.EAST, guess);
		competitorPanel.add(BorderLayout.SOUTH, buttonsPanel);
		answerPanel.add(competitorPanel);

		game.add(answerPanel);

		game.setVisible(true);
	}

	public JButton getGuess() {
		return guess;
	}

	public JTextField getAnswerField() {
		return answerField;
	}

	public JButton[] getAnswerButtons() {
		return answerButtons;
	}

	public void drawAnswer(JLabel answerLabel, String secretword) {
		boolean lettersRevealed[] = new boolean[secretword.length()];
		StringBuilder word = new StringBuilder();
		for (int i = 0; i < secretword.length(); i++) {

			if (lettersRevealed[i]) {
				String s = secretword.charAt(i) + " ";
				word.append(s);
			} else {
				word.append("_ ");
			}
		}

		secretWordLabel = answerLabel;
		final String w = word.toString();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				secretWordLabel.setText(w);
			}
		});
	}

	public String getSelectedButtonText() {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}

	public void winPopUp() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(game, "YOU  WON THE GAME");
	}

	public void losePopUp() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(game, "YOU  LOSE THE GAME", "LOSE", JOptionPane.ERROR_MESSAGE);
	}

	public void createEndGameScreen() {
		endGame = new JFrame("HangIt END GAME");
		endGame.setSize(1100, 240);
		endGame.setLocationRelativeTo(null);
		endGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel gamePanel = new JPanel();
		endGame.add(gamePanel);

		restart = new JButton("Restart");
		restart.setSize(50, 30);
		restart.setLocation(50, 200);
		gamePanel.add(restart);

		quit = new JButton("Quit");
		quit.setSize(50, 30);
		quit.setLocation(50, 200);
		gamePanel.add(quit);

		endGame.setVisible(true);

	}

	public void updateNumberOfGuess(int guessAttempt) {
		// TODO Auto-generated method stub
		remainingGuesses.setText(guessAttempt + "# of remaining letter guesses:");
		guessedLetters.setText(6 - guessAttempt + " # of letters already guessed: ");
		remainingGuesses.paintImmediately(remainingGuesses.getVisibleRect());
		guessedLetters.paintImmediately(guessedLetters.getVisibleRect());

	}

	public void updateSecretWord(char letter) {
		String result = "";
		char[] secretWordArray = secret.toCharArray();
		char[] charArray = secretWordLabel.getText().toCharArray();
		for (int i = 0; i < secretWordArray.length; i++) {
			if (secretWordArray[i] == letter) {
				result = result + letter;
			} else {
				result = result + charArray[i];
			}
		}
		secretWordLabel.setText(result);
		secretWordLabel.paintImmediately(secretWordLabel.getVisibleRect());
	}

	public void disableButton(char c) {
		// TODO Auto-generated method stub
		for(int i = 0; i <answerButtons.length; i++) {
			if (answerButtons[i].getText().toCharArray()[0] == c) {
				answerButtons[i].setEnabled(false);
			}
		}
	}

}