package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model;

public class CommentViewModel {

    protected String id;
    protected String postId;
    protected String author;
    protected String content;
    protected String font;

    public CommentViewModel(String id, String postId, String author, String content) {
        this.id = id;
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public CommentViewModel(String id, String postId, String author, String content, String font) {
        this.id = id;
        this.postId = postId;
        this.author = author;
        this.content = content;
        this.font = font;
    }

    public CommentViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }
}
