package com.adonai.simplehouse.security.register;

import com.adonai.simplehouse.model.Users;
import com.adonai.simplehouse.util.ResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("api")
@CrossOrigin("*")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    @ExceptionHandler(ResourceException.class)
    public ResponseEntity<?> register(@RequestBody Users user) throws Exception {
        user.setTenant(user.getNick());
        registerService.onSaveRegister(user);
        String a = registerService.onSendEmailConfirmation(user);
        user.setSenha("");
        return ResponseEntity.status(200).body(a);


    }
}
