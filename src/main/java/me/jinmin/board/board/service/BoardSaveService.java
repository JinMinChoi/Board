package me.jinmin.board.board.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.board.api.dto.request.BoardCreateRequest;
import me.jinmin.board.board.domain.Board;
import me.jinmin.board.board.repository.BoardRepository;
import me.jinmin.board.user.domain.User;
import me.jinmin.board.user.repository.UserRepository;
import me.jinmin.board.user.service.UserFindService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardSaveService {

    private final BoardRepository boardRepository;
    private final UserFindService userFindService;

    @Transactional
    public void save(Long userId, BoardCreateRequest boardCreateRequest) {
        User user = userFindService.findById(userId);
        Board board = Board.builder()
                .title(boardCreateRequest.getTitle())
                .writer(boardCreateRequest.getWriter())
                .content(boardCreateRequest.getContent())
                .viewCnt(0)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        boardRepository.save(board);
        user.writeBoard(board);
    }
}
