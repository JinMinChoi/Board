package me.jinmin.board.board.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.board.domain.Board;
import me.jinmin.board.exception.BoardNotFoundException;
import me.jinmin.board.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardFindService {

    private final BoardRepository boardRepository;

    public Board findById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException("This board is not exist"));
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }
}
