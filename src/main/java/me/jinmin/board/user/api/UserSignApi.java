package me.jinmin.board.user.api;

import lombok.RequiredArgsConstructor;
import me.jinmin.board.user.api.dto.request.LogInRequest;
import me.jinmin.board.user.api.dto.request.SignUpRequest;
import me.jinmin.board.user.service.UserSignService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserSignApi {

    private final UserSignService userSignService;

    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("signUpRequest", new SignUpRequest());
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signUp(@Valid @ModelAttribute("signUpRequest") SignUpRequest signUpRequest,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/signup";
        }
        userSignService.signup(signUpRequest);
        return "redirect:/api/v1/board/list";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginRequest", new LogInRequest());
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginRequest") LogInRequest logInRequest,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/login";
        }
        Long userId = userSignService.login(logInRequest);
        return "redirect:/api/v1/board/list";
    }
}
