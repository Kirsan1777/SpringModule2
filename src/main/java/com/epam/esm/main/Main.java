package com.epam.esm.main;

import com.epam.esm.configuration.ClassConfig;
import com.epam.esm.model.service.impl.TagServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        //AnnotationConfigApplicationContext context =
          //      new AnnotationConfigApplicationContext(ClassConfig.class);

        //Knight knight = context.getBean("knightWithParam", Knight.class);
        //knight.acceptQuest();

        //TagServiceImpl tagService = context.getBean("tagServiceImpl", TagServiceImpl.class);
        TagServiceImpl tagService = new TagServiceImpl();
        tagService.addTag("Ira");
        //tagService.deleteTag(1);
        //context.close();

        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml" // файл должен всегда лежать в папке с ресурсами
        );

        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println("Name = " + testBean.getName());
        //TestBean testClearBean = context.getBean("clearTestBean", TestBean.class);
        //System.out.println("Clear = " + testClearBean.getName());
        Knight knight = context.getBean("knight", Knight.class);
        knight.acceptQuest();
        Minstrel minstrel = context.getBean("minstrel", Minstrel.class);
        minstrel.afterQuest();
        context.close();
        */
        /*
        Как эти конфиги должны подключатсья к работе?
        Выдается ошибка при создании AOP
            <aop:config>
        <aop:aspect id="song" ref="minstrel">
            <aop:pointcut id="accept"
        expression="execution(* by.nikita.springcore.model.entity.Knight.acceptQuest(..))"/>

            <aop:before pointcut-ref="accept" method="beforeQuest"/>

            <aop:after pointcut-ref="accept" method="afterQuest"/>

        </aop:aspect>
    </aop:config>

         */


    /*
        Пул соединений, для веб проекта
        <bean id="dataSource"
        class="org.apache.commons.dbcp.BasicDataSource">
 <property name="driverClassName" value="org.hsqldb.jdbcDriver" />
 <property name="url"
        value="jdbc:hsqldb:hsql://localhost/spitter/spitter" />
 <property name="username" value="sa" />
 <property name="password" value="" />
 <property name="initialSize" value="5" />
 <property name="maxActive" value="10" />
</bean> */
    }
}

