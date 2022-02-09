package com.adonai.simplehouse.model;


import com.jatom.anotations.Id;
import com.jatom.anotations.TableName;
import lombok.Getter;
import lombok.Setter;

@TableName("users")
@Getter
@Setter
public class Users {

    @Id
    private int id;
    private String nome;
    private String nick;
    private String email;
    private String senha;
    private boolean confirmation;
}
