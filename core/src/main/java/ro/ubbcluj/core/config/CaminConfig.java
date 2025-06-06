package ro.ubbcluj.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ro.ubbcluj.core.repository", "ro.ubbcluj.core.service", "ro.ubbcluj.web.controller"})
public class CaminConfig {

}
