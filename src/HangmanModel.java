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

	public boolean isCorrectLetter( char ch) {
		for (int i = 0; i < secretWord.length(); i++) {
			if (ch == secretWord.charAt(i)) {
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
		System.out.println(secretWord);
	}

	public String getSecretWordFromFile() throws FileNotFoundException {
		// get text from text file
		int count = 0;
		String[] words = new String[100];
		Random random = new Random();
		int rnd = random.nextInt(99) + 1;
		Scanner scanner;
		if (difficultyType.equals("Easy")) { 
			scanner = new Scanner(new FileReader("/home/poyraz/eclipse-workspace/HangIt/src/easy.txt"));
		}else if (difficultyType.equals("Medium")) {
			scanner = new Scanner(new FileReader("/home/poyraz/eclipse-workspace/HangIt/src/medium.txt"));
		}else {
			scanner = new Scanner(new FileReader("/home/poyraz/eclipse-workspace/HangIt/src/hard.txt"));
		}
		while (scanner.hasNext()) {
			words[count++] = scanner.nextLine();
		}
		scanner.close();
		return words[rnd];
	}

	public boolean guessWord(String guess) {
		if (guess.equals(secretWord)) {
			return true;
		}
		guessAttempt--;
		return false;
		
	}
	
	public int getGuessAttempt() {
		return guessAttempt;
	}

	public boolean guessLetter(char letter) {
		// TODO Auto-generated method stub
		boolean result = isCorrectLetter(letter);
		int index = returnIndexOfLetter(letter);
		if (!result) {
			guessAttempt--;
		}else {
			appearLetters[index] = true;
		}
		return result;
	}

}
