package com.src.demo.infra.zendesk.service.objectmother;

import com.src.demo.infra.zendesk.model.CommentsResponseDTO;
import com.src.demo.infra.zendesk.model.ZendeskComment;

import java.util.Collections;

public class CommentObjectMother {
    public static CommentsResponseDTO getGenericCommentResponseDTOWithId(long id) {
        return CommentsResponseDTO.builder()
                .comments(Collections.singletonList(ZendeskComment.builder().id(id).body("Hola").build()))
                .build();
    }
}
