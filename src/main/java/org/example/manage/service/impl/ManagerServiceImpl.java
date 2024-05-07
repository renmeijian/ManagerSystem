package org.example.manage.service.impl;

import org.example.manage.common.AppResponse;
import org.example.manage.common.NoLoginException;
import org.example.manage.entity.AddUserDto;
import org.example.manage.entity.UserAccess;
import org.example.manage.service.ManagerService;
import org.example.manage.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService {


    @Autowired
    private UserAccess userAccess;
    @Override
    public AppResponse addUser(AddUserDto addUserDto) throws NoLoginException {
        String role = UserUtils.getRole();
        if(!"admin".equals(role)){
            return AppResponse.error("no access");
        }
        userAccess.putUserAccess(addUserDto);
        return AppResponse.success("add success");
    }
}
