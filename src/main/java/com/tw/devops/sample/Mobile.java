package com.tw.devops.sample;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Mobile {
    private String modelNo;
    private String platform;
    private String brand;
    private String OSVersion;
    private String name;
}
