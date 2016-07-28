package com.guo.code;

import com.guo.code.spring.profile.DemoService;
import com.guo.code.spring.profile.ProfileConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProfileConfig.class})
@ActiveProfiles("prod")
public class DemoBeanIntegrationTests {

    @Autowired
    private DemoService demoService;

    @Test
    public void prodBeanShouldInject() {
        String expected = "prod env";
        String actual = demoService.getContent();
        Assert.assertEquals(expected, actual);
    }
}
