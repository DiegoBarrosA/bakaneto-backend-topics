package one.expressdev.bakaneto_topics.controller;

import one.expressdev.bakaneto_topics.DTO.TopicDTO;
import one.expressdev.bakaneto_topics.service.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public List<TopicDTO> getAllTopics() {
        return topicService.getAllTopics();
    }

    @PostMapping
    public TopicDTO createTopic(@RequestBody TopicDTO topic) {
        return topicService.saveTopic(topic);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable("id") Long id) {
        topicService.deleteTopic(id);
    }
}
