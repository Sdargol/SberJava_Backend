package com.sdargol.controller;

import com.sdargol.dto.ArrCar;
import com.sdargol.dto.Car;
import com.sdargol.entity.PurseEntity;
import com.sdargol.entity.UserEntity;
import com.sdargol.exceptions.AccountBalanceException;
import com.sdargol.exceptions.ResponseException;
import com.sdargol.repository.PurseEntityRepository;
import com.sdargol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TestController {
    private final UserService userService;
    private final PurseEntityRepository purseEntityRepository;

    @Autowired
    public TestController(UserService userService, PurseEntityRepository purseEntityRepository) {
        this.userService = userService;
        this.purseEntityRepository = purseEntityRepository;
    }

    @GetMapping("/admin/get")
    public String getAdmin() {
        return "Hi admin";
    }

    @GetMapping("/user/get")
    public ResponseEntity<Car> getUser(Principal p) throws AccountBalanceException {
        if(true) throw new AccountBalanceException("Недостаточно средств");
        return ResponseEntity.ok(new Car(p.getName()));
    }

    @GetMapping("/user/money")
    public ResponseEntity<UserEntity> testMoney(Principal p){
        UserEntity u = userService.findByLogin(p.getName());
        PurseEntity pe = u.getPurseEntity();
        pe.setBalance(5000);
        purseEntityRepository.save(pe);
        return ResponseEntity.ok(u);
    }

    @PostMapping ("/user/body")
    public void testBody(@RequestBody String b){
        System.out.println(b);
        System.out.println("работает");
    }

    @PostMapping("/user/arr")
    public void testArr(@RequestBody ArrCar arrCar){
        System.out.println(arrCar.getValue());
        System.out.println(arrCar.getCarList().toString());
    }

    @ExceptionHandler(AccountBalanceException.class)
    public ResponseEntity<ResponseException> handleException(AccountBalanceException ex){
        return new ResponseEntity<>(new ResponseException(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
