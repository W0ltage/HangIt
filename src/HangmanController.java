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
		for (int i = 0; i < view.getAnswerButtons().length; i++) {
			view.getAnswerButtons()[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

					boolean result = model.guessLetter((arg0.getActionCommand().toCharArray()[0]));
					view.updateNumberOfGuess(model.getGuessAttempt());
					if (model.getGuessAttempt() == 0) {
						view.updateNumberOfGuess(model.getGuessAttempt());
						view.losePopUp();
						view.createEndGameScreen();
						view.quit.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								view.game.dispose();
								view.mainFrame.dispose();
								view.endGame.dispose();
							}
						});
					}
					if (result) {
						view.updateSecretWord(arg0.getActionCommand().toCharArray()[0]);
					} else {
						view.disableButton(arg0.getActionCommand().toCharArray()[0]);
						// disable button
					}
					if (model.isWordFound()) {
						view.winPopUp();
						view.createEndGameScreen();
						view.quit.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								view.game.dispose();
								view.mainFrame.dispose();
								view.endGame.dispose();
							}
						});
					}
				}

			});
		}
		view.getGuess().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(guessWord);
				if (model.guessWord(guessWord)) {
					view.winPopUp();
					view.createEndGameScreen();
					view.quit.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							view.game.dispose();
							view.mainFrame.dispose();
							view.endGame.dispose();
						}
					});
				} else if (model.getGuessAttempt() == 0) {
					view.updateNumberOfGuess(model.getGuessAttempt());
					view.losePopUp();
					view.createEndGameScreen();
					view.quit.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							view.game.dispose();
							view.mainFrame.dispose();
							view.endGame.dispose();
						}
					});
				}
			}
		});
	}

}