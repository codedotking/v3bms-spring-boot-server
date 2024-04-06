package fun.huala.v3bms.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * web mvc 配置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${web.upload-path}")
    private String uploadPath;

    @Value("${web.access-prefix}")
    private String accessPrefix;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(String.format("/%s/**", this.accessPrefix)).
                addResourceLocations("file:" + uploadPath);
    }
    /**
     * 跨域配置
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(false)
                .allowedHeaders("*")
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
