package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways;

import co.com.sofka.domain.generic.DomainEvent;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model.CommentViewModel;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model.PostViewModel;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.Comment;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.Post;
import reactor.core.publisher.Mono;

public interface DomainViewRepository {
    Mono<DomainEvent> createPost(PostViewModel post);
    Mono<DomainEvent> addComment(CommentViewModel comment);
}
