package micronaut.aws.apiproxy.test;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {CustomException.class, ExceptionHandler.class})
public class CustomExceptionHandler implements ExceptionHandler<CustomException, HttpResponse> {
    @Override
    public HttpResponse handle(HttpRequest request, CustomException exception) {
        return HttpResponse.ok("Exception Handled");
    }
}
