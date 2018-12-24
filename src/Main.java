
public class Main {
	public static void main(String[] args) {

		HangmanModel model = new HangmanModel();
		HangmanView view = new HangmanView();
		System.out.println("e");
		HangmanController controller = new HangmanController(model, view);

	}
}
