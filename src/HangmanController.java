import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		model.setDifficultyType(diffuculty);
		view.createGameScreen(model.getSecretWord());
		view.getGuess().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				guessWord = view.getAnswerField().getText();
				System.out.println(guessWord);
				if (model.getSecretWord().equals(guessWord)) {
					view.winPopUp();
					view.createEndGameScreen();
				} else {
					view.losePopUp();
					view.createEndGameScreen();
				}
			}
		});
	}

}
