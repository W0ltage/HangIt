
public class HangmanController {
	
	private HangmanModel model;
	private HangmanView view;
	
	public HangmanController(HangmanModel model ,HangmanView view) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.view = view;
	}
	
	public void startGame() {
		view.createLoginScreen();
	}
}
