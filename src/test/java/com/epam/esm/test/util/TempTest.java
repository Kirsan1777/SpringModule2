package com.epam.esm.test.util;

import com.epam.esm.util.TagValidator;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TempTest {
    @Bean
    @Primary
    public TagValidator nameService() {
        return Mockito.mock(TagValidator.class);
    }

}
