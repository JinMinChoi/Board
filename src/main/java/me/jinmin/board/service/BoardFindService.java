package me.jinmin.board.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.domain.Board;
import me.jinmin.board.exception.NotFoundBoardException;
import me.jinmin.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardFindService {

    private final BoardRepository boardRepository;

    public Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow(
                () -> new NotFoundBoardException("This board is not exist")
        );
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }
}
