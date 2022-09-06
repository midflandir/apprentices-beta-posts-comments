package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.CommentAdded;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.FontChanged;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.PostCreated;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Post extends AggregateEvent<PostId> {

    protected Title title;

    protected Author author;

    protected List<Comment> comments;

    public Post(PostId entityId, Title title, Author author) {
        super(entityId);
        subscribe(new PostChange(this));
        appendChange(new PostCreated(title.value(), author.value())).apply();
    }


    private Post(PostId id){
        super(id);
        subscribe(new PostChange(this));
    }

    public static Post from(PostId id, List<DomainEvent> events){
        Post post = new Post(id);
        events.forEach(event -> post.applyEvent(event));
        return post;
    }

    public void addAComment(CommentId id, Author author, Content content, Font font){
        Objects.requireNonNull(id);
        Objects.requireNonNull(author);
        Objects.requireNonNull(content);
        Objects.requireNonNull((font));
        appendChange(new CommentAdded(id.value(), author.value(), content.value(), font.value())).apply();
    }

    public Optional<Comment> getCommentById(CommentId id){
    Objects.requireNonNull(id);
        return comments.stream().filter((comment -> comment.identity().equals(id))).findFirst();
    }

    public void Changefont(CommentId id, Font font){
        Objects.requireNonNull(id);
        Objects.requireNonNull((font));
        appendChange(new FontChanged(id.value(), font.value())).apply();
    }

}
