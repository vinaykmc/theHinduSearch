package sample.hindu.search.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sample.hindu.search.FeignClients;

@Controller
public class SearchController {
	
	@Autowired
	FeignClients feignClients;

	@RequestMapping("/author/{authorName}")
	public String getAuthor(Map<String, Object> model, @PathVariable String authorName) {
		ResponseEntity<String> response = feignClients.getAuthorData(authorName);
		model.put("message", response.getBody());
		return "welcome";
	}
	
	@RequestMapping("/search/{title}")
	public String getTitleDate(Map<String, Object> model, @PathVariable String title) {
		ResponseEntity<String> response = feignClients.getTitleData(title);
		model.put("message", response.getBody());
		return "welcome";
	}

}
