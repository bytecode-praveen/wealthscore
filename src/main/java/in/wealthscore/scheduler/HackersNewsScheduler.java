/**
 * Praveen Kumar, 
 * 04-May-2019
 */
package in.wealthscore.scheduler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.wealthscore.repository.NewsFeedModel;
import in.wealthscore.repository.NewsFeedRepository;

/**
 * 
 * @author Praveen Kumar
 *
 */
@Component
public class HackersNewsScheduler {

	private static final Logger LOGGER = LoggerFactory.getLogger(HackersNewsScheduler.class);

	@Value("${topstoriesurl}")
	private String topStoriesUrl;

	@Value("${storydetailurl}")
	private String storyDetailUrl;

	@Value("${sentimentsurl}")
	private String sentimentsAPIUrl;

	@Value("${rapidkey}")
	private String rapidKey;

	@Value("${sourcename}")
	private String sourceName;

	@Autowired
	private NewsFeedRepository newsFeedRepo;

	@Scheduled(initialDelay = 100, fixedDelay = 60 * 60 * 1000)
	public void fetchTopStories() throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<Integer> storyIds = restTemplate.getForObject(topStoriesUrl, List.class);
		LOGGER.debug("Found topstories : " + storyIds.size());
		if (storyIds != null && storyIds.size() > 0) {
			storyIds.forEach(storyId -> {
				// for (int i = 0; i < 1; i++) {
				// Integer storyId = storyIds.get(i);
				if (newsFeedRepo.findBySourceId("" + storyId) == null) {
					LOGGER.debug("Not present in DB fetching Feed");
					fetchStory(storyId);

				} else {
					LOGGER.debug("Already Present ignoring...");
				}
			});
			// }
		}

	}

	/**
	 * @param storyId
	 * @return: void
	 */
	private void fetchStory(Integer storyId) {
		RestTemplate restTemplate = new RestTemplate();
		LOGGER.debug(String.format(storyDetailUrl, storyId));
		HackerNewsStory storyDetail = restTemplate.getForObject(String.format(storyDetailUrl, storyId), HackerNewsStory.class);
		if (storyDetail != null) {
			String senti = calculateSentiments(storyDetail.getTitle());
			NewsFeedModel nf = getNewsFeed(storyDetail, senti);
			newsFeedRepo.save(nf);
		}
	}

	/**
	 * @param storyDetail
	 * @param senti
	 * @return
	 * @return: NewsFeed
	 */
	private NewsFeedModel getNewsFeed(HackerNewsStory storyDetail, String senti) {
		NewsFeedModel nf = new NewsFeedModel();
		nf.setBy(storyDetail.getBy());
		nf.setSourceId(storyDetail.getId());
		nf.setSourceName(sourceName);
		nf.setScore(storyDetail.getScore());
		nf.setTime(storyDetail.getTime());
		nf.setTitle(storyDetail.getTitle());
		nf.setType(storyDetail.getType());
		nf.setUrl(storyDetail.getUrl());

		nf.setSentiments(senti);

		return nf;

	}

	/**
	 * @param title
	 * @return: void
	 */
	private String calculateSentiments(String title) {
		try {
			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			// headers.setAccept(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED));
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			headers.set("X-RapidAPI-Host", "twinword-sentiment-analysis.p.rapidapi.com");
			headers.set("X-RapidAPI-Key", rapidKey);

			HttpEntity<String> entity = new HttpEntity<String>("text=" + title, headers);

			ResponseEntity<Sentiments> respEntity = restTemplate.exchange(sentimentsAPIUrl, HttpMethod.POST, entity, Sentiments.class);

			Sentiments sentiments = respEntity.getBody();
			if (sentiments != null) {
				return sentiments.getResult_msg();
			}
		} catch (Exception e) {
			LOGGER.error("Error while fetching sentiments", e);
		}
		return null;
	}

}
