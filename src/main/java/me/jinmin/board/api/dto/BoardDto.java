package me.jinmin.board.api.dto;

import lombok.*;
import me.jinmin.board.domain.Board;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {

    private Long id;
    private String title;
    private String writer;
    private String content;
    private int viewCnt;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @Builder
    public BoardDto(Long id, String title, String writer, String content,
                    int viewCnt, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.viewCnt = viewCnt;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

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
