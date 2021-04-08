package com.sdargol.controller;

import com.sdargol.protect.IPFilter;
import com.sdargol.config.jwt.JwtProvider;
import com.sdargol.dto.AuthRequest;
import com.sdargol.dto.AuthResponse;
import com.sdargol.dto.RegistrationRequest;
import com.sdargol.entity.UserEntity;
import com.sdargol.protect.IPData;
import com.sdargol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class AuthController {
    private final UserService userService;
    private final JwtProvider jwtProvider;
    private final ConcurrentHashMap<String, IPData> ipStrangeStorage;

    @Autowired
    public AuthController(UserService userService,
                          JwtProvider jwtProvider,
                          ConcurrentHashMap<String, IPData> ipStrangeStorage) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
        this.ipStrangeStorage = ipStrangeStorage;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationRequest registrationRequest) {
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userService.saveUser(u);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request, ServletRequest servletRequest) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = null;

        try {
            token = jwtProvider.generateToken(userEntity.getLogin());
            if(ipStrangeStorage.containsKey(IPFilter.getIp(servletRequest))){
                System.out.println("Сброс попыток входа ip");
                ipStrangeStorage.get(IPFilter.getIp(servletRequest)).resetAttempt();
            }
        } catch (NullPointerException e){
            if(ipStrangeStorage.containsKey(IPFilter.getIp(servletRequest))){
                System.out.println("Такой ip мы уже блокировали");
                ipStrangeStorage.get(IPFilter.getIp(servletRequest)).addAttempt();
                System.out.println( ipStrangeStorage.get(IPFilter.getIp(servletRequest)).getIpStatusBlocked());
            }else{
                System.out.println("Такой ip мы ещё не блокировали, добавляем");
                ipStrangeStorage.put(IPFilter.getIp(servletRequest), new IPData(1,0,0));
            }
        }

        return new AuthResponse(token);
    }
}
