package me.jinmin.board.board.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.board.api.dto.request.BoardUpdateRequest;
import me.jinmin.board.board.domain.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardUpdateService {

    private final BoardFindService boardFindService;

    @Transactional
    public void update(Long id, BoardUpdateRequest boardUpdateRequest) {
        Board board = boardFindService.findById(id);
        board.update(
                boardUpdateRequest.getTitle(),
                boardUpdateRequest.getWriter(),
                boardUpdateRequest.getContent()
        );
        board.addViewCnt();
    }
}
