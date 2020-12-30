package com.myvhr.mailserver;

import com.myvhr.mailserver.model.Department;
import com.myvhr.mailserver.model.Employee;
import com.myvhr.mailserver.model.Position;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailserverApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() {
    }
    @Test
    void sendMessage(){
        Employee employee = new Employee();
        Position position = new Position();
        Department department = new Department();
        position.setName("cc");
        department.setName("cc");
        employee.setEmail("974269842@qq.com");
        employee.setName("cc");
        employee.setAddress("aa");
        employee.setDepartment(department);
        employee.setPosition(position);
        rabbitTemplate.convertAndSend("employee.welcome",employee);
    }

}
