package one.expressdev.bakaneto_topics.service;

import one.expressdev.bakaneto_topics.DTO.PostDTO;
import one.expressdev.bakaneto_topics.model.Post;
import one.expressdev.bakaneto_topics.model.Topic;
import one.expressdev.bakaneto_topics.repository.PostRepository;
import one.expressdev.bakaneto_topics.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TopicRepository topicRepository;

    public List<PostDTO> getAllPostsAsDTOs() {
        return postRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PostDTO findPostByIdAsDTO(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.map(this::convertToDTO).orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }

    public PostDTO savePost(PostDTO postDTO) {
        Post post = convertToEntity(postDTO);
        Post savedPost = postRepository.save(post);
        return convertToDTO(savedPost);
    }

    public void deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Post with ID " + id + " does not exist.");
        }
    }

    private PostDTO convertToDTO(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .authorId(post.getAuthor_id())
                .body(post.getBody())
                .topicId(post.getTopic() != null ? post.getTopic().getId() : null)
                .createdDate(post.getCreatedDate())
                .build();
    }

    private Post convertToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setAuthor_id(postDTO.getAuthorId());
        post.setBody(postDTO.getBody());

        
        if (postDTO.getTopicId() != null) {
            Topic topic = topicRepository.findById(postDTO.getTopicId())
                    .orElseThrow(() -> new IllegalArgumentException("Topic with ID " + postDTO.getTopicId() + " does not exist."));
            post.setTopic(topic);
        } else {
            throw new IllegalArgumentException("Topic ID cannot be null.");
        }

        post.setCreatedDate(postDTO.getCreatedDate());
        return post;
    }
}
