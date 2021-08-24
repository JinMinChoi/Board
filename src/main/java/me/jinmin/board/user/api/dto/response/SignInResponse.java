package me.jinmin.board.user.api.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignInResponse {

    private Long id;

    public SignInResponse(Long id) {
        this.id = id;
    }
}
