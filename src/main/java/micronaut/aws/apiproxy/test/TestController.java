package micronaut.aws.apiproxy.test;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Error;
import io.micronaut.validation.Validated;

import javax.validation.Valid;
import javax.ws.rs.POST;

@Controller("/test")
@Validated
public class TestController {
    @Get("/ok")
    public String ok() {
        return "OK";
    }

    @Post("/validation")
    public TestBean validation(@Valid @Body TestBean body) {
        return body;
    }

    @Get("/exception")
    public void exception() {
        throw new CustomException();
    }

    @Post("/multipleConsumes")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    public TestBean multipleConsumes(@Body TestBean body) {
        return body;
    }

    @Post("/nonJsonConsumes")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public TestBean nonJsonConsumes(@Body TestBean body) {
        return body;
    }

}
