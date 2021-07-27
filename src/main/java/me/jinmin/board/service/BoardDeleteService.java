package me.jinmin.board.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardDeleteService {

    private final BoardRepository boardRepository;

    @Transactional
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
