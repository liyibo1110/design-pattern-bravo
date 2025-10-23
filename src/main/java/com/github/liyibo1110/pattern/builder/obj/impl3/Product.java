package com.github.liyibo1110.pattern.builder.obj.impl3;

import lombok.Getter;
import lombok.ToString;

/**
 * @author liyibo
 * @date 2025-10-23 11:06
 */
@Getter
@ToString
public class Product {
    private final String part1;
    private final String part2;
    private final String part3;

    private Product(Builder builder) {
        this.part1 = builder.part1;
        this.part2 = builder.part2;
        this.part3 = builder.part3;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String part1;
        private String part2;
        private String part3;

        private Builder() {}

        public Builder step1(String part1) {
            this.part1 = part1;
            return this;
        }

        public Builder step2(String part2) {
            this.part2 = part2;
            return this;
        }

        public Builder step3(String part3) {
            this.part3 = part3;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
