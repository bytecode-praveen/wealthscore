/**
 * Praveen Kumar, 
 * 04-May-2019
 */
package in.wealthscore.repository;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Praveen Kumar
 *
 */
@Document("NewsFeed")
public class NewsFeedModel {

	private String score;

	private String by;

	private String sourceId;

	private String sourceName;

	private String time;

	private String title;

	private String type;

	private String url;

	private String sentiments;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSentiments() {
		return sentiments;
	}

	public void setSentiments(String sentiments) {
		this.sentiments = sentiments;
	}

	@Override
	public String toString() {
		return "NewsFeedModel [score=" + score + ", by=" + by + ", sourceId=" + sourceId + ", sourceName=" + sourceName + ", time=" + time + ", title=" + title + ", type=" + type + ", url=" + url + ", sentiments=" + sentiments + "]";
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

}
