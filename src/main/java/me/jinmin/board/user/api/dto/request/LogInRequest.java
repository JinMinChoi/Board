package me.jinmin.board.user.api.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class LogInRequest {

    @Email(message = "올바른 이메일 형식이 아닙니다.")
    @NotEmpty(message = "이메일은 필수입니다.")
    private String email;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password;
}
