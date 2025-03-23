package one.expressdev.bakaneto_topics.service;

import one.expressdev.bakaneto_topics.model.Post;

import one.expressdev.bakaneto_topics.model.Topic;
import one.expressdev.bakaneto_topics.repository.TopicRepository;
import one.expressdev.bakaneto_topics.DTO.TopicDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Optional<Topic> findById(Long id) {
        return topicRepository.findById(id);
    }

    public TopicDTO saveTopic(TopicDTO topicDTO) {
        Topic topic = convertToEntity(topicDTO);
        Topic savedTopic = topicRepository.save(topic);
        return convertToDTO(savedTopic);
    }

    public List<TopicDTO> getAllTopics() {
        return topicRepository
            .findAll()
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public void deleteTopic(Long id) {
        if (topicRepository.existsById(id)) {
            topicRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Topic with ID " + id + " does not exist.");
        }
    }

    private Topic convertToEntity(TopicDTO topicDTO) {
        return Topic.builder()
            .id(topicDTO.getId())
            .author_id(topicDTO.getAuthorId())
            .posts(null) 
            .createdDate(topicDTO.getCreatedDate())
            .build();
    }

    private TopicDTO convertToDTO(Topic topic) {
        return TopicDTO.builder()
            .id(topic.getId())
            .authorId(topic.getAuthorId())
            .postIds(topic.getPosts() != null ? topic.getPosts().stream().map(Post::getId).collect(Collectors.toList()) : null)
            .createdDate(topic.getCreatedDate())
            .build();
    }
}


