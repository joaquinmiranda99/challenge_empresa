package com.src.demo.infra.zendesk.service;

import com.src.demo.domain.model.Comment;
import com.src.demo.domain.service.CommentService;
import com.src.demo.infra.zendesk.client.ZendeskClient;
import com.src.demo.infra.zendesk.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentZendeskService implements CommentService {

    private final String email;
    private final String token;
    private final String authorId;

    private final ZendeskClient client;

    public CommentZendeskService(
            @Value("${zendesk.api.email}") String email,
            @Value("${zendesk.api.token}") String token,
            @Value("${zendesk.author-id}") String authorId,
            ZendeskClient client) {
        this.email = email;
        this.token = token;
        this.authorId = authorId;
        this.client = client;
    }

    @Override
    public List<Comment> getCommentsByTicketId(long ticketId) {
        CommentsResponseDTO response = client.getCommentsByTicketId(ticketId, getAuth());
        return zendeskCommentToComment(response.getComments());
    }

    private static List<Comment> zendeskCommentToComment(List<ZendeskComment> zendeskComments) {
        return zendeskComments.stream().map(zendeskComment ->
                        Comment.builder()
                                .id(zendeskComment.getId())
                                .body(zendeskComment.getBody())
                                .build())
                .collect(Collectors.toList());
    }

    @Override
    public void createTicketComment(long ticketId, String message) {
        client.addTicketComment(ticketId,
                CreateCommentRequestDTO
                        .builder()
                        .ticket(TicketReduceDTO.builder()
                                .comment(new MessageDTO(message, authorId))
                                .build())
                        .build(), getAuth());
    }

    private String getAuth() {
        return "Basic " + Base64.getEncoder().encodeToString((email + ":" + token).getBytes());
    }
}
