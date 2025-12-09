package com.github.liyibo1110.pattern.state.v1;

import com.github.liyibo1110.pattern.state.v1.state.VendingState;

/**
 * 版本1：由各个State自己负责切换状态
 * @author liyibo
 * @date 2025-12-08 13:56
 */
public class VendingMachine {
    /** 商品数量 */
    private int goodsNum;

    /** 当前状态 */
    private VendingState currentState;

    public VendingMachine(int goodsNum) {
        this.goodsNum = goodsNum;
        if(this.goodsNum <= 0)
            this.currentState = null;
        else
            this.currentState = null;
    }

    public void insertCoin() {
        this.currentState.insertCoin();
    }

    public void selectGoods() {
        this.currentState.selectGoods();
    }

    public void dispense() {
        this.currentState.dispense();
    }

    public int releaseGood() {
        // 返回剩余数量
        return goodsNum -= 1;
    }

    public void changeState(VendingState newState) {
        this.currentState = newState;
    }
}
