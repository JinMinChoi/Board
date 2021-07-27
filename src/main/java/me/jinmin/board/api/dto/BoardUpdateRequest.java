package me.jinmin.board.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardUpdateRequest {
    private String title;
    private String writer;
    private String content;
    private int viewCnt;
    private LocalDateTime updatedDate;

}
