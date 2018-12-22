
public class Main {
	public static void main(String[] args) {
		
		HangmanModel model = new HangmanModel();
		HangmanView view = new HangmanView();
		
		HangmanController controller = new HangmanController(model, view);
		
		
	}
}
