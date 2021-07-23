package me.jinmin.board;

import me.jinmin.board.domain.Board;
import me.jinmin.board.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardApplicationTests {

    @Autowired
    BoardRepository boardRepository;

    @BeforeEach
    public void init() {

        Board b = Board.builder()
                .title("게시판 제목")
                .writer("진민")
                .build();

        boardRepository.save(b);
    }

    @Test
    void test() {
        Board findOne = boardRepository.findOneByWriter("진민");

        Assertions.assertThat(findOne.getWriter()).isEqualTo("진민");
    }

}
