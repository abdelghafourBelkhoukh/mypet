package com.myproject.mypet.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AuthenticationRequest {
    private String email;
    private String password;
}
