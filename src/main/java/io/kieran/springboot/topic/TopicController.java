package io.kieran.springboot.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	// Dependency Injection for Topic Service.
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")//only for a GET, other method need to be defined as POST,DELETE etc
	
	// GET comes in, we execute this method
	public List<Topic> getAllTopics() {
		
		//Spring automatically converts to JSON, no need for marshaling
		// this method fetches topics from topic service.
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics") 
	public void addTopic(@RequestBody Topic topic) {
		topicService.add(topic);
		
	
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}") 
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.update(topic,id);
		
		
		
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}") 
	public void deleteTopic(@PathVariable String id) {
		topicService.delete(id);
		
		
	}

}
