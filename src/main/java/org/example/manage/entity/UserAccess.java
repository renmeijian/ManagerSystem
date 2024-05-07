package org.example.manage.entity;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

@Component
public class UserAccess {

    public final Map<String, AddUserDto> userAccessMap = new ConcurrentHashMap<>();

    public void putUserAccess(AddUserDto addUserDto) {
        userAccessMap.put(addUserDto.getUserId(), addUserDto);
    }

    public AddUserDto getUserAccess(String userId) {
        return  userAccessMap.get(userId);
    }
}
