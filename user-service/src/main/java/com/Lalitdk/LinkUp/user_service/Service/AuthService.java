package com.Lalitdk.LinkUp.user_service.Service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.Lalitdk.LinkUp.user_service.Dto.LoginRequestDto;
import com.Lalitdk.LinkUp.user_service.Dto.SignUpRequestDto;
import com.Lalitdk.LinkUp.user_service.Dto.UserDto;
import com.Lalitdk.LinkUp.user_service.Entity.User;
import com.Lalitdk.LinkUp.user_service.Exception.BadRequestException;
import com.Lalitdk.LinkUp.user_service.Exception.ResourceNotFoundException;
import com.Lalitdk.LinkUp.user_service.Repository.UserRepository;
import com.Lalitdk.LinkUp.user_service.Utils.PasswordUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    
    public UserDto signUp(SignUpRequestDto signUpRequestDto) {
        
        boolean exists = userRepository.existsByEmail(signUpRequestDto.getEmail());
        if(exists) throw new BadRequestException("User Already exists with email" + signUpRequestDto.getEmail());

        User user = modelMapper.map(signUpRequestDto, User.class);
        user.setPassword(PasswordUtils.hashPassword(signUpRequestDto.getPassword()));


        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserDto.class);
    }


    public String login(LoginRequestDto loginRequestDto) {
             User user = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(()-> new ResourceNotFoundException("User not found with email"+ loginRequestDto.getEmail()));

                boolean isPasswordMatch = PasswordUtils.checkPassword(loginRequestDto.getPassword(), user.getPassword());
                if(!isPasswordMatch) throw new BadRequestException("Invalid password");

                return jwtService.generateAccessToken(user);
         }





    
}
