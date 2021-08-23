package me.jinmin.board.api.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardCreateRequest {
    private String title;
    private String writer;
    private String content;
}
