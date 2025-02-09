package com.Lalitdk.LinkUp.user_service.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Lalitdk.LinkUp.user_service.Dto.LoginRequestDto;
import com.Lalitdk.LinkUp.user_service.Dto.SignUpRequestDto;
import com.Lalitdk.LinkUp.user_service.Dto.UserDto;
import com.Lalitdk.LinkUp.user_service.Service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    

    private final AuthService authService;

    @PostMapping("/Signup")
    public ResponseEntity<UserDto>Signup(@RequestBody SignUpRequestDto signUpRequestDto){
        UserDto userDto = authService.signUp(signUpRequestDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto){
        String token = authService.login(loginRequestDto);
        return ResponseEntity.ok(token);
    }
}
