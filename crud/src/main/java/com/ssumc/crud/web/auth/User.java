package com.ssumc.crud.web.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssumc.crud.web.auth.ProviderType;
import com.ssumc.crud.web.auth.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @JsonIgnore

    private Long userSeq;

    @NotNull
    private String userId;

    @NotNull
    @Size(max = 100)
    private String username;

    @JsonIgnore
    @NotNull
    @Size(max = 128)
    private String password;

    @NotNull
    @Size(max = 512)
    private String email;

    @NotNull
    @Size(min = 1, max = 1)
    private String emailVerifiedYn;

    @NotNull
    @Size(max = 512)
    private String profileImageUrl;

    @NotNull
    private ProviderType providerType;

    @NotNull
    private RoleType roleType;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime modifiedAt;

    public User(
            @NotNull @Size(max = 64) String userId,
            @NotNull @Size(max = 100) String username,
            @NotNull @Size(max = 512) String email,
            @NotNull @Size(max = 1) String emailVerifiedYn,
            @NotNull @Size(max = 512) String profileImageUrl,
            @NotNull ProviderType providerType,
            @NotNull RoleType roleType,
            @NotNull LocalDateTime createdAt,
            @NotNull LocalDateTime modifiedAt
    ) {
        this.userId = userId;
        this.username = username;
        this.password = "NO_PASS";
        this.email = email != null ? email : "NO_EMAIL";
        this.emailVerifiedYn = emailVerifiedYn;
        this.profileImageUrl = profileImageUrl != null ? profileImageUrl : "";
        this.providerType = providerType;
        this.roleType = roleType;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

