import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class HangmanModel {
	private String secretWord;
	private int wordLength;
	private String difficultyType;
	private int guessAttempt = 6;
	private boolean[] appearLetters;

	public boolean isCorrectLetter(String name, char ch) {
		for (int i = 0; i < name.length(); i++) {
			if (ch == name.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	public int returnIndexOfLetter(char ch) {
		for (int i = 0; i < secretWord.length(); i++) {
			if (ch == secretWord.charAt(i)) {
				return i;
			}
		}
		return -1;
	}

	public String getSecretWord() {
		return secretWord;
	}

	public int getWordLength() {
		return wordLength;
	}

	public String getDifficultyType() {
		return difficultyType;
	}

	public void setDifficultyType(String difficultyType) throws FileNotFoundException {
		this.difficultyType = difficultyType;
		secretWord = getSecretWordFromFile();
		appearLetters = new boolean[secretWord.length()];
	}

	public String getSecretWordFromFile() throws FileNotFoundException {
		// get text from text file
		Random random = new Random();
		int rnd = random.nextInt(99) + 1;
		Scanner scanner;
		if (difficultyType.equals("Easy")) { 
			scanner = new Scanner(new FileReader("/home/poyraz/eclipse-workspace/HangIt/src/easy.txt"));
		}else if (difficultyType.equals("Medium")) {
			scanner = new Scanner(new FileReader("medium.txt"));
		}else {
			scanner = new Scanner(new FileReader("hard.txt"));
		}
		while (scanner.hasNext()) {
			rnd--;
			if (rnd == 0) {
				return scanner.nextLine();
			}
		}
		
		return "error";
	}

	public void guessWord(String guess) {

	}

}
