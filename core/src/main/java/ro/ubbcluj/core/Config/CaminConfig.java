package ro.ubbcluj.core.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ro.ubbcluj.core.Repository", "ro.ubbcluj.core.Service", "ro.ubbcluj.web.controller"})
public class CaminConfig {
}
