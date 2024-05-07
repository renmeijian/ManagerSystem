package org.example.manage.controller;

import org.example.manage.common.AppResponse;
import org.example.manage.common.NoLoginException;
import org.example.manage.entity.AddUserDto;
import org.example.manage.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class managerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/addUser")
    public AppResponse<?> addUser(@RequestBody AddUserDto addUserDto) throws NoLoginException {
        return managerService.addUser(addUserDto);
    }
}
