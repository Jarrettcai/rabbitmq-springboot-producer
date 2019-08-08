package com.enn.springboot;

import com.enn.springboot.producer.RabbitSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqSpringbootProducerApplicationTests {

    @Autowired
    private RabbitSender rabbitSender;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    public void testSender() {
        Map<String, Object> map = new HashMap<>();
        map.put("number", "hello");
        map.put("send time:", format.format(new Date()));
        rabbitSender.send("Hello RabbitMQ From SpringBoot!", map);
    }
}
