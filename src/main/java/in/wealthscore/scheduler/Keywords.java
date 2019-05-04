/**
 * Praveen Kumar, 
 * 04-May-2019
 */
package in.wealthscore.scheduler;

/**
 * @author Praveen Kumar
 *
 */
public class Keywords {
	private String score;

	private String word;

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "Keywords [score=" + score + ", word=" + word + "]";
	}
}