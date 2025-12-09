package com.github.liyibo1110.pattern.state;

import com.github.liyibo1110.pattern.state.v3.VendingMachine;

/**
 * @author liyibo
 * @date 2025-12-08 13:40
 */
public class Test {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(2);
        machine.selectGoods();  // UNSUPPORTED OPERATION：请先投币
        machine.insertCoin();   // 投币成功，请选择商品
        machine.dispense();     // UNSUPPORTED OPERATION：未选择商品，无法出货
        System.out.println("===================");
        machine.selectGoods();  // 选中XX商品
        machine.insertCoin();   // UNSUPPORTED OPERATION：已投币，请确认出货
        machine.dispense();     // 商品已出货，请及时取走
        System.out.println("===================");
        machine.insertCoin();   // 投币成功，请选择商品
        machine.selectGoods();  // 选中XX商品
        machine.dispense();     // 商品已出货，请及时取走
        System.out.println("===================");
        machine.insertCoin();   // UNSUPPORTED OPERATION：商品已售罄
        machine.selectGoods();  // UNSUPPORTED OPERATION：商品已售罄
        machine.dispense();     // UNSUPPORTED OPERATION：商品已售罄
    }
}
