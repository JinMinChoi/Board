package me.jinmin.board.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jinmin.board.api.dto.request.BoardCreateRequest;
import me.jinmin.board.service.BoardSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardCreateApi {

    private final BoardSaveService boardSaveService;

    @GetMapping("/write")
    public String writeBoardForm(Model model) {
        model.addAttribute("boardDto", new BoardCreateRequest());

        return "board/write";
    }

    @PostMapping("/write")
    public String writeBoard(@ModelAttribute("boardDto") BoardCreateRequest boardCreateRequest) {
        boardSaveService.save(boardCreateRequest);

        return "redirect:/board/list";
    }
}
