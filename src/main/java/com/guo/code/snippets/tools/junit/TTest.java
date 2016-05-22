package com.guo.code.snippets.tools.junit;

import org.junit.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class TTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void testAdd() {
        int z = new T().add(5, 3);
        assertThat(z, is(8));
        assertThat(z, allOf(greaterThan(5), lessThan(10)));
        //int a = 8/0;
    }


    @Test(expected = java.lang.ArithmeticException.class, timeout = 100)
    public void testDivide() {
        int z = new T().divide(8, 0);

    }

    @After
    public void after() {
        System.out.println("after");
    }

}
