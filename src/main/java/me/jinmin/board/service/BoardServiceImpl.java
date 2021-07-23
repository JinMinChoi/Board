package me.jinmin.board.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.domain.Board;
import me.jinmin.board.exception.NotFoundBoardException;
import me.jinmin.board.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize());

        return boardRepository.findAll(pageable);
    }

    @Override
    public Board findById(Long id) {
        Optional<Board> findOne = boardRepository.findById(id);

        Board board = null;

        try {
            if (findOne.isPresent()) {
                board = findOne.get();
            }
        } catch (Exception e) {
            throw new NotFoundBoardException(e.toString());
        }

        return board;
    }
}
