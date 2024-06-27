package com.qaliwarma.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements Serializable {

    @JsonIgnore
    private Integer code;
    private String message;
    private Object body;
}
