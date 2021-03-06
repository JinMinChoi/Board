package me.jinmin.board.board.api;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.board.service.BoardDeleteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardDeleteApi {

    private final BoardDeleteService boardDeleteService;

    @DeleteMapping("/delete/{boardId}")
    public String deleteBoard(@PathVariable("boardId") Long boardId,
                              @ModelAttribute("uesrId") Long userId) {
        boardDeleteService.delete(boardId);
        return "redirect:/api/v1/board/list/" + userId;
    }
}
