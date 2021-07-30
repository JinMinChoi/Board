package me.jinmin.board.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.jinmin.board.entity.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "writer")
    private String writer;

    @Column(name = "content")
    private String content;

    @Column(name = "view_cnt")
    private int viewCnt;


    @Builder
    public Board(Long id, String title, String writer, String content, int viewCnt,
                 LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.viewCnt = viewCnt;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public void update(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.viewCnt += 1;
        this.updatedDate = LocalDateTime.now();
    }
}
