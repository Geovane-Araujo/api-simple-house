package com.adonai.simplehouse.security.register;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("api/register")
public class RegisterController {


    @PostMapping()
    public ResponseEntity<?> register(){

        return ResponseEntity.ok().body(new Object());
    }
}
