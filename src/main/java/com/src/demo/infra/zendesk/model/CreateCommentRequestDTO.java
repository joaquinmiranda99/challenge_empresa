package com.src.demo.infra.zendesk.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequestDTO {
    private TicketReduceDTO ticket;
}
