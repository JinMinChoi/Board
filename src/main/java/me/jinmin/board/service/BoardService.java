package me.jinmin.board.service;

import me.jinmin.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BoardService {
    Page<Board> findBoardList(Pageable pageable);

    Optional<Board> findById(Long id);
}
