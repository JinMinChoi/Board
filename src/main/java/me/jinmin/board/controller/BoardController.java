package me.jinmin.board.controller;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.domain.Board;
import me.jinmin.board.domain.dto.BoardForm;
import me.jinmin.board.repository.BoardRepository;
import me.jinmin.board.service.BoardService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    //게시판 목록
    @GetMapping("/list")
    public String getList(Model model, @PageableDefault Pageable pageable) {
        model.addAttribute("boardList", boardService.findBoardList(pageable));

        return "/board/list";
    }

    //글 작성 get
    @GetMapping("/new")
    public String writeBoardForm(Model model) {
        model.addAttribute("boardForm", new BoardForm());
        return "board/form";
    }

    //글 작성 post
    @PostMapping("/new")
    public String writeBoard(@ModelAttribute("boardForm") BoardForm form) {
        Board board = Board.builder()
                .title(form.getTitle())
                .writer(form.getWriter())
                .content(form.getContent())
                .viewCnt(0)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        boardRepository.save(board);

        return "redirect:/board/list";
    }

    //글 읽기(단 건 조회) get


    //글 수정 put


    //글 삭제 delete
    @DeleteMapping("/{id}/delete")
    public String deleteBoard(@PathVariable("id") Long id) {
        boardRepository.deleteById(id);

        return "redirect:/board/list";
    }
}
