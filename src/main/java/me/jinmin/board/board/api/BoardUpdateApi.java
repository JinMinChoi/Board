package me.jinmin.board.board.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jinmin.board.board.api.dto.request.BoardUpdateRequest;
import me.jinmin.board.board.domain.Board;
import me.jinmin.board.board.service.BoardFindService;
import me.jinmin.board.board.service.BoardUpdateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardUpdateApi {

    private final BoardFindService boardFindService;
    private final BoardUpdateService boardUpdateService;

    @GetMapping("{boardId}")
    public String updateBoardGet(@PathVariable("boardId") Long boardId, Model model) {
        Board board = boardFindService.findById(boardId);
        model.addAttribute("updateRequest", new BoardUpdateRequest(board.getId(), board));
        return "board/detail";
    }

    @PutMapping("{boardId}")
    public String updateBoard(@PathVariable("boardId") Long boardId,
                              @ModelAttribute("updateRequest") BoardUpdateRequest boardUpdateRequest) {
        boardUpdateService.update(boardId, boardUpdateRequest);
        return "redirect:/board/list";
    }
}
