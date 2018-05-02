package org.cdp.skeleton.presentation.config;

import org.cdp.skeleton.facade.config.FacadeConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import({FacadeConfiguration.class})
@ImportResource({"classpath:persistence-context.xml", "classpath:service-context.xml"})
@PropertySources(value = {@PropertySource("${application.config:classpath:application.properties}")})
@SuppressWarnings("PMD.UseUtilityClass")
public class AppRootConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
