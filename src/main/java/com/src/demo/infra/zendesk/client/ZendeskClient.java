package com.src.demo.infra.zendesk.client;

import com.src.demo.infra.zendesk.model.CommentsResponseDTO;
import com.src.demo.infra.zendesk.model.CreateCommentRequestDTO;
import com.src.demo.infra.zendesk.model.TicketReduceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "zendesk", url = "${zendesk.api.url}")
public interface ZendeskClient {

    @RequestMapping(method = RequestMethod.GET, value = "tickets/{ticketId}/comments")
    CommentsResponseDTO getCommentsByTicketId(
            @PathVariable("ticketId") long ticketId,
            @RequestHeader("Authorization") String authorization
    );

    @RequestMapping(method = RequestMethod.PUT, value = "tickets/{ticketId}.json")
    void addTicketComment(
            @PathVariable("ticketId") long ticketId,
            @RequestBody CreateCommentRequestDTO body,
            @RequestHeader("Authorization") String authorization
    );
}
