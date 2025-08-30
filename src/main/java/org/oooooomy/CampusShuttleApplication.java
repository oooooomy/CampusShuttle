package org.oooooomy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.oooooomy.mapper")
public class CampusShuttleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusShuttleApplication.class, args);
    }

}
