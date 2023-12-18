package com.src.demo.infra.zendesk.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private String body;
    private String author_id;
}
