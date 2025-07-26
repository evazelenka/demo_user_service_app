package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "magic-sql")
@Getter
@Setter
@ToString
public class MagicProperties {
    private String findAll;
    private String save;
    private String getById;
    private String updateUser;
    private String updateFirstName;
    private String updateLastName;
    private String delete;
}
