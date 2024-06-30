package com.tlu.chuyende.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException{
    private ResponseError error;

    public NotFoundException(int id){
        this.error = ResponseError.builder()
                .field("id")
                .data(id)
                .message("Id in this path is not found!").build();
    }
}
