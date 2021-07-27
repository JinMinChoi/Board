package me.jinmin.board.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Builder
    public BoardDto(Long id, String title, String writer, String content, int viewCnt, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.viewCnt = viewCnt;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
