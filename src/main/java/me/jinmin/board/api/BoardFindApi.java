package me.jinmin.board.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jinmin.board.api.dto.BoardDto;
import me.jinmin.board.domain.Board;
import me.jinmin.board.service.BoardFindService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardFindApi {

    private final BoardFindService boardFindService;

    @GetMapping("/list")
    public String findAll(Model model){
        List<Board> all = boardFindService.findAll();
        List<BoardDto> boardDtoList = toBoardDtoList(all);

        model.addAttribute("boardList", boardDtoList);

        return "board/list";
    }

    private List<BoardDto> toBoardDtoList(List<Board> boardList) {
        return boardList.stream()
                .map(BoardDto::new)
                .collect(Collectors.toList());
    }
}
