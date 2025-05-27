package org.example.infrastructure.controller;

import org.example.infrastructure.dto.request.CreateUserRequest;
import org.example.infrastructure.dto.response.BaseResponse;
import org.example.infrastructure.mapper.UserMapper;
import org.example.usecase.CreateUserUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private CreateUserUseCase createUserUseCase;

    private UserMapper userMapper;
    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping("/createUser")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws Exception {
        createUserUseCase.create(userMapper.toUser(request), request.pin());

        return BaseResponse.<String>builder().sucess(true).message("usuario criado com sucesso").build();
    }
}
