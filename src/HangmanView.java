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

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

public class HangmanView {
	JFrame endGame;
	JFrame mainFrame;
	JFrame game;
	JPanel firstPanel;
	ButtonGroup buttonGroup;
	JButton startButton;
	JButton guess;
	JTextField answerField;
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
		game = new JFrame("HangIt Game");
		game.setSize(1100, 240);
		game.setLocationRelativeTo(null);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setLayout(new GridLayout(3, 1));

		JPanel topPanel = new JPanel();
		JLabel remainingGuesses = new JLabel("# of remaining letter guesses: ");
		JLabel guessedLetters = new JLabel("# of letters already guessed: ");
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
        JButton b1 = new JButton("A");
        JButton b2 = new JButton("B");
        JButton b3 = new JButton("C");
        JButton b4 = new JButton("D");
        JButton b5 = new JButton("E");
        JButton b6 = new JButton("F");
        JButton b7 = new JButton("G");
        JButton b8 = new JButton("H");
        JButton b9 = new JButton("I");
        JButton b10 = new JButton("J");
        JButton b11 = new JButton("K");
        JButton b12 = new JButton("L");
        JButton b13 = new JButton("M");
        JButton b14 = new JButton("N");
        JButton b15 = new JButton("O");
        JButton b16 = new JButton("P");
        JButton b17 = new JButton("Q");
        JButton b18 = new JButton("R");
        JButton b19 = new JButton("S");
        JButton b20 = new JButton("T");
        JButton b21 = new JButton("U");
        JButton b22 = new JButton("V");
        JButton b23 = new JButton("W");
        JButton b24 = new JButton("X");
        JButton b25 = new JButton("Y");
        JButton b26 = new JButton("Z");
        buttonsPanel.add(b1);
        buttonsPanel.add(b2);
        buttonsPanel.add(b3);
        buttonsPanel.add(b4);
        buttonsPanel.add(b5);
        buttonsPanel.add(b6);
        buttonsPanel.add(b7);
        buttonsPanel.add(b8);
        buttonsPanel.add(b9);
        buttonsPanel.add(b10);
        buttonsPanel.add(b11);
        buttonsPanel.add(b12);
        buttonsPanel.add(b13);
        buttonsPanel.add(b14);
        buttonsPanel.add(b15);
        buttonsPanel.add(b16);
        buttonsPanel.add(b17);
        buttonsPanel.add(b18);
        buttonsPanel.add(b19);
        buttonsPanel.add(b20);
        buttonsPanel.add(b21);
        buttonsPanel.add(b22);
        buttonsPanel.add(b23);
        buttonsPanel.add(b24);
        buttonsPanel.add(b25);
        buttonsPanel.add(b26);


		JPanel competitorPanel = new JPanel(new BorderLayout());
		competitorPanel.add(BorderLayout.CENTER, answerField);
		competitorPanel.add(BorderLayout.EAST, guess);
		competitorPanel.add(BorderLayout.SOUTH,buttonsPanel);
		answerPanel.add(competitorPanel);
		
		

		game.add(answerPanel);

		/*JPanel buttonsPanel = new JPanel();
		char ch = (char) 65;
		for (int i = 0; i < 26; i++) {
			buttonsPanel.add(new JButton(ch + ""));
			ch++;
		}
		game.add(buttonsPanel);
*/
		game.setVisible(true);
	}

	public JButton getGuess() {
		return guess;
	}

	public JTextField getAnswerField() {
		return answerField;
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

		JLabel secretWordLabel = answerLabel;
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
		JOptionPane.showMessageDialog(game, "YOU  LOSE THE GAME","LOSE",JOptionPane.ERROR_MESSAGE);
	}
	public void createEndGameScreen(){
		endGame = new JFrame("HangIt END GAME");
		endGame.setSize(1100, 240);
		endGame.setLocationRelativeTo(null);
		endGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel gamePanel = new JPanel();
		endGame.add(gamePanel);
		
		JButton restart = new JButton("Restart");
		restart.setSize(50, 30);
		restart.setLocation(50, 200);
		gamePanel.add(restart);
		
		JButton quit = new JButton("Quit");
		quit.setSize(50, 30);
		quit.setLocation(50, 200);
		gamePanel.add(quit);
		
		endGame.setVisible(true);

		
		
	}
	
}
