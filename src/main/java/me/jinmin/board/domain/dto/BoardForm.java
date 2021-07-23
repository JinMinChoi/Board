package me.jinmin.board.domain.dto;

import lombok.Data;

@Data
public class BoardForm {

    private String title;
    private String content;
    private String writer;

    public BoardForm() {
    }

    public BoardForm(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
