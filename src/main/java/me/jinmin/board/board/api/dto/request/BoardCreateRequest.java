package me.jinmin.board.board.api.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardCreateRequest {
    private String title;
    private String writer;
    private String content;
}
