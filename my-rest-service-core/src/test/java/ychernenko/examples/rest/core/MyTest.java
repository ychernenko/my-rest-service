package ychernenko.examples.rest.core;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ychernenko.examples.rest.api.MyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        CoreContextConfig.class,
})
public class MyTest {

    @Inject
    MyService service;

    @Test
    public void test() {
        service.getBooksByTitle("test");
    }

}
