package me.jinmin.board.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.jinmin.board.api.dto.BoardCreateRequest;
import me.jinmin.board.api.dto.BoardDto;
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

    @Column(name = "content")
    private String content;

    @Column(name = "view_cnt")
    private int viewCnt;


    @Builder
    public Board(Long id, String title, String writer, String content, int viewCnt) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.viewCnt = viewCnt;
    }

    public Board(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.writer = boardDto.getWriter();
        this.content = boardDto.getContent();
        this.viewCnt = boardDto.getViewCnt();
        this.createdDate = boardDto.getCreatedDate();
        this.updatedDate = boardDto.getUpdatedDate();
    }

    public Board(BoardCreateRequest boardUpdateRequest) {
        this.title = boardUpdateRequest.getTitle();
        this.writer = boardUpdateRequest.getWriter();
        this.content = boardUpdateRequest.getContent();
    }

    public void update(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.writer = boardDto.getWriter();
        this.content = boardDto.getContent();
        this.viewCnt = boardDto.getViewCnt();
        this.updatedDate = boardDto.getUpdatedDate();
    }
}
