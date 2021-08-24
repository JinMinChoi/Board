package me.jinmin.board.api.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.jinmin.board.domain.Board;

@Getter
@Setter
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