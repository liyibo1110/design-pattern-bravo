package com.github.liyibo1110.pattern.state.v3.state;

import com.github.liyibo1110.pattern.state.v3.VendingMachine;

/**
 * 版本3，方法里面增加了Machine参数
 * @author liyibo
 * @date 2025-12-08 14:15
 */
public interface VendingState {
    void insertCoin(VendingMachine machine);

    void selectGoods(VendingMachine machine);

    void dispense(VendingMachine machine);
}
