package com.src.demo.domain.service;

import com.src.demo.domain.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByTicketId(long ticketId);

    void createTicketComment(long ticketId, String message);
}
