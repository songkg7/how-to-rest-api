package com.haril.restapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author songkg7
 * @version 1.0.0
 * @since 2021/05/18 10:51 오후
 */

@Data
public class CarDto {
    private String name;

    @JsonProperty("car_number")
    private String carNumber;
}
