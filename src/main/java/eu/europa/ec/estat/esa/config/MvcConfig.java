//package eu.europa.ec.estat.esa.config;
//
///**
// * @author Gorazd.Bertoncelj
// *
// */
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class MvcConfig implements WebMvcConfigurer {
//	@Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("/webjars/")
//                .resourceChain(false);
//        registry.setOrder(1);
//    }
//
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/index").setViewName("index");
//		registry.addViewController("/").setViewName("index");
//		registry.addViewController("/chapters").setViewName("chapters");
//		registry.addViewController("/chapter").setViewName("chapter");
//		registry.addViewController("/login").setViewName("login");
//	}
//}
