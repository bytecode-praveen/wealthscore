/**
 * Praveen Kumar, 
 * 04-May-2019
 */
package in.wealthscore.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.wealthscore.bean.NewsFeed;
import in.wealthscore.repository.NewsFeedModel;
import in.wealthscore.repository.NewsFeedRepository;

/**
 * @author Praveen Kumar
 *
 */
@Service
public class NewsFeedServiceImpl implements NewsFeedService {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewsFeedServiceImpl.class);

	@Autowired
	NewsFeedRepository nfRepo;

	public List<NewsFeed> getNewsFeed(int page, int size) {

		LOGGER.debug("Fetching news feed page :{}. size :{}", page, size);
		List<NewsFeed> newsFeed = new ArrayList<NewsFeed>();

		Pageable pageable = new PageRequest(page, size);

		Page<NewsFeedModel> nfList = nfRepo.findAll(pageable);

		if (nfList != null) {
			nfList.getContent().forEach(nfModel -> {

				newsFeed.add(convert(nfModel));
			});
		}

		return newsFeed;
	}

	/**
	 * @param nfModel
	 * @return
	 * @return: NewsFeed
	*/
	private NewsFeed convert(NewsFeedModel nfModel) {
		NewsFeed nf = new NewsFeed();
		nf.setBy(nfModel.getBy());
		nf.setId(nfModel.getSourceId());
		nf.setScore(nfModel.getScore());
		nf.setSentiments(nfModel.getSentiments());
		nf.setTime(nfModel.getTime());
		nf.setTitle(nfModel.getTitle());
		nf.setType(nfModel.getType());
		nf.setUrl(nfModel.getUrl());

		return nf;

	}

}
