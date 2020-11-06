//package eu.europa.ec.estat.esa.config;
//
//import eu.europa.ec.estat.esa.validation.EmailValidator;
//import eu.europa.ec.estat.esa.validation.PasswordMatchesValidator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class MvcConfig implements WebMvcConfigurer {
//
//    public MvcConfig() {
//        super();
//    }
// 
//
//    @Override
//    public void addViewControllers(final ViewControllerRegistry registry) {
//    	registry.addViewController("/index.html");
//    	registry.addViewController("/403.html");
//    	registry.addViewController("/error.html");
//    	registry.addViewController("/user.html");
//        registry.addViewController("/login.html");
//        registry.addViewController("/chapter.html");
//        registry.addViewController("/term.html");
//        registry.addViewController("/footnote.html");
//        registry.addViewController("/users.html");
//        registry.addViewController("/footnotes.html");
//        registry.addViewController("/chapters.html");
//        registry.addViewController("/terms.html");
//        registry.addViewController("/new_user.html");
//        registry.addViewController("/new_chapter.html");
//        registry.addViewController("/new_footnote.html");
//        registry.addViewController("/new_term.html");
//        registry.addViewController("/user_update.html");
//        registry.addViewController("/term_update.html");
//        registry.addViewController("/chapter_update.html");
//        registry.addViewController("/chapter_update.html");
//        
//       
//    }
//    
//    @Override
//    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//
//    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
//            "classpath:/META-INF/resources/", "classpath:/resources/",
//            "classpath:/static/", "classpath:/public/" };
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//            .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
//    }
//
//    // beans
//
//    @Bean
//    public EmailValidator usernameValidator() {
//        return new EmailValidator();
//    }
//
//    @Bean
//    public PasswordMatchesValidator passwordMatchesValidator() {
//        return new PasswordMatchesValidator();
//    }
//
//}