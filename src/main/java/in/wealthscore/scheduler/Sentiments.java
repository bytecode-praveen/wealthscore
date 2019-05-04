/**
 * Praveen Kumar, 
 * 04-May-2019
 */
package in.wealthscore.scheduler;

import java.util.Arrays;

/**
 * @author Praveen Kumar
 *
 */

public class Sentiments {
	private String result_msg;

	private String score;

	private Keywords[] keywords;

	private String author;

	private String result_code;

	private String type;

	private String version;

	private String email;

	private String ratio;

	public String getResult_msg() {
		return result_msg;
	}

	public void setResult_msg(String result_msg) {
		this.result_msg = result_msg;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Keywords[] getKeywords() {
		return keywords;
	}

	public void setKeywords(Keywords[] keywords) {
		this.keywords = keywords;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRatio() {
		return ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "Sentiments [result_msg=" + result_msg + ", score=" + score + ", keywords=" + Arrays.toString(keywords) + ", author=" + author + ", result_code=" + result_code + ", type=" + type + ", version=" + version + ", email=" + email + ", ratio=" + ratio + "]";
	}
}
