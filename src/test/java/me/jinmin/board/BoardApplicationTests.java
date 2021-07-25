package me.jinmin.board;

import me.jinmin.board.domain.Board;
import me.jinmin.board.repository.BoardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class BoardApplicationTests {

    @Autowired
    MockMvc mockMvc;

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
        List<Board> findJinMin = boardRepository.findByWriter("진민");

    }

}
