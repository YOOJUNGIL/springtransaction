package com.myalley.springtransaction.dao.service;

import com.myalley.springtransaction.dao.dto.CustUser;
import com.myalley.springtransaction.dao.service.custuser.CustUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustUserService {

    @Autowired
    private CustUserMapper custUserMapper;

    public List<CustUser> getCustUserList() {
        return custUserMapper.getCustUserList();
    }

    /**
     * 새로운 트랜잭션을 이용하여 처리하고 오류시 해당 트랜잭션을 롤백한다.
     * @param custUser
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor={Exception.class})
    public int save(CustUser custUser) {
        int insCount = 0;

        custUser = new CustUser();
        custUser.setUserId("USER1");
        custUser.setMobileNo("00000000000");
        custUser.setAddr("SHIHEUNG");

        insCount += custUserMapper.save(custUser);

        custUser = new CustUser();
        custUser.setUserId("USER2");
        custUser.setMobileNo("00000000000");
        custUser.setAddr("SHIHEUNG");

        insCount += custUserMapper.save(custUser);

        //강제로 Exception을 발생시켜 Rollback이 되는 지 확인하였음!!!
        int i = 5 / 0;

        return  insCount;
    }

}
