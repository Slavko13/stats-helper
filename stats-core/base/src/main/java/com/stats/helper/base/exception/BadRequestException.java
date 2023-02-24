package com.stats.helper.base.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.Set;

public class BadRequestException extends RequestException
{
    public BadRequestException(final String message, final Throwable cause, final HttpStatus httpStatus, final Map<String, Set<String>> details)
    {
        super(message, cause, httpStatus, details);
    }
}
