package com.github.liyibo1110.pattern.state.v2.state;

/**
 * @author liyibo
 * @date 2025-12-08 14:03
 */
public interface VendingState {
    void insertCoin();

    void selectGoods();

    void dispense();
}
