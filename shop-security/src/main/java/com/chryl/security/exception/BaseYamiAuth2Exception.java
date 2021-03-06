/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.chryl.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

/**
 */
public abstract class BaseYamiAuth2Exception extends AuthenticationException {

    public BaseYamiAuth2Exception(String msg) {
        super(msg);
    }

    public int getHttpErrorCode() {
        // 400 not 401
        return HttpStatus.BAD_REQUEST.value();
    }

    public abstract String getOAuth2ErrorCode();
}
