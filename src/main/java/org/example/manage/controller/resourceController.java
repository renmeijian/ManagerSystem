package org.example.manage.controller;

import org.example.manage.common.AppResponse;
import org.example.manage.common.NoLoginException;
import org.example.manage.entity.AddUserDto;
import org.example.manage.service.ManagerService;
import org.example.manage.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class resourceController {
    @Autowired
    private ResourceService resourceService;

    @PostMapping("/{resource}")
    public AppResponse<?> checkResource(@PathVariable("resource") String resource) throws NoLoginException {
        return resourceService.checkResource(resource);
    }
}
