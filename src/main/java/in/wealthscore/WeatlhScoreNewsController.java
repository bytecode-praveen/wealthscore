package in.wealthscore;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.wealthscore.bean.NewsFeed;
import in.wealthscore.service.NewsFeedService;

/**
 * 
 * @author Praveen Kumar
 *
 */
@RequestMapping("/v1/")
@RestController
public class WeatlhScoreNewsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatlhScoreNewsController.class);

	@Autowired
	private NewsFeedService newsFeed;

	@RequestMapping(value = "trendingnews", method = RequestMethod.GET)
	public List<NewsFeed> trendingnews(@RequestParam("page") int page, @RequestParam("size") int size) {
		return newsFeed.getNewsFeed(page, size);
	}

}
