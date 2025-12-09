package com.github.liyibo1110.pattern.state.v1.state;

/**
 * @author liyibo
 * @date 2025-12-08 13:54
 */
public interface VendingState {
    void insertCoin();

    void selectGoods();

    void dispense();
}
