package by.nikita.springcore.configuration;

import by.nikita.springcore.model.entity.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassConfig {
    @Bean
    public TestBean bean(){
        return new TestBean("Nik");
    }

    /*
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
