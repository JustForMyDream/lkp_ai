package com.lkp.entity;

/**
 *
 */
public enum OrderState {
    WAITE_TO_PAY("1", "待支付"),
    PAYED_WAITE_SET_PHOTOGRAPHER("2", "待分配摄影师"),
    WAITE_TO_UPLOADIMG("3", "待上传图片"),
    WAITE_TO_MAIL("4","待邮寄"),
    WAITE_TO_CONFIRM("5", "待用户确认"),
    FINISHED("6", "用户已确认"),
    CANCELED("7","已取消");

    /**
     * 订单状态
     */
    String state;

    /**
     * 状态描述
     */
    String des;

    private OrderState(String state, String des) {
        this.state = state;
        this.des = des;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
