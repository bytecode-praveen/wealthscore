package in.wealthscore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Praveen Kumar
 *
 */
@RequestMapping("/v1/")
@RestController
public class WeatlhScoreNewsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatlhScoreNewsController.class);

	@RequestMapping(value = "trendingnews", method = RequestMethod.GET)
	public String trendingnews(@RequestParam("page") int page, @RequestParam("size") int size) {
		return "Request page " + page + ", and size :" + size;
	}

}
