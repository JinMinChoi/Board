package me.jinmin.board.controller;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.domain.Board;
import me.jinmin.board.repository.BoardRepository;
import me.jinmin.board.service.BoardService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //글 작성 post
    @PostMapping("/new")
    public String writeContents(@RequestBody Board board) {
        boardRepository.save(board);

        return "redirect:/";
    }

    //글 읽기(단 건 조회) get
    @GetMapping("/")
    public String getOne(@RequestParam(value = "id", defaultValue = "0") Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));

        return "/board/form";
    }

    //글 수정 put
    @PutMapping("/{id}")
    public String updateBoard(@PathVariable("id") Long id, @RequestBody Board board) {
        Board findOne = boardService.findById(id);

        findOne.changeBoard(board.getTitle(), board.getWriter(), board.getViewCnt());

        return "/board/list";
    }

    //글 삭제 delete
    @DeleteMapping("/{id}")
    public String deleteBoard(@PathVariable("id") Long id) {
        boardRepository.deleteById(id);

        return "redirect:";
    }
}
