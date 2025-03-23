package one.expressdev.bakaneto_topics.repository;
import one.expressdev.bakaneto_topics.model.Topic    ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
