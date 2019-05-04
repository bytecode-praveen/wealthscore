/**
 * Praveen Kumar, 
 * 04-May-2019
 */
package in.wealthscore.repository;

/**
 * @author Praveen Kumar
 *
 */
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsFeedRepository extends MongoRepository<NewsFeedModel, String> {

	public Page<NewsFeedModel> findAll(Pageable page);

	public void save(List<NewsFeedModel> newsFeeds);

	public NewsFeedModel findBySourceId(String id);

}
