package me.jinmin.board.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.api.dto.request.BoardCreateRequest;
import me.jinmin.board.domain.Board;
import me.jinmin.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardSaveService {

    private final BoardRepository boardRepository;

    @Transactional
    public void save(BoardCreateRequest boardCreateRequest) {

        Board board = Board.builder()
                .title(boardCreateRequest.getTitle())
                .writer(boardCreateRequest.getWriter())
                .content(boardCreateRequest.getContent())
                .viewCnt(boardCreateRequest.getViewCnt())
                .createdDate(boardCreateRequest.getCreatedDate())
                .updatedDate(boardCreateRequest.getUpdatedDate())
                .build();

        boardRepository.save(board);

        //return board.getId();
    }
}
