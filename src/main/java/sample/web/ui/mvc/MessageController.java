/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.web.ui.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sample.web.ui.FeignClients;

@Controller
public class MessageController {
	
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
		model.put("message", response.getBody().toString());8
		return "welcome";
	}


}
