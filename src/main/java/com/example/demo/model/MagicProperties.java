package com.example.demo.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class MagicProperties {

    @Value("${data.sql.select.all}")
    private String SELECT_ALL;

    @Value("${sql.insert.into}")
    private String INSERT_INTO;

    @Value("${sql.select.user.by.id}")
    private String SELECT_USER;

    @Value("${sql.update.user}")
    private String UPDATE_USER;

    @Value("${sql.update.user.firstName}")
    private String UPDATE_FIRSTNAME;

    @Value("${sql.update.user.lastName}")
    private String UPDATE_LASTNAME;

    @Value("${sql.delete.user}")
    private String DELETE_USER;
}
