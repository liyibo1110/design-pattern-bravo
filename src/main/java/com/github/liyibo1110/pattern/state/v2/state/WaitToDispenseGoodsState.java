package com.github.liyibo1110.pattern.state.v2.state;

import com.github.liyibo1110.pattern.state.v2.VendingMachine;

/**
 * @author liyibo
 * @date 2025-12-08 14:04
 */
public class WaitToDispenseGoodsState implements VendingState {
    private final VendingMachine vendingMachine;

    public WaitToDispenseGoodsState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("UNSUPPORTED OPERATION：已投币，请确认出货");
    }

    @Override
    public void selectGoods() {
        System.out.println("UNSUPPORTED OPERATION：已选择商品，请确认出货");
    }

    @Override
    public void dispense() {
        this.vendingMachine.releaseGood();
        // 由VendingMachine自己来负责切换
        this.vendingMachine.nextState();
        System.out.println("商品已出货，请及时取走");
    }
}
