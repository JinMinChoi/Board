package me.jinmin.board.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.jinmin.board.entity.BaseTimeEntity;

import javax.persistence.*;

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

    @Column(name = "view_cnt")
    private int viewCnt;

    @Builder
    public Board(Long id, String title, String writer, int viewCnt) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.viewCnt = viewCnt;
    }

    public void changeBoard(String title, String writer, int viewCnt) {
        this.title = title;
        this.writer = writer;
        this.viewCnt = viewCnt;
    }
}
