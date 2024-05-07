package org.example.manage.entity;

import lombok.Data;

import java.util.List;

@Data
public class AddUserDto {
    private String userId;

    private List<String> endpoint;
}
