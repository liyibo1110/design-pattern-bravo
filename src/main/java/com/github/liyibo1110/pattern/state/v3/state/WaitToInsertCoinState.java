package com.github.liyibo1110.pattern.state.v3.state;

import com.github.liyibo1110.pattern.state.v3.VendingMachine;

/**
 * @author liyibo
 * @date 2025-12-08 14:05
 */
public class WaitToInsertCoinState implements VendingState {
    private static final VendingState INSTANCE = new WaitToInsertCoinState();

    public static VendingState instance() {
        return INSTANCE;
    }

    private WaitToInsertCoinState() {

    }

    @Override
    public void insertCoin(VendingMachine machine) {
        // 由VendingMachine自己来负责切换
        machine.nextState();
        System.out.println("投币成功，请选择商品");
    }

    @Override
    public void selectGoods(VendingMachine machine) {
        System.out.println("UNSUPPORTED OPERATION：请先投币");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("UNSUPPORTED OPERATION：请先投币");
    }
}
