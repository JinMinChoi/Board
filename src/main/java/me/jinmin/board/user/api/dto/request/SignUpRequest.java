package me.jinmin.board.user.api.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequest {

    @Email(message = "올바른 이메일 형식이 아닙니다.")
    @NotEmpty(message = "이메일은 필수입니다.")
    private String email;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$",
            message = "(숫자, 문자, 특수문자를 포함한 최소 8자리)")
    private String password;

    @NotEmpty(message = "이름은 필수입니다.")
    private String name;
}
