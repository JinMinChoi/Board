package me.jinmin.board.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.api.dto.BoardDto;
import me.jinmin.board.domain.Board;
import me.jinmin.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardSaveService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long saveFromDto(BoardDto boardDto) {
        Board board = new Board(boardDto);

        boardRepository.save(board);

        return board.getId();
    }
}
