package ychernenko.examples.rest.standalone;

import ychernenko.examples.rest.core.CoreContextConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CoreContextConfig.class)
public class StandaloneConfig {

}
