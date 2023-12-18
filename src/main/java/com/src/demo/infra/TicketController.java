package com.src.demo.infra;

import com.src.demo.application.usecase.CreateCommentInTicket;
import com.src.demo.application.usecase.GetTicketComments;
import com.src.demo.domain.model.Comment;
import com.src.demo.infra.request.CreateMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/ticket")
public class TicketController {
    private final GetTicketComments getTicketCommentsUsecase;
    private final CreateCommentInTicket createCommentInTicketUsecase;

    public TicketController(GetTicketComments getTicketCommentsUsecase, CreateCommentInTicket createCommentInTicketUsecase) {
        this.getTicketCommentsUsecase = getTicketCommentsUsecase;
        this.createCommentInTicketUsecase = createCommentInTicketUsecase;
    }

    @GetMapping("/{ticketId}/comments")
    public ResponseEntity<List<Comment>> getTicketComments(@PathVariable Long ticketId) {
        List<Comment> comments = getTicketCommentsUsecase.execute(ticketId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/{ticketId}/comments")
    public ResponseEntity<Void> addCommentToTicket(
            @PathVariable Long ticketId,
            @RequestBody CreateMessageDTO request) {
        createCommentInTicketUsecase.execute(ticketId, request.getMessage());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}