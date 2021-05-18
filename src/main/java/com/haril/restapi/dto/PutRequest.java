package com.haril.restapi.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

/**
 * @author songkg7
 * @version 1.0.0
 * @since 2021/05/18 10:50 오후
 */

@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutRequest {

    private String name;
    private int age;
    private List<CarDto> carList;

}
