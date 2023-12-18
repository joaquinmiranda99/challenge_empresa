package com.src.demo.infra.zendesk.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketReduceDTO {
    private MessageDTO comment;
}
