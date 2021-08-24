package me.jinmin.board.user.service;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.user.api.dto.request.SignInRequest;
import me.jinmin.board.user.api.dto.request.SignUpRequest;
import me.jinmin.board.user.api.dto.response.SignInResponse;
import me.jinmin.board.user.domain.User;
import me.jinmin.board.user.exception.EmailDuplicateException;
import me.jinmin.board.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserSignService {

    private final UserRepository userRepository;
    private final UserFindService userFindService;

    public void signup(SignUpRequest signUpRequest) {
        User user = User.builder()
                .email(signUpRequest.getEmail())
                .password(signUpRequest.getPassword())
                .name(signUpRequest.getName())
                .build();
        userRepository.save(user);
    }

    public SignInResponse login(SignInRequest signInRequest) {
        User user = userFindService.findByEmail(signInRequest.getEmail());
        checkExistEmail(user.getEmail());
        return new SignInResponse(user.getId());
    }

    private void checkExistEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new EmailDuplicateException(String.format("%s is already exist", email));
        }
    }
}
