package me.jinmin.board.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardForm {

    private String title;
    private String content;
    private String writer;

}
