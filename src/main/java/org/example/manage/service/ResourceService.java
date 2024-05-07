package org.example.manage.service;

import org.example.manage.common.AppResponse;
import org.example.manage.common.NoLoginException;

public interface ResourceService {
    AppResponse checkResource(String resource) throws NoLoginException;

}
