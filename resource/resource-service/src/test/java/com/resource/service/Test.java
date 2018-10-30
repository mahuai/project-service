package com.resource.service;

import org.springframework.boot.env.RandomValuePropertySource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author ms
 * @Description: class description
 * @Package com.resource.service
 * @date: Created in 2018/10/9  9:24
 */
public class Test {

    public static void main(String[] args) {

        InputStream stream = ClassLoader.getSystemResourceAsStream("application.properties");
        if (null != stream) {
            Properties properties = new Properties();
            try {
                properties.load(stream);
                String secret = properties.getProperty("secret");
                String number = properties.getProperty("number");
                String bigNumber = properties.getProperty("bignumber");
                String uuid = properties.getProperty("uuid");
                String numberLessThanTen = properties.getProperty("number.less.than.ten");
                String numberInRange = properties.getProperty("number.in.range");
                RandomValuePropertySource randomValuePropertySource = new RandomValuePropertySource();
                Object secretValue = randomValuePropertySource.getProperty(secret);
                System.out.println(secretValue);
                Object numberValue = randomValuePropertySource.getProperty(number);
                System.out.println(numberValue);
                Object bigNumberValue = randomValuePropertySource.getProperty(bigNumber);
                System.out.println(bigNumberValue);
                Object uuidValue = randomValuePropertySource.getProperty(uuid);
                System.out.println(String.valueOf(uuidValue).replace("-", ""));
                Object numberLessThanTenValue = randomValuePropertySource.getProperty(numberLessThanTen);
                System.out.println(numberLessThanTenValue);
                Object numberInRangeValue = randomValuePropertySource.getProperty(numberInRange);
                System.out.println(numberInRangeValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
