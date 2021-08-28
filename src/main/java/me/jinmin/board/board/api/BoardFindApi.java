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
import org.springframework.web.bind.annotation.RequestParam;

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
    public String findAll(Model model,
                          @RequestParam(value = "page", defaultValue = "1") int pageNum) {
        List<Board> allWithPage = boardFindService.findAllWithPage(pageNum);
        List<BoardDto> boardDtoListWithPage = toBoardDtoList(allWithPage);
        List<Integer> pageList = boardFindService.getPageList(pageNum);

        model.addAttribute("boardList", boardDtoListWithPage);
        model.addAttribute("pageList", pageList);
        return "board/list";
    }

    @GetMapping("/list/{userId}")
    public String findAllIWithUser(Model model,
                                   @PathVariable("userId") Long userId,
                                   @RequestParam(value = "page", defaultValue = "1") int pageNum) {
        User user = userFindService.findById(userId);

        List<Board> allWithPage = boardFindService.findAllWithPage(pageNum);
        List<BoardDto> boardDtoListWithPage = toBoardDtoList(allWithPage);
        List<Integer> pageList = boardFindService.getPageList(pageNum);

        model.addAttribute("boardList", boardDtoListWithPage);
        model.addAttribute("pageList", pageList);
        model.addAttribute("userEmail", user.getEmail());
        model.addAttribute("userId", user.getId());
        return "board/list";
    }

    private List<BoardDto> toBoardDtoList(List<Board> boardList) {
        return boardList.stream()
                .map(BoardDto::new)
                .collect(Collectors.toList());
    }
}
