package com.github.liyibo1110.pattern.builder.step.demo;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 批量操作通用结果
 * @author liyibo
 * @date 2025-10-23 14:14
 */
public class BatchResult<T> {

    private int totalCount;
    private int successCount;
    private int failureCount;
    private List<T> successItems;

    /** 部分成功时的错误码 */
    private Integer failureCode;
    /** 部分成功时的错误提示 */
    private String failureReason;

    private BatchResult() {}

    private BatchResult(int totalCount, int successCount,
                        int failureCount, List<T> successItems,
                        Integer failureCode, String failureReason) {
        this.totalCount = totalCount;
        this.successCount = successCount;
        this.failureCount = failureCount;
        this.successItems = successItems;
        this.failureCode = failureCode;
        this.failureReason = failureReason;
    }

    public boolean isAllCompleted() {
        return totalCount == successCount;
    }

    /**
     * 数据类型转换
     * @param converter
     * @return
     * @param <R>
     */
    public <R> BatchResult<R> convert(Function<T, R> converter) {
        return new BatchResult<>(
            totalCount,
            successCount,
            failureCount,
            successItems == null ? null : successItems.stream().map(converter).collect(Collectors.toList()),
            failureCode,
            failureReason
        );
    }

    /** 以下为builder相关代码 */

    public static <T> InterruptedOrFinishedStep<T> builder() {
        return new Steps<>();
    }

    /**
     * 构建错误还是正常的字段
     * @param <T>
     */
    public interface InterruptedOrFinishedStep<T> {
        ReasonStep<T> interrupted();
        FinishedResultStep<T> finished();
    }

    /**
     * 构建错误时需要的字段
     * @param <T>
     */
    public interface ReasonStep<T> {
        InterruptedResultStep<T> reason(int code, String reason);
        InterruptedResultStep<T> reason(String reason);
    }

    /**
     * 构建总条数目和成功数（构建过程调用了interrupted会返回这个实现）
     * @param <T>
     */
    public interface InterruptedResultStep<T> {
        ResultStep<T> result(int totalCount, int successCount);
        ResultStep<T> result(int totalCount, List<T> successItems);
    }

    /**
     * 构建总条数目和成功数（构建过程调用了finished会返回这个实现）
     * @param <T>
     */
    public interface FinishedResultStep<T> {
        ResultStep<T> result(int totalCount, int successCount);
        ResultStep<T> result(int totalCount, List<T> successItems);
    }

    /**
     * 最终生成实例
     * @param <T>
     */
    public interface ResultStep<T> {
        BatchResult<T> build();
    }

    private static class Steps<T> implements InterruptedOrFinishedStep<T>, ReasonStep<T>, InterruptedResultStep<T>, FinishedResultStep<T>, ResultStep {
        private final BatchResult<T> batchResult = new BatchResult<>();

        @Override
        public ReasonStep<T> interrupted() {
            return this;
        }

        @Override
        public FinishedResultStep<T> finished() {
            return this;
        }

        @Override
        public InterruptedResultStep<T> reason(int code, String reason) {
            this.batchResult.failureCode = code;
            this.batchResult.failureReason = reason;
            return this;
        }

        @Override
        public InterruptedResultStep<T> reason(String reason) {
            this.batchResult.failureReason = reason;
            return this;
        }

        @Override
        public ResultStep<T> result(int totalCount, int successCount) {
            this.batchResult.totalCount = totalCount;
            this.batchResult.successCount = successCount;
            this.batchResult.failureCount = totalCount - successCount;
            return this;
        }

        @Override
        public ResultStep<T> result(int totalCount, List<T> successItems) {
            this.batchResult.totalCount = totalCount;
            this.batchResult.successItems = successItems;
            this.batchResult.successCount = successItems.size();
            this.batchResult.failureCount = totalCount - successItems.size();
            return this;
        }

        @Override
        public BatchResult build() {
            return this.batchResult;
        }
    }
}
