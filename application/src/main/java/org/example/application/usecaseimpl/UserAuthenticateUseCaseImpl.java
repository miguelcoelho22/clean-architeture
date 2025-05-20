package org.example.application.usecaseimpl;

import org.example.application.gateway.UserAuthenticateGateway;
import org.example.core.exception.AuthenticateException;
import org.example.core.exception.enums.ErrorCodeEnum;
import org.example.usecase.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {

    private UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) throws AuthenticateException {
        if(!userAuthenticateGateway.authenticate(username, password)){
            throw new AuthenticateException(ErrorCodeEnum.ATH0001.getCode(), ErrorCodeEnum.ATH0001.getMessage());
        }
        return true;
    }
}
