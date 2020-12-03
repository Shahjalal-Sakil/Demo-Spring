package com.example.demo.model;
import com.example.demo.entity.Donor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Donor Model",description = "Describing the details of a donor")
public class DonorDto {
    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "blood group",allowableValues = "A+, A-,B+,B-,AB+,AB-")
    private String bloodGroup;

    @ApiModelProperty(value = "contact")
    private String contact;
}