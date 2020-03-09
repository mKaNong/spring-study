package com.ahdy.xem.transaction.service.impl;

import com.ahdy.xem.transaction.dao.AccountDao;
import com.ahdy.xem.transaction.service.OrdersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource
    private AccountDao accountDao;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void accountMoney() {
        // a--
        accountDao.addMoney();

        int i = 10 / 0;
        // b++
        accountDao.reduceMoney();
    }
}
