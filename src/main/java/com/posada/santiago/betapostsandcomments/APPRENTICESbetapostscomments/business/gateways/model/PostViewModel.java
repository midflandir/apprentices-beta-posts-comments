package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model;

import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Author;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.PostId;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Title;

import java.util.ArrayList;
import java.util.List;

public class PostViewModel {

    protected String aggregateId;
    protected String author;
    protected String title;
    protected List<CommentViewModel> comments;

    public PostViewModel() {
        this.comments = new ArrayList<>();
    }

    public PostViewModel(String aggregateId, String title, String author, List<CommentViewModel> comments) {
        this.aggregateId = aggregateId;
        this.title = title;
        this.author = author;
        this.comments = comments;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(String aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<CommentViewModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentViewModel> comments) {
        this.comments = comments;
    }
}
