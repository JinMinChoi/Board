package me.jinmin.board.api.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.jinmin.board.domain.Board;

@Data
@NoArgsConstructor
public class BoardUpdateRequest {
    private Long id;
    private String title;
    private String writer;
    private String content;

    public BoardUpdateRequest(Long id, Board board) {
        this.id = id;
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.content = board.getContent();
    }
}