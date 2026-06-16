package com.reptithcm.edu.kiemtrahackathon.dto;

import com.reptithcm.edu.kiemtrahackathon.entity.GamingGear;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GamingGearDtoRequest {
    @NotBlank(message = "productName is not null")
    private String productName;

    @NotBlank(message = "productName is not null")
    private String serialCode;

    @Min(value = 0)
    private double price;

    @NotBlank(message = "productName is not null")
    private String type;

}
