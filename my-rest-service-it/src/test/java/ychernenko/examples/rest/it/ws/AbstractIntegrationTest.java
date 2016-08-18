package ychernenko.examples.rest.it.ws;

import static ychernenko.examples.rest.it.ws.AbstractIntegrationTest.*;

import java.util.Collections;

import ychernenko.examples.rest.api.MyService;
import ychernenko.examples.rest.standalone.StandaloneConfig;
import com.fasterxml.jackson.jaxrs.cfg.Annotations;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        StandaloneConfig.class,
})
@WebIntegrationTest("server.port=" + SERVER_PORT)
public abstract class AbstractIntegrationTest {

    public static final String SERVER_HOST = "localhost";
    public static final String SERVER_PORT = "9000";

    private static MyService SERVICE = JAXRSClientFactory.create(
            String.format("http://%s:%s", SERVER_HOST, SERVER_PORT),
            MyService.class,
            Collections.singletonList(new JacksonJsonProvider(Annotations.JAXB)),
            Collections.<Feature>singletonList(new LoggingFeature()),
            null
    );

    protected static MyService getService() {
        return SERVICE;
    }

}
