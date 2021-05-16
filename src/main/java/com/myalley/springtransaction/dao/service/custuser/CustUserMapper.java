package com.myalley.springtransaction.dao.service.custuser;

import com.myalley.springtransaction.dao.dto.CustUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustUserMapper {

    public List<CustUser> getCustUserList();
    public int save(CustUser custUser);

}
