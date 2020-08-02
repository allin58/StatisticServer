package com.project.userobserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Date format is wrong")
public class BadDateFormatException extends RuntimeException {
}
