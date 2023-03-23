package test.mert;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class GreetingResponse {

    private TestEnum testEnum;

    public GreetingResponse(TestEnum testEnum) {
        this.testEnum = testEnum;
    }

    @JsonProperty("testEnum")
    public TestEnum getTestEnum() {
        return testEnum;
    }

    @JsonProperty("testEnum")
    public void setTestEnum(TestEnum testEnum) {
        this.testEnum = testEnum;
    }
}
