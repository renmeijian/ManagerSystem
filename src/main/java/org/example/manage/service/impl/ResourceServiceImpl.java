package org.example.manage.service.impl;

import org.example.manage.common.AppResponse;
import org.example.manage.common.NoLoginException;
import org.example.manage.entity.AddUserDto;
import org.example.manage.entity.UserAccess;
import org.example.manage.service.ResourceService;
import org.example.manage.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private UserAccess userAccess;

    @Override
    public AppResponse checkResource(String resource) throws NoLoginException {
        String userId = UserUtils.getUserId();
        AddUserDto addUserDto = userAccess.getUserAccess(userId);
        if(null == addUserDto || CollectionUtils.isEmpty(addUserDto.getEndpoint())){
            return AppResponse.error("fail");
        }
        Set<String> endpointSet = new HashSet<>(addUserDto.getEndpoint());
        if(endpointSet.contains(resource)){
            return AppResponse.success("success");
        }
        return AppResponse.error("fail");
    }
}
