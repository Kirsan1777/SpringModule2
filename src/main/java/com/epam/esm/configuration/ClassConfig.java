package com.epam.esm.configuration;

import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.model.entity.Tag;
import com.epam.esm.model.service.impl.TagServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


public class ClassConfig {

    @Bean
    public GiftCertificate bean(){
        return new GiftCertificate();
    }

    @Bean
    public Tag knightWithParam(){
        return new Tag();
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
