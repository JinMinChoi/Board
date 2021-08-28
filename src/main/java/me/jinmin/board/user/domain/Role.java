package me.jinmin.board.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER", "사용자"),
    BLACKLIST("ROLE_BLACKLIST", "블랙리스트"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String value;
}
