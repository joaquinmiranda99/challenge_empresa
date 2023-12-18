package com.src.demo.infra.zendesk.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentsResponseDTO {
    private List<ZendeskComment> comments;
}
