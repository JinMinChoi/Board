package me.jinmin.board.user.api.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequest {

    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @NotNull(message = "비밀번호를 입력해주세요(숫자, 문자, 특수문자를 포함한 최소 8자리)")
    @Pattern(regexp = "\"^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$\"")
    private String password;

    @NotNull(message = "이름을 입력해주세요")
    private String name;
}
