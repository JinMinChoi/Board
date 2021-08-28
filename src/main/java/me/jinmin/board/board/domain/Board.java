package me.jinmin.board.board.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.jinmin.board.board.api.dto.BoardDto;
import me.jinmin.board.user.domain.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "board")
    List<User> userList = new ArrayList<>();

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

    //초기값을 위한 생성자 후에 지워도 될듯?
    @Builder
    public Board(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.writer = boardDto.getWriter();
        this.content = boardDto.getContent();
        this.viewCnt = boardDto.getViewCnt();
        this.createdDate = boardDto.getCreatedDate();
        this.updatedDate = boardDto.getUpdatedDate();
    }

    public void update(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.updatedDate = LocalDateTime.now();
    }

    public void addViewCnt() {
        this.viewCnt += 1;
    }
}
