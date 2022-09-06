package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain;

import co.com.sofka.domain.generic.EventChange;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.CommentAdded;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.FontChanged;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.PostCreated;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Content;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.CommentId;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Author;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Font;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Title;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.PostCreated;

import java.util.ArrayList;

public class PostChange extends EventChange {

    public PostChange(Post post){
        apply((PostCreated event)-> {
            post.title = new Title(event.getTitle());
            post.author = new Author(event.getAuthor());
            post.comments = new ArrayList<>();
        });

        apply((CommentAdded event)-> {
            Comment comment =
                    new Comment(CommentId.of(event.getId()),
                            new Author(event.getAuthor()),
                            new Content(event.getContent()),
                            new Font(event.getFont()));
            post.comments.add(comment);
        });

        apply((FontChanged event) -> {
                var comment = post.getCommentById(CommentId.of(event.getCommentId())).orElseThrow(() ->
                        new IllegalArgumentException("Wrong id to reach the Entity"));
            comment.ChangeFont(new Font(event.getFont()));
        });
    }
}
