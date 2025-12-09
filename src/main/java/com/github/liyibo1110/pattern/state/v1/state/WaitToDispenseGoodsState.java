package com.github.liyibo1110.pattern.state.v1.state;

import com.github.liyibo1110.pattern.state.v1.VendingMachine;

/**
 * @author liyibo
 * @date 2025-12-08 14:01
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
        int leftGoodsNum = this.vendingMachine.releaseGood();
        if(leftGoodsNum <= 0)
            this.vendingMachine.changeState(new SoldOutState(this.vendingMachine));
        else
            this.vendingMachine.changeState(new WaitToInsertCoinState(this.vendingMachine));
        System.out.println("商品已出货，请及时取走");
    }
}
