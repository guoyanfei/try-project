package com.guo.code.spring.value;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Configuration
@ComponentScan("com.guo.code.spring.value")
//@PropertySource("classpath:com/guo/code/spring/value/test.properties")
@PropertySource("http://configserver.kazmodan.top/test-springcloud.properties")
public class ElConfig {

    @Value(" i love you!")
    private String normal;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber;

    @Value("#{demoService.another}")
    private String fromAnother;

    @Value("classpath:com/guo/code/spring/value/test.txt")
    private Resource testFile;

    @Value("http://configserver.kazmodan.top/test-springcloud.properties")
    private Resource testUrl;

    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    /**
     * 注入配置配件需要使用@PropertySource 指定文件地址,如果使用@value 注入,则要配置一个
     * PropertySourcesPlaceholderConfigurer 的 Bean
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        System.out.println(normal);
        System.out.println(osName);
        System.out.println(randomNumber);
        System.out.println(fromAnother);

        try {
            System.out.println(IOUtils.toString(testFile.getInputStream()) + "\n\n\n\n\n");
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n\n\n" + bookName);
        System.out.println(environment.getProperty("book.author"));
    }
}
