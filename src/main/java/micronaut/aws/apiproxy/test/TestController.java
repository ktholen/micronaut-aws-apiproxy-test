package micronaut.aws.apiproxy.test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.cookie.Cookie;
import io.micronaut.validation.Validated;

import javax.validation.Valid;
import java.util.Set;

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

    @Get("/returnCookie")
    public HttpResponse returnCookie() {
        return HttpResponse.ok("OK").cookie(Cookie.of("test", "cookieValue"));
    }

    @Get("/checkCookies")
    public Set<Cookie> checkCookies(HttpRequest httpRequest) {
        return httpRequest.getCookies().getAll();
    }

}
