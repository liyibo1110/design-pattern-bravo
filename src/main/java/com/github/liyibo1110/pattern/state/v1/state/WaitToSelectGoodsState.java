package com.github.liyibo1110.pattern.state.v1.state;

import com.github.liyibo1110.pattern.state.v1.VendingMachine;

/**
 * @author liyibo
 * @date 2025-12-08 14:00
 */
public class WaitToSelectGoodsState implements VendingState {
    private final VendingMachine vendingMachine;

    public WaitToSelectGoodsState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("UNSUPPORTED OPERATION：已投币，请选择商品");
    }

    @Override
    public void selectGoods() {
        this.vendingMachine.changeState(new WaitToDispenseGoodsState(this.vendingMachine));
        System.out.println("选中XX商品");
    }

    @Override
    public void dispense() {
        System.out.println("UNSUPPORTED OPERATION：未选择商品，无法出货");
    }
}
