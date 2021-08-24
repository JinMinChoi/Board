package me.jinmin.board.user.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.user.domain.User;
import me.jinmin.board.user.exception.UserNotFoundException;
import me.jinmin.board.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserFindService {

    private final UserRepository userRepository;

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User can't find by %d", userId)));
    }

    public User findByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException(String.format("User can't find by %s", userEmail)));
    }
}
