package com.spring.user.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDto {
    private String name;
    private String catchPhrase;
    private String bs;
}
