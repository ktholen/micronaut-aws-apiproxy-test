package micronaut.aws.apiproxy.test;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.validation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Introspected
public class TestBean {
    @NotNull
    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
