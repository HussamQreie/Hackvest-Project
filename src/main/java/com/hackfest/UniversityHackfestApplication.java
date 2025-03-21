package com.hackfest;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class UniversityHackfestApplication {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(UniversityHackfestApplication.class, args);
    }

    @PostConstruct
    public void initData() {
        try (Connection conn = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(conn, new ClassPathResource("data.sql"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute data.sql", e);
        }
    }
}