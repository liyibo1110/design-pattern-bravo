package com.github.liyibo1110.pattern.state.v2;

import com.github.liyibo1110.pattern.state.v2.state.SoldOutState;
import com.github.liyibo1110.pattern.state.v2.state.VendingState;
import com.github.liyibo1110.pattern.state.v2.state.WaitToDispenseGoodsState;
import com.github.liyibo1110.pattern.state.v2.state.WaitToInsertCoinState;
import com.github.liyibo1110.pattern.state.v2.state.WaitToSelectGoodsState;

/**
 * 版本2：由VendingMachine负责切换状态
 * @author liyibo
 * @date 2025-12-08 14:02
 */
public class VendingMachine {
    private int goodsNum;
    private VendingState currentState;

    public VendingMachine(int goodsNum) {
        this.goodsNum = goodsNum;
        if(this.goodsNum <= 0)
            this.currentState = new SoldOutState(this);
        else
            this.currentState = new WaitToInsertCoinState(this);
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

    public void releaseGood() {
        goodsNum -= 1;
    }

    /**
     * 切换状态（自己负责）
     */
    public void nextState() {
        if(this.currentState instanceof WaitToInsertCoinState)
            this.currentState = new WaitToSelectGoodsState(this);
        else if(this.currentState instanceof WaitToSelectGoodsState)
            this.currentState = new WaitToDispenseGoodsState(this);
        else if(this.currentState instanceof WaitToDispenseGoodsState) {
            if(this.goodsNum <= 0)
                this.currentState = new SoldOutState(this);
            else
                this.currentState = new WaitToInsertCoinState(this);
        }else {
            throw new RuntimeException("unknown state...");
        }
    }
}
