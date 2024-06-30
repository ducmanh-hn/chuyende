package com.tlu.chuyende.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
@Builder
public class ResponseError implements Serializable {
    private String field;
    private Object data;
    private String message;
}
