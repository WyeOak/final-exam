package com.example.exam.DTO;
import com.example.exam.model.User;
import lombok.*;


@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDTO {
    private int id;

    private String name;

    private String email;

    private String login;

    private String password;

    public static UserDTO from(User user){
        return builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }
}
