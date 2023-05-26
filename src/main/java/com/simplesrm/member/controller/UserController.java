package com.simplesrm.member.controller;

import com.simplesrm.api.common.ApiResponse;
import com.simplesrm.api.common.SignUpRequest;
import com.simplesrm.member.service.UserService;
import com.simplesrm.member.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/v1/users")
    public ApiResponse getUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userService.getUser(principal.getUsername());

        return ApiResponse.success("user", user);
    }


    @PostMapping("/api/v1/join")
    public ApiResponse signUp(@Valid @RequestBody SignUpRequest signUpRequest) {

        User result = userService.signUp(signUpRequest);

        if(result==null){
            return ApiResponse.fail();
        }

        return ApiResponse.success("User registered successfully@", result);

    }

    @GetMapping("/user/email-auth")
    public String emailAuth(Model model, HttpServletRequest request) {
        String userId = request.getParameter("id");

        boolean result = userService.emailAuth(userId);

        model.addAttribute("result", result);


        return "member/email_auth";
    }



}
