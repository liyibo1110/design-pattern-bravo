package com.github.liyibo1110.pattern.builder.step.pattern;

import com.github.liyibo1110.pattern.builder.step.pattern.steps.BuildStep;
import com.github.liyibo1110.pattern.builder.step.pattern.steps.Step1;
import com.github.liyibo1110.pattern.builder.step.pattern.steps.Step2;
import com.github.liyibo1110.pattern.builder.step.pattern.steps.Step3;
import lombok.Getter;
import lombok.ToString;

/**
 * @author liyibo
 * @date 2025-10-23 13:57
 */
@Getter
@ToString
public class Product {
    private String part1;
    private String part2;
    private String part3;

    private Product() {}

    /**
     * 构建入口
     * @return
     */
    public static Step1 builder() {
        return new Builder();
    }

    private static class Builder implements Step1, Step2, Step3, BuildStep {
        private final Product product;

        private Builder() {
            this.product = new Product();
        }

        @Override
        public Step2 step1(String part1) {
            this.product.part1 = part1;
            return this;
        }

        @Override
        public Step3 step2(String part2) {
            this.product.part2 = part2;
            return this;
        }

        @Override
        public BuildStep step3(String part3) {
            this.product.part3 = part3;
            return this;
        }

        @Override
        public Product build() {
            return this.product;
        }
    }
}
