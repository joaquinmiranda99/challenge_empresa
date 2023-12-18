package com.src.demo.application.usecase;

import com.src.demo.domain.model.Comment;
import com.src.demo.domain.service.CommentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class GetTicketCommentsTest {
    private final GetTicketComments usecase;

    private final CommentService commentService = Mockito.mock(CommentService.class);

    public GetTicketCommentsTest() {
        this.usecase = new GetTicketComments(commentService);
    }

    @Test
    public void deberia_llamar_al_service() {
        long ticketId = 1;

        usecase.execute(ticketId);

        Mockito.verify(commentService).getCommentsByTicketId(Mockito.eq(ticketId));
    }
}
