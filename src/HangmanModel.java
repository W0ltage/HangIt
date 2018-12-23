
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

	public void setDifficultyType(String difficultyType) {
		this.difficultyType = difficultyType;
		secretWord = getSecretWordFromJSON();
		appearLetters = new boolean[secretWord.length()];
	}

	public String getSecretWordFromJSON() {
		return "poyraz";
	}
	
	public void guessWord(String guess) {
		
	}

}
