package com.src.demo.application.usecase;

import com.src.demo.domain.service.CommentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CreateCommentInTicketTest {

    private final CreateCommentInTicket usecase;

    private final CommentService commentService = Mockito.mock(CommentService.class);

    public CreateCommentInTicketTest() {
        this.usecase = new CreateCommentInTicket(commentService);
    }

    @Test
    public void deberia_llamar_al_service() {
        long ticketId = 1;

        usecase.execute(ticketId, "Hola");

        Mockito.verify(commentService).createTicketComment(Mockito.anyLong(), Mockito.anyString());
    }
}
