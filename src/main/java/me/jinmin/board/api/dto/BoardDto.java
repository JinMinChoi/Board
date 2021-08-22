package me.jinmin.board.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.jinmin.board.domain.Board;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardDto {

    private Long id;
    private String title;
    private String writer;
    private String content;
    private int viewCnt;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public BoardDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.content = board.getContent();
        this.viewCnt = board.getViewCnt();
        this.createdDate = board.getCreatedDate();
        this.updatedDate = board.getUpdatedDate();
    }
}
