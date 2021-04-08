package com.sdargol.controller;

import com.sdargol.dto.MoneyRequest;
import com.sdargol.entity.PurseEntity;
import com.sdargol.entity.UserEntity;
import com.sdargol.exceptions.AccountBalanceException;
import com.sdargol.exceptions.IncorrectAmountException;
import com.sdargol.exceptions.ResponseException;
import com.sdargol.service.PurseService;
import com.sdargol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/terminal")
@CrossOrigin(origins = "http://localhost:3000")
public class TerminalController {
    private final UserService userService;
    private final PurseService purseService;

    @Autowired
    public TerminalController(UserService userService, PurseService purseService) {
        this.userService = userService;
        this.purseService = purseService;
    }

    @GetMapping
    public ResponseEntity<UserEntity> getState(Principal principal){
        return ResponseEntity.ok(userService.findByLogin(principal.getName()));
    }

    @PostMapping("/get")
    public ResponseEntity<PurseEntity> getMoney(@RequestBody MoneyRequest moneyRequest, Principal principal) throws IncorrectAmountException, AccountBalanceException {
        UserEntity userEntity = userService.findByLogin(principal.getName());
        PurseEntity purseEntity = purseService.getMoney(userEntity.getPurseEntity(), moneyRequest.getAmount());
        return ResponseEntity.ok(purseEntity);
    }

    @PostMapping("/set")
    public ResponseEntity<PurseEntity> setMoney(@RequestBody MoneyRequest moneyRequest, Principal principal) throws IncorrectAmountException{
        UserEntity userEntity = userService.findByLogin(principal.getName());
        PurseEntity purseEntity = purseService.setMoney(userEntity.getPurseEntity(), moneyRequest.getAmount());
        return ResponseEntity.ok(purseEntity);
    }

    @ExceptionHandler({AccountBalanceException.class , IncorrectAmountException.class})
    public ResponseEntity<ResponseException> exceptionHandler(Exception ex){
        return new ResponseEntity<>(new ResponseException(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
