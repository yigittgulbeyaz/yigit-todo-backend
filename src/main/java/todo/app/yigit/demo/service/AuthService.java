package todo.app.yigit.demo.service;

import todo.app.yigit.demo.dto.auth.RegisterRequest;
import todo.app.yigit.demo.dto.auth.RegisterResponse;
import todo.app.yigit.demo.dto.auth.LoginRequest;
import todo.app.yigit.demo.dto.auth.LoginResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}
