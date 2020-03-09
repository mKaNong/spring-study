package com.ahdy.xem.common.enums;

import lombok.Data;

@Data
public class Pizza {

    private PizzaStatus status;

    public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }

    /**
     * 由于枚举类型确保JVM中仅存在一个常量实例，因此我们可以安全地使用“ ==”运算符比较两个变量
     * 此外，“==”运算符可提供编译时和运行时的安全性。
     */
    public boolean isDeliverable() {
        if(getStatus() == PizzaStatus.READY) {
            return true;
        }
        return false;
    }

    /**
     * 在 switch 语句中使用枚举类型
     */
    public int getDeliveryTimeInDays() {
        switch (status) {
            case READY: return 5;
            case ORDERED: return 3;
            case DELIVERED: return 0;
        }
        return 0;
    }
}
