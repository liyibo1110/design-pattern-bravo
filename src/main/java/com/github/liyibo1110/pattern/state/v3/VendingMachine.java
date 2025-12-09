package com.github.liyibo1110.pattern.state.v3;

import com.github.liyibo1110.pattern.state.v3.state.SoldOutState;
import com.github.liyibo1110.pattern.state.v3.state.VendingState;
import com.github.liyibo1110.pattern.state.v3.state.WaitToDispenseGoodsState;
import com.github.liyibo1110.pattern.state.v3.state.WaitToInsertCoinState;
import com.github.liyibo1110.pattern.state.v3.state.WaitToSelectGoodsState;

/**
 * 版本3：如果特定的State没有成员变量，则可以使用单例模式
 * @author liyibo
 * @date 2025-12-08 14:15
 */
public class VendingMachine {
    private int goodsNum;
    private VendingState currentState;

    public VendingMachine(int goodsNum) {
        this.goodsNum = goodsNum;
        if(this.goodsNum <= 0)
            this.currentState = SoldOutState.instance();
        else
            this.currentState = WaitToInsertCoinState.instance();
    }

    public void insertCoin() {
        this.currentState.insertCoin(this);
    }

    public void selectGoods() {
        this.currentState.selectGoods(this);
    }

    public void dispense() {
        this.currentState.dispense(this);
    }

    public void releaseGood() {
        goodsNum -= 1;
    }

    /**
     * 切换状态（自己负责）
     */
    public void nextState() {
        if(this.currentState instanceof WaitToInsertCoinState)
            this.currentState = WaitToSelectGoodsState.instance();
        else if(this.currentState instanceof WaitToSelectGoodsState)
            this.currentState = WaitToDispenseGoodsState.instance();
        else if(this.currentState instanceof WaitToDispenseGoodsState) {
            if(this.goodsNum <= 0)
                this.currentState = SoldOutState.instance();
            else
                this.currentState = WaitToInsertCoinState.instance();
        }else {
            throw new RuntimeException("unknown state...");
        }
    }
}
