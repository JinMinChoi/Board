package me.jinmin.board.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.domain.Board;
import me.jinmin.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardDeleteService {

    private final BoardFindService boardFindService;
    private final BoardRepository boardRepository;

    @Transactional
    public Long delete(Long id) {
        Board board = boardFindService.findById(id);

        boardRepository.deleteById(board.getId());

        return board.getId();
    }
}
