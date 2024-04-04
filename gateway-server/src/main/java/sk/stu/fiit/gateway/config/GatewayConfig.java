package sk.stu.fiit.gateway.config;

import sk.stu.fiit.gateway.filter.AuthFilter;
import sk.stu.fiit.gateway.filter.PostGlobalFilter;
import sk.stu.fiit.gateway.filter.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.WebFilter;

@Configuration
public class GatewayConfig {

    @Autowired
    RequestFilter requestFilter;

    @Autowired
    AuthFilter authFilter;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        // adding 2 rotes to first microservice as we need to log request body if method is POST
        return builder.routes()
                .route("reservation-service", r -> r.path("/reservation")
                        .and().method("POST")
                        .filters(f -> f.filters(authFilter))
//                        .and().readBody(Student.class, s -> true).filters(f -> f.filters(requestFilter, authFilter))
                        .uri("http://localhost:8081"))
                .route("reservation-service", r -> r.path("/reservation")
                        .and().method("GET")
                        .filters(f -> f.filters(authFilter))
//                        .filters(f-> f.filters(authFilter))
                        .uri("http://localhost:8081"))
                .route("login", r -> r.path("/login")
                        .and().method("POST")
//                        .and().readBody(Company.class, s -> true).filters(f -> f.filters(requestFilter, authFilter))
                        .uri("http://localhost:8082"))
                .route("login", r -> r.path("/login")
                        .and().method("GET")
//                        .and().readBody(Company.class, s -> true).filters(f -> f.filters(requestFilter, authFilter))
                        .uri("http://localhost:8082"))
                .route("register", r -> r.path("/register")
                        .and().method("POST")
//
                        .uri("http://localhost:8083"))
//                .route("auth-server",r -> r.path("/login")
//                        .uri("http://localhost:8088"))
                .build();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebFilter responseFilter(){
        return new PostGlobalFilter();
    }

}
