package com.admin.service;

import com.admin.api.service.AmqpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;

/**
 * @author ms
 * @Description:
 * @Package com.admin.service
 * @date: Created in 2018/7/23 16:01
 */
/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminServiceApplication.class)*/
public class AmqpServiceTest {

    @Autowired
    private AmqpService amqpService;





    private static final String QUEUE = "amqp-queue";


    //    @Test
    public void convertAndSendTest() {
        amqpService.convertAndSend(QUEUE, "rabbit mq send test: send success");
    }

    public static void main(String[] args) {
        /*String str=AmqpServiceTest.class.getName().replace('.', '/') + ".class";
        System.out.println(str);*/
    }

}
