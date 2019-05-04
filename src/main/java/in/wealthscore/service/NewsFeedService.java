/**
 * Praveen Kumar, 
 * 04-May-2019
 */
package in.wealthscore.service;

import java.util.List;

import in.wealthscore.bean.NewsFeed;

/**
 * @author Praveen Kumar
 *
 */
public interface NewsFeedService {

	public List<NewsFeed> getNewsFeed(int page, int size);

}
