package one.expressdev.bakaneto_topics.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class TopicDTO {

    private Long id;
    private Long authorId;
    private List<Long> postIds; 
    private LocalDateTime createdDate;


    public TopicDTO() {}

    public TopicDTO(Long id, Long authorId, List<Long> postIds, LocalDateTime createdDate) {
        this.id = id;
        this.authorId = authorId;
        this.postIds = postIds;
        this.createdDate = createdDate;
    }

    private TopicDTO(Builder builder) {
        this.id = builder.id;
        this.authorId = builder.authorId;
        this.postIds = builder.postIds;
        this.createdDate = builder.createdDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long authorId;
        private List<Long> postIds;
        private LocalDateTime createdDate;

 
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder authorId(Long authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder postIds(List<Long> postIds) {
            this.postIds = postIds;
            return this;
        }

        public Builder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public TopicDTO build() {
            return new TopicDTO(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public List<Long> getPostIds() {
        return postIds;
    }

    public void setPostIds(List<Long> postIds) {
        this.postIds = postIds;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
