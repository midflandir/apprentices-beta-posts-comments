package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

public class FontChanged extends DomainEvent {

    private String commentId;
    private String font;

    public FontChanged(String commentId, String font) {
        super("posada.santiago.FontChanged");
        this.commentId = commentId;
        this.font = font;
    }

    public String getCommentId() {
        return commentId;
    }

    public String getFont() {
        return font;
    }
}
