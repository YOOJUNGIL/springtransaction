package com.myalley.springtransaction.controller;

import com.myalley.springtransaction.dao.dto.CustUser;
import com.myalley.springtransaction.dao.service.CustUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class CustUserController {

    @Autowired
    private CustUserService custUserService;

    @GetMapping("/users")
    public List<CustUser> users() {
        return custUserService.getCustUserList();
    }

    @GetMapping("/save")
    public int save() {
        return custUserService.save(null);
    }

}
