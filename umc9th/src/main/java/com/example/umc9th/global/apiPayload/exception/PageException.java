package com.example.umc9th.global.apiPayload.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;

public class PageException extends GeneralException {
  public PageException(BaseErrorCode code) {
    super(code);
  }
}
