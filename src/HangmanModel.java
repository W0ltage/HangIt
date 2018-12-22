
public class HangmanModel {
	private String secretWord;
	private int wordLength;
	private String difficultyType;
	
	public boolean isCorrectLetter(String name,char ch) {
		for (int i=0;i<name.length();i++) {
			if(ch==name.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	public String getSecretWord() {
		return secretWord;
	}

	public void setSecretWord(String secretWord) {
		this.secretWord = secretWord;
	}

	public int getWordLength() {
		return wordLength;
	}

	public String getDifficultyType() {
		return difficultyType;
	}

	public void setDifficultyType(String difficultyType) {
		this.difficultyType = difficultyType;
	}


	
}
