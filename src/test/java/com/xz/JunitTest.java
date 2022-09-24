package com.xz;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@DisplayName("Junit5 功能测试类")
public class JunitTest {

    @DisplayName("测试异常断言")
    @Test
    public void testExceptionAssertions() {
//        Assertions.assertThrows(ArithmeticException.class, () -> System.out.println(1/1), "数学运算未抛出异常");
//        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(1100));
        Assertions.fail("直接失败");
    }

    @DisplayName("测试组合断言")
    @Test
    public void testAllAssertions() {
        Assertions.assertAll("Math",
                () -> Assertions.assertEquals(2, 3, "与期待值不同"),
                () -> Assertions.assertTrue(1 > 2, "比较失败")
        );
    }

    @DisplayName("测试数组断言")
    @Test
    public void testArrayAssertions() {
        Assertions.assertArrayEquals(new int[]{2, 1, 0}, new int[]{2, 0, 1}, "数组元素不相同");
    }


    @DisplayName("测试简单断言")
    @Test
    public void testSimpleAssertions() {
//        int cal = cal(3, 3);
        // 第一个参数为期望值, 第二个为真实值, 第三个为错误时输出的信息
//        Assertions.assertEquals(cal, 5, "计算错误");
        Object o = new Object();
        Object o2 = new Object();
        Assertions.assertSame(o, o2, "不是同一个对象");
    }


    int cal(int a, int b) {
        return a + b;
    }


    @DisplayName("测试 @DisPlayName 注解")
    @Test
    public void testDisPlayName() {
        System.out.println(1);
    }

    @Disabled
    @DisplayName("测试方法 2")
    @Test
    public void test2() {
        System.out.println(2);
    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @DisplayName("测试超时方法")
    @Test
    public void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }

    @RepeatedTest(5)
    @Test
    public void testRepeatedTest() {
        System.out.println(5);
    }

    @BeforeEach
    public void testBeforeEach() {
        System.out.println("测试要开始了");
    }

    @AfterEach
    public void testAfterEach() {
        System.out.println("测试结束了");
    }

    @BeforeAll
    public static void testBeforeAll() {
        System.out.println("所有测试就要开始了");
    }

    @AfterAll
    public static void testAfterAll() {
        System.out.println("所有测试已经结束了");
    }
}
