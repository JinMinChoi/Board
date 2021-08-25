package me.jinmin.board.board.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jinmin.board.board.api.dto.BoardDto;
import me.jinmin.board.board.domain.Board;
import me.jinmin.board.board.service.BoardFindService;
import me.jinmin.board.user.domain.User;
import me.jinmin.board.user.service.UserFindService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
@Controller
public class BoardFindApi {

    private final BoardFindService boardFindService;
    private final UserFindService userFindService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Board> all = boardFindService.findAll();
        List<BoardDto> boardDtoList = toBoardDtoList(all);
        model.addAttribute("boardList", boardDtoList);
        return "board/list";
    }

    @GetMapping("/list/{userId}")
    public String findAllIWithUser(Model model, @PathVariable("userId") Long userId) {
        User user = userFindService.findById(userId);
        List<Board> all = boardFindService.findAll();
        List<BoardDto> boardDtoList = toBoardDtoList(all);
        model.addAttribute("boardList", boardDtoList);
        model.addAttribute("userEmail", user.getEmail());
        return "board/list";
    }

    private List<BoardDto> toBoardDtoList(List<Board> boardList) {
        return boardList.stream()
                .map(BoardDto::new)
                .collect(Collectors.toList());
    }
}
