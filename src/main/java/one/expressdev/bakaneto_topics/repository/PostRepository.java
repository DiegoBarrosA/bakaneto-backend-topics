package one.expressdev.bakaneto_topics.repository;

import one.expressdev.bakaneto_topics.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post, Long>{

}
