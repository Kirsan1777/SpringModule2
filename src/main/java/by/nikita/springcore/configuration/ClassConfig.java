package by.nikita.springcore.configuration;

import by.nikita.springcore.model.entity.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.nikita.springcore")
public class ClassConfig {
    @Bean
    public TestBean bean(){
        return new TestBean("Nik");
    }

    /*

    @Component - создание бина из класса
    @Autowiring - автоматическое внедрение зависимостей
    @Qualifier - уточнение внедряемой зависимости для @Autowiring


    Для бинов использовать scope = prototipe потому что бины будут создаваться отдельно
    для него не вызывается метод destroy от Spring, надо ручками, если оно надо
    Изначально scope = singleton!!!


        не работает эта херовина

        <aop:config>
        <aop:aspect id="song" ref="minstrel">
            <aop:pointcut id="accept"
                          expression="execution(* by.nikita.springcore.model.entity.Knight.acceptQuest(..))"/>

            <aop:before pointcut-ref="accept" method="beforeQuest"/>

            <aop:after pointcut-ref="accept" method="afterQuest"/>

        </aop:aspect>
    </aop:config>
*/
}
