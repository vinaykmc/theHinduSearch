package sample.web.ui;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="sampleApp", url= "https://www.thehindu.com/")
public interface FeignClients {
	
	@RequestMapping(method = RequestMethod.GET, value = "/profile/author/{authorName}")
	ResponseEntity<String> getAuthorData(@PathVariable("authorName") String authorName);
	
	@RequestMapping(method = RequestMethod.GET, value = "/search/?q={searchTitle}&order=DESC&sort=publishdate")
	ResponseEntity<String> getTitleData(@PathVariable("title") String title);
}
