package test.mert;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

public enum TestEnum {

    VALUE_1("Value 1");

    private String value;

    TestEnum(String value) {
        this.value = value;
    }

    public static TestEnum fromString(String s) {
        for (TestEnum b : TestEnum.values()) {
            if (Objects.equals(Objects.toString(b.value), s)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected string value '" + s + "'");
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static TestEnum fromValue(String value) {
        for (TestEnum b : TestEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
