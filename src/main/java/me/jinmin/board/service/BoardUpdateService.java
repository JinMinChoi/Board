package me.jinmin.board.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.api.dto.BoardDto;
import me.jinmin.board.domain.Board;
import me.jinmin.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardUpdateService {

    private final BoardFindService boardFindService;
    private final BoardRepository boardRepository;

    @Transactional
    public void update(Long id, BoardDto boardDto) {
        Board board = boardRepository.findById(id).orElseThrow(IllegalStateException::new);

        board.update(boardDto);
    }
}
