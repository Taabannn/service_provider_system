package ir.maktab58.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Taban Soleymani
 */
@ComponentScan(basePackages = "ir.maktab58")
@Import({DataBaseConfig.class})
@Configuration
public class SpringConfig {
}
