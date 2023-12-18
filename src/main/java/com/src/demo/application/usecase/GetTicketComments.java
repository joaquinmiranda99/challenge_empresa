package com.src.demo.application.usecase;

import com.src.demo.domain.model.Comment;
import com.src.demo.domain.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetTicketComments {
    private final CommentService commentService;

    public GetTicketComments(CommentService commentService) {
        this.commentService = commentService;
    }

    public List<Comment> execute(long ticketId) {
        return commentService.getCommentsByTicketId(ticketId);
    }
}
