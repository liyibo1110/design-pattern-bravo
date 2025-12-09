package com.github.liyibo1110.pattern.state.v3.state;

import com.github.liyibo1110.pattern.state.v3.VendingMachine;

/**
 * @author liyibo
 * @date 2025-12-08 14:19
 */
public class WaitToDispenseGoodsState implements VendingState {
    private static final VendingState INSTANCE = new WaitToDispenseGoodsState();

    public static VendingState instance() {
        return INSTANCE;
    }

    private WaitToDispenseGoodsState() {

    }

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("UNSUPPORTED OPERATION：已投币，请确认出货");
    }

    @Override
    public void selectGoods(VendingMachine machine) {
        System.out.println("UNSUPPORTED OPERATION：已选择商品，请确认出货");
    }

    @Override
    public void dispense(VendingMachine machine) {
        machine.releaseGood();
        // 由VendingMachine自己来负责切换
        machine.nextState();
        System.out.println("商品已出货，请及时取走");
    }
}
