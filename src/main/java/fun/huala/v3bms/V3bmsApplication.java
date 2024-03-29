package fun.huala.v3bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class V3bmsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(V3bmsApplication.class, args);
        System.out.println("启动成功");

    }

}
