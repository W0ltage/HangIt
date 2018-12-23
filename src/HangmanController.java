import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;


public class HangmanController implements ActionListener {

	private HangmanModel model;
	private HangmanView view;
	private String diffuculty;
	private String guessWord;

	public HangmanController(HangmanModel model, HangmanView view) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.view = view;
		view.getStartButton().addActionListener(this);
	}

	public void startGame() {
		view.createLoginScreen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		diffuculty = view.getSelectedButtonText();
		if (diffuculty == null)
			return;
		System.out.println(diffuculty);
		try {
			model.setDifficultyType(diffuculty);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		view.createGameScreen(model.getSecretWord());
		for(int i = 0; i  < view.getAnswerButtons().length; i++) {
			view.getAnswerButtons()[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					boolean result = model.guessLetter((arg0.getActionCommand().toCharArray()[0]));
					if (result) {
						
					}else {
						//disable button
					}
				}
			});
		}
		view.getGuess().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				guessWord = view.getAnswerField().getText();
				System.out.println(guessWord);
				if (model.guessWord(guessWord)) {
					view.winPopUp();
					view.createEndGameScreen();
				} else if(model.getGuessAttempt() == 0) {
					view.updateNumberOfGuess(model.getGuessAttempt());
					view.losePopUp();
					view.createEndGameScreen();
				}
			}
		});
	}

}
