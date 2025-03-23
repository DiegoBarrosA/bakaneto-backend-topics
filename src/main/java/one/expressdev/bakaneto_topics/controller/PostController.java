package one.expressdev.bakaneto_topics.controller;

import one.expressdev.bakaneto_topics.DTO.PostDTO;
import one.expressdev.bakaneto_topics.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPostsAsDTOs();
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable("id") Long id) {
        return postService.findPostByIdAsDTO(id);
    }

    @PostMapping
    public PostDTO createPost(@RequestBody PostDTO postDTO) {
        return postService.savePost(postDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }
}
