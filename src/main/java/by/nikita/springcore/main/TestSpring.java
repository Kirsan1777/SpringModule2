package by.nikita.springcore.main;

import by.nikita.springcore.configuration.ClassConfig;
import by.nikita.springcore.model.entity.Knight;
import by.nikita.springcore.model.entity.Minstrel;
import by.nikita.springcore.model.entity.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ClassConfig.class);
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
