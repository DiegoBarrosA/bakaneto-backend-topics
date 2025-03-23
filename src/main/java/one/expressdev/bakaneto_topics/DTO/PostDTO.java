package one.expressdev.bakaneto_topics.DTO;

import java.time.LocalDateTime;

public class PostDTO {

    private Long id;
    private Long authorId;
    private String body;
    private Long topicId;
    private LocalDateTime createdDate;

    public PostDTO() {}

    public PostDTO(Long id, Long authorId, String body, Long topicId, LocalDateTime createdDate) {
        this.id = id;
        this.authorId = authorId;
        this.body = body;
        this.topicId = topicId;
        this.createdDate = createdDate;
    }

    private PostDTO(Builder builder) {
        this.id = builder.id;
        this.authorId = builder.authorId;
        this.body = builder.body;
        this.topicId = builder.topicId;
        this.createdDate = builder.createdDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long authorId;
        private String body;
        private Long topicId;
        private LocalDateTime createdDate;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder authorId(Long authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder topicId(Long topicId) {
            this.topicId = topicId;
            return this;
        }

        public Builder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public PostDTO build() {
            return new PostDTO(this);
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
