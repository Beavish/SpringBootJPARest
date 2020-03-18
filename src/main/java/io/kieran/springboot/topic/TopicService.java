package io.kieran.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	// private list of data
	private List <Topic> topics = new ArrayList <>(Arrays.asList(
			new Topic("Spring","SpringFramework", "Spring Framework Description"),
			new Topic("Java","Javaaa", "Java Framework Description"),
			new Topic("Node","Node JS", "Node Description")			
			));
	
	// method to publish list, eg to controller
	public List <Topic> getAllTopics(){
		List<Topic>topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	public Optional<Topic> getTopic(String id) {
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		Optional<Topic> t = topicRepository.findById(id);
		return t;
	}
	public void add(Topic topic) {
		topicRepository.save(topic);
		 
	}
	public void update(Topic topic, String id) {
		topicRepository.save(topic);
		}
		
	
	public void delete(String id) {
		topicRepository.deleteById(id);
		
	}
	
}
