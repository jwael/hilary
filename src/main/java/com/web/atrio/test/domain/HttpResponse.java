package com.web.atrio.test.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.util.Map;
/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class HttpResponse {

    protected String timeStamp;

    protected Map<?,?> data;

    protected HttpStatus httpStatus;

    protected Integer statusCode;

    protected String message;
 }
