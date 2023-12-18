package com.src.demo.application.usecase;

import com.src.demo.domain.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CreateCommentInTicket {

    private final CommentService commentService;

    public CreateCommentInTicket(CommentService commentService) {
        this.commentService = commentService;
    }

    public void execute(long ticketId, String comment) {
        commentService.createTicketComment(ticketId, comment);
    }
}
