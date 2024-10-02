package vn.vds.huylq33.config;

import static org.springframework.http.MediaType.TEXT_HTML;
import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.web.servlet.function.ServerResponse.ok;

import java.util.HashMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("vn.vds.huylq33")
public class WebApplicationContextConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver internalViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*")
            .allowedOrigins("*")
            .allowedMethods("GET");
    }

    @Bean
    public RouterFunction<ServerResponse> customRouter() {
        return route().
            GET(
                "/welcome-via-router",
                serverRequest -> ok().contentType(TEXT_HTML)
                    .render("welcome", new HashMap<String, String>() {
                            {
                                put("greeting", "Welcome to Web Store! (Via Router)");
                                put("tagline", "The one and only amazing web store");
                            }
                        }
                    )
            )
            .build();
    }
}
