package me.jinmin.board.board.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jinmin.board.board.api.dto.request.BoardCreateRequest;
import me.jinmin.board.board.service.BoardSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
@Controller
public class BoardCreateApi {

    private final BoardSaveService boardSaveService;

    @GetMapping("/write/{userId}")
    public String writeBoardForm(Model model, @PathVariable("userId") Long userId) {
        model.addAttribute("createRequest", new BoardCreateRequest());
        model.addAttribute("userId", userId);
        return "board/write";
    }

    @PostMapping("/write/{userId}")
    public String writeBoard(@PathVariable("userId") Long userId,
                             @ModelAttribute("createRequest") BoardCreateRequest boardCreateRequest) {
        boardSaveService.save(userId, boardCreateRequest);
        return "redirect:/api/v1/board/list/" + userId;
    }
}
