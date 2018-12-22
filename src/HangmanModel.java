
public class HangmanModel {
	private String secretWord;
	
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
	
}
