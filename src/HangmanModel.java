import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

	@SuppressWarnings("deprecation")
	public String getSecretWordFromJSON() {
		try {
			Random random = new Random();
			int randomNumber = random.nextInt(99) + 1;
			System.out.println("girdi");
			JSONParser parser = new JSONParser();
			Object object = parser.parse(new FileReader("JSON.json"));
			JSONObject jsonObject = (JSONObject) object;
			JSONArray easy = (JSONArray) jsonObject.get("easy");
			JSONArray medium = (JSONArray) jsonObject.get("medium");
			JSONArray hard = (JSONArray) jsonObject.get("hard");
			Iterator<String> iterator;
			System.out.println(difficultyType);
			if (difficultyType.equals("Easy")) {
				System.out.println("EZgirdi");
				iterator = easy.iterator();
			} else if (difficultyType.equals("Medium")) {
				iterator = medium.iterator();
				System.out.println("Medgirdi");
			} else {
				iterator = hard.iterator();
				System.out.println("Hardgirdi");

			}

			while (iterator.hasNext()) {
				System.out.println(iterator.next());
				randomNumber--;
				if (randomNumber == 0) {
					return iterator.next();
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "error";
	}

	public void guessWord(String guess) {

	}

}
