package com.src.demo.infra.zendesk.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ZendeskComment {
    private long id;
    private String body;
}
