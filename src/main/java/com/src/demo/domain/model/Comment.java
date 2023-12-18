package com.src.demo.domain.model;

import lombok.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Comment {
    private long id;
    private String body;
}
