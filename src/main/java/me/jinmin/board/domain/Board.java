package me.jinmin.board.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "writer")
    private String writer;

    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "view_cnt")
    private int viewCnt;

    @Builder
    public Board(Long id, String title, String writer, String content, LocalDateTime createdDate, LocalDateTime updatedDate, int viewCnt) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.viewCnt = viewCnt;
    }

    public void changeBoard(String title, String writer, int viewCnt, LocalDateTime updateDate) {
        this.title = title;
        this.writer = writer;
        this.updatedDate = updateDate;
        this.viewCnt = viewCnt;
    }
}
