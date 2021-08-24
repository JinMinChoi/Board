package me.jinmin.board;

import me.jinmin.board.board.api.dto.BoardDto;
import me.jinmin.board.board.domain.Board;
import me.jinmin.board.board.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@EnableJpaAuditing
@SpringBootApplication
public class BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(BoardRepository boardRepository) throws Exception {
        return (args) -> IntStream.rangeClosed(1, 4).forEach(index -> boardRepository.save(init(index)));
    }

    private Board init(int index){
        BoardDto boardDto = BoardDto.builder()
                .title("게시글" + index)
                .writer("작성자" + index)
                .content("내용" + index)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .viewCnt(index)
                .build();

        Board board = new Board(boardDto);
        return board;
    }
}
