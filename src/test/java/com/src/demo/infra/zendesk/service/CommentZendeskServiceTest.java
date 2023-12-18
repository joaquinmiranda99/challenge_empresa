package com.src.demo.infra.zendesk.service;

import com.src.demo.domain.model.Comment;
import com.src.demo.infra.zendesk.client.ZendeskClient;
import com.src.demo.infra.zendesk.service.objectmother.CommentObjectMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class CommentZendeskServiceTest {
    
    private final CommentZendeskService service;
    private final ZendeskClient client = Mockito.mock(ZendeskClient.class);

    public CommentZendeskServiceTest() {
        this.service = new CommentZendeskService("test@mail.com", "token", "123", client);
    }

    @Test
    public void deberia_devolver_correctamente_un_comentario() {
        long ticketId = 1;

        Mockito.when(client.getCommentsByTicketId(Mockito.anyLong(), Mockito.anyString()))
                .thenReturn(CommentObjectMother.getGenericCommentResponseDTOWithId(123));

        List<Comment> comments = service.getCommentsByTicketId(ticketId);

        Assertions.assertEquals(123, comments.get(0).getId());
    }

    @Test
    public void deberia_crearse_correctamente_un_comentario() {
        long ticketId = 1;
        String message = "Hola";

        service.createTicketComment(ticketId, message);

        Mockito.verify(client).addTicketComment(Mockito.eq(ticketId), Mockito.any(), Mockito.any());
    }


}
