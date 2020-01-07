package com.lucas;

import static org.junit.Assert.assertTrue;

import com.lucas.pojo.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Before
    public void init() {

    }

    @Test
    public void testSpring1() {
        //加载Spring配置文件
        ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext("spring.xml");
        //取出Bean容器中的实例
        HelloSpring helloSpring = (HelloSpring)cpxac.getBean("helloSpring");
        //调用bean实例中的方法
        helloSpring.hello();

//        HelloSpring helloSpring1 = new HelloSpring();
//        helloSpring1.hello();

    }

    @Test
    public void testSpring2() {
        //加载Spring配置文件
        ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext("spring.xml");
        //取出Bean容器中的实例
        Person person = (Person)cpxac.getBean("person");
        //调用bean实例中的方法

        System.out.println(person);
    }
}
