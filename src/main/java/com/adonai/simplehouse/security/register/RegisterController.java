package com.adonai.simplehouse.security.register;

import com.adonai.simplehouse.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("api")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users user){
        registerService.onSaveRegister(user);
        return ResponseEntity.ok().body("OK");
    }
}
