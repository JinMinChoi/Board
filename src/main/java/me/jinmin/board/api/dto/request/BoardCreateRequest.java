package me.jinmin.board.api.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardCreateRequest {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private int viewCnt;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
