package me.jinmin.board.board.api;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.board.service.BoardDeleteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardDeleteApi {

    private final BoardDeleteService boardDeleteService;

    @DeleteMapping("/delete/{boardId}")
    public String deleteBoard(@PathVariable("boardId") Long boardId) {
        boardDeleteService.delete(boardId);
        return "redirect:/board/list";
    }
}
