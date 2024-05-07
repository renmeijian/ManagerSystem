package org.example.manage.service;


import org.example.manage.common.AppResponse;
import org.example.manage.common.NoLoginException;
import org.example.manage.entity.AddUserDto;

public interface ManagerService {
    AppResponse addUser(AddUserDto addUserDto) throws NoLoginException;
}
