/**
 * Praveen Kumar, 
 * 04-May-2019
 */
package in.wealthscore.scheduler;

import java.util.Arrays;

/**
 * 
 * @author Praveen Kumar
 *
 */
public class HackerNewsStory {
	private String score;

	private String by;

	private String id;

	private String time;

	private String title;

	private String type;

	private String descendants;

	private String url;

	private String[] kids;

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescendants() {
		return descendants;
	}

	public void setDescendants(String descendants) {
		this.descendants = descendants;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String[] getKids() {
		return kids;
	}

	public void setKids(String[] kids) {
		this.kids = kids;
	}

	@Override
	public String toString() {
		return "HackerNewsStory [score=" + score + ", by=" + by + ", id=" + id + ", time=" + time + ", title=" + title + ", type=" + type + ", descendants=" + descendants + ", url=" + url + ", kids=" + Arrays.toString(kids) + "]";
	}
}
