package sof3022.java5.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.time.Duration;
import java.util.Locale;

@Configuration
public class MessagesConfig implements WebMvcConfigurer {
    @Bean("messageSource")
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource rrbms = new ReloadableResourceBundleMessageSource();
        rrbms.setBasenames("classpath:i18n/messages");
        rrbms.setDefaultEncoding("UTF-8");
        rrbms.setCacheSeconds(1);
        rrbms.setUseCodeAsDefaultMessage(true);
        return rrbms;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        registry.addInterceptor(lci);
    }

    @Bean("localeResolver")
    public LocaleResolver getLocaleResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setCookieName("language");
        localeResolver.setCookieMaxAge(Duration.ofDays(30));
        localeResolver.setDefaultLocale(new Locale("vi"));
        return localeResolver;
    }


}
