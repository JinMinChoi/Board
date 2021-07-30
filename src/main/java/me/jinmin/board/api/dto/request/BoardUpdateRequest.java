package me.jinmin.board.api.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardUpdateRequest {
    private String title;
    private String writer;
    private String content;
}