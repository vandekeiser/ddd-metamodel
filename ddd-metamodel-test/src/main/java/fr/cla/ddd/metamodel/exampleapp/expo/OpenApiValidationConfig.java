package fr.cla.ddd.metamodel.exampleapp.expo;

import com.atlassian.oai.validator.OpenApiInteractionValidator;
import com.atlassian.oai.validator.springmvc.OpenApiValidationFilter;
import com.atlassian.oai.validator.springmvc.OpenApiValidationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import java.io.IOException;

@Configuration
//@Profile("oa3-validate")
public class OpenApiValidationConfig implements WebMvcConfigurer {

    private final OpenApiValidationInterceptor validationInterceptor;

    @Autowired
    public OpenApiValidationConfig() throws IOException {
        this.validationInterceptor = new OpenApiValidationInterceptor(
//            OpenApiInteractionValidator.createFor("/oa3/openapi.yml").build()
            OpenApiInteractionValidator.createFor("/oa3/openapi.json").build()
        );
    }

    @Bean
    public Filter validationFilter() {
        return new OpenApiValidationFilter(
            true, // enable request validation
            true  // enable response validation
        );
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(validationInterceptor);
    }

}
