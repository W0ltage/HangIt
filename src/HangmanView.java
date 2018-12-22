import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class HangmanView {
	
	JFrame mainFrame;
	JPanel firstPanel;
	ButtonGroup buttonGroup;
	JButton startButton;
	
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

	public void createGameScreen() {
		// TODO Auto-generated method stub
		JFrame game = new JFrame("HangIt Game");
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
		drawAnswer(answerLabel);
		game.add(topPanel);
		
		JPanel answerPanel = new JPanel();
		answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.LINE_AXIS));
		JTextField answerField = new JTextField();
		JButton guess = new JButton("Guess the letter");

		JPanel competitorPanel = new JPanel(new BorderLayout());
		competitorPanel.add(BorderLayout.CENTER, answerField);
		competitorPanel.add(BorderLayout.EAST, guess);
		answerPanel.add(competitorPanel);
		
		game.add(answerPanel);
		
		JPanel buttonsPanel = new JPanel();
		char ch = (char) 65;
		for(int i = 0; i < 26; i++) {
			buttonsPanel.add(new JButton(ch+ ""));
			ch++;
		}
		game.add(buttonsPanel);

		game.setVisible(true);
	}
	
	public void drawAnswer(JLabel answerLabel) {
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
	
	public String getSelectedButtonText() {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
}
