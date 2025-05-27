package org.example.infrastructure.dto.request;

import org.example.core.domain.enums.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullname, UserTypeEnum type, String pin){
}
