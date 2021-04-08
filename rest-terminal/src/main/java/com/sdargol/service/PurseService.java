package com.sdargol.service;

import com.sdargol.entity.PurseEntity;
import com.sdargol.exceptions.AccountBalanceException;
import com.sdargol.exceptions.IncorrectAmountException;
import com.sdargol.repository.PurseEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class PurseService {
    private final PurseEntityRepository purseEntityRepository;
    public final static int AMOUNT = 100;

    @Autowired
    public PurseService(PurseEntityRepository purseEntityRepository) {
        this.purseEntityRepository = purseEntityRepository;
    }

    public PurseEntity getMoney(PurseEntity purseEntity, int money) throws AccountBalanceException, IncorrectAmountException {
        if(money % AMOUNT != 0){
            throw new IncorrectAmountException("Сумма должна быть кратна " + AMOUNT);
        }

        if(purseEntity.getBalance() < money){
            throw new AccountBalanceException("Недостаточно средств на счете (Ваш баланс " + purseEntity.getBalance() + ")");
        }

        purseEntity.setBalance(purseEntity.getBalance() - money);
        purseEntityRepository.save(purseEntity);

        return purseEntity;
    }

    public PurseEntity setMoney(PurseEntity purseEntity, int money) throws IncorrectAmountException{
        if(money % AMOUNT != 0){
            throw new IncorrectAmountException("Сумма должна быть кратна " + AMOUNT);
        }

        purseEntity.setBalance(purseEntity.getBalance() + money);
        purseEntityRepository.save(purseEntity);

        return purseEntity;
    }
}
