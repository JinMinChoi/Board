package me.jinmin.board.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.api.dto.BoardDto;
import me.jinmin.board.domain.Board;
import me.jinmin.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardFindService {

    private final BoardRepository boardRepository;

    public BoardDto findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(IllegalStateException::new);

        BoardDto boardDto = new BoardDto(
                board.getId(),
                board.getTitle(),
                board.getWriter(),
                board.getContent(),
                board.getViewCnt(),
                board.getCreatedDate(),
                board.getUpdatedDate());

        return boardDto;
    }

    public List<BoardDto> findAll() {
        List<Board> boardEntityList = boardRepository.findAll();

        List<BoardDto> collect = boardEntityList.stream()
                .map(b -> new BoardDto(b.getId(), b.getTitle(), b.getWriter(), b.getContent(), b.getViewCnt(),
                        b.getCreatedDate(), b.getUpdatedDate()))
                .collect(Collectors.toList());

        return collect;
    }
}
