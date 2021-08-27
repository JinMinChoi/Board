package me.jinmin.board.board.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.board.domain.Board;
import me.jinmin.board.exception.BoardNotFoundException;
import me.jinmin.board.board.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardFindService {

    private static final int PAGE_COUNT_PER_BLOCK = 10;
    private static final int BOARD_COUNT_PER_PAGE = 5;

    private final BoardRepository boardRepository;

    public Board findById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException("This board is not exist"));
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public List<Board> findAllWithPage(int pageNum) {
        Pageable pageRequest = PageRequest.of(pageNum - 1, BOARD_COUNT_PER_PAGE, Sort.by(Sort.Direction.ASC, "createdDate"));
        Page<Board> allWithPage = boardRepository.findAll(pageRequest);

        List<Board> content = allWithPage.getContent();

        return content;
    }

    public List<Integer> getPageList(int curPageNum) {
        List<Integer> pageList = new ArrayList<>(PAGE_COUNT_PER_BLOCK);

        Double boardTotalCnt = Double.valueOf(getBoardCnt());
        int lastPageNum = (int) (Math.ceil(boardTotalCnt / BOARD_COUNT_PER_PAGE));
        int blockLastPageNum = Math.min(lastPageNum, curPageNum + PAGE_COUNT_PER_BLOCK);
        curPageNum = (curPageNum <= 5) ? 1 : curPageNum - 5;

        for (int p = curPageNum; p <= blockLastPageNum; p++) {
            pageList.add(p);
        }

        return pageList;
    }

    private Long getBoardCnt() {
        return boardRepository.count();
    }
}
