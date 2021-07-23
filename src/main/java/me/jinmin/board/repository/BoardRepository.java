package me.jinmin.board.repository;

import me.jinmin.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findOneByWriter(String writer);
}
