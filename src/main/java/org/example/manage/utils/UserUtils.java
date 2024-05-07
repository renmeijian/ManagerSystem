package org.example.manage.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.example.manage.common.NoLoginException;
import org.example.manage.entity.UserDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

public class UserUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserUtils.class);

    public UserUtils() {
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public static String getHeader(String key) {
        return getRequest().getHeader(key);
    }

    public static UserDetail nowLoginUser() throws NoLoginException {
        String userString = null;

        try {
            String encodeUserString = getHeader("user-info");
            byte[] decodedBytes = Base64.getDecoder().decode(encodeUserString);
             userString = new String(decodedBytes);
        } catch (Exception e){
            throw new NoLoginException("Abnormal user information");
        }

        if (StringUtils.isBlank(userString)) {
            throw new NoLoginException();
        } else {
            UserDetail userDetail = (UserDetail) JSONObject.parseObject(userString, UserDetail.class);
            return userDetail;
        }
    }

    public static String getUserId() throws NoLoginException {
        return nowLoginUser().getUserId();
    }

    public static String getAccountName() throws NoLoginException {
        return nowLoginUser().getAccountName();
    }

    public static String getRole() throws NoLoginException {
        return nowLoginUser().getRole();
    }
}
