package com.lga.spring;

import org.springframework.stereotype.Service;

@Service
public class AccountDaoImpl implements AccountDao {

    @Override
    public String queryAccountName(String id) {
        return "lga";
    }

}
