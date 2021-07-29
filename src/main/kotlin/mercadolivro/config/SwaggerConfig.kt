package mercadolivro.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2 //Spring ativa o Swagger pra gente
class SwaggerConfig {
    /**
     * Spring vai gerenciar a fun api
     */
    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("mercadolivro.controller"))
        .paths(PathSelectors.any())
        .build()

    companion object {
        const val basePackage = "mercadolivro.controller"
    }
}