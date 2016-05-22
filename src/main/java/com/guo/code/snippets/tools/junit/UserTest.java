package com.guo.code.snippets.tools.junit;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void testGetName() {
        assertThat(new User().getName(), is("我是一个测试的类"));
    }

}
