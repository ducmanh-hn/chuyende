package com.tlu.chuyende.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidRequest extends RuntimeException{
    private ResponseError error;

}
