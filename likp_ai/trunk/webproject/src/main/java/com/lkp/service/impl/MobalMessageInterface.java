package com.lkp.service.impl;

/**
 *
 */
public interface MobalMessageInterface {
    /**
     * 待办事项通知
    * {{first.DATA}}
    * 待办事项：{{keyword1.DATA}}
    * 提醒时间：{{keyword2.DATA}}
    * {{remark.DATA}}
    * */
    String WAIT_TO_DO = "0KEHfsgb8_mvhEJmaFpUICt_jlnZi3HPYFXnfzQ_59o";
    /**
     *服务完成通知
     *{{first.DATA}}
     * 订单号：{{keyword1.DATA}}
     * 总费用：{{keyword2.DATA}}
     * 支付方式：{{keyword3.DATA}}
     * {{remark.DATA}}
    */
    String SERVICE_FINISH = "E2-CMsxe2XAUFa172xXLIM2ovrYBZZybMNfvX6wWG2o";
    /**
     * 到账通知
     * {{first.DATA}}
     * 到账金额：{{keyword1.DATA}}
     * 到账时间：{{keyword2.DATA}}
     * 手续费：{{keyword3.DATA}}
     * 到账类型：{{keyword4.DATA}}
     * {{remark.DATA}}
     */
    String INTO_ACCOUNT = "JQW-8HzWFDckGmk2VopMtnWcnZ41mjskKCQFpj4wyTo";
    /**
     * 退款通知
     * {{first.DATA}}
     * 订单号：{{keyword1.DATA}}
     * 退款金额：{{keyword2.DATA}}
     * {{remark.DATA}}
     */
    String QUITE_FEE = "ZSkjbK4U-IkYfrzm-KZuvGITcRoPJFeAWhMziPqrZo8";
    /**
     *订单取消通知
     * {{first.DATA}}
     * 订单编号：{{keyword1.DATA}}
     * 取消原因：{{keyword2.DATA}}
     * {{remark.DATA}}
     */
    String CANCEL_ORDER="dBpUhWXrF2K_6bop9g09eMFx9eUK6j6-pEZGvzBwV7k";
    /**
     * 订单处理进度通知
     * {{first.DATA}}
     * 订单编号：{{keyword1.DATA}}
     * 订单金额：{{keyword2.DATA}}
     * 订单状态：{{keyword3.DATA}}
     * 下单时间：{{keyword4.DATA}}
     * {{remark.DATA}}
     */
    String ORDER_PROCESS="gQqU_zAXOvjO49T2hS3Xu2TIr3A3rW4Q2G945hjtvEg";
    /**
     * 退款成功通知
     * {{first.DATA}}
     * 商品名称：{{keyword1.DATA}}
     * 数量：{{keyword2.DATA}}
     * 金额：{{keyword3.DATA}}
     * 退款情况：{{keyword4.DATA}}
     * {{remark.DATA}}
     */
    String QUITE_FEE_SUCCESS="l5o5epPsJ9pMX3mgBJcjvGOgvf698fKXwQCyaH0TA1o";
    /**
     * 待办工作通知
     * {{first.DATA}}
     * 待办工作：{{work.DATA}}
     * {{remark.DATA}}
     */
    String WAIT_TO_HANDLE="mcdsALBbZOR9if6z5uhN9RPiis076sTlbdPM-ME5gHg";
    /**
     * 派单提醒
     * {{first.DATA}}
     * 订单编号：{{keyword1.DATA}}
     * 派发时间：{{keyword2.DATA}}
     * {{remark.DATA}}
     */
    String GIVE_AWAY_ORDER="mtbxLx57Dnyj081Xk42WUQaKi8ZYFayhLHNlIgi32wg";
    /**
     * 订单提交成功通知
     *{{first.DATA}}
     * 产品名称：{{keyword1.DATA}}
     * 购买数量：{{keyword2.DATA}}
     * 订单金额：{{keyword3.DATA}}
     * 下单时间：{{keyword4.DATA}}
     * 快递方式：{{keyword5.DATA}}
     * {{remark.DATA}}
     */
    String CREATE_ORDER_SUCCESS="n-FedV9tmQ0jxjkBPSdsDnxGZkcKOrezlyVYwvS_xXc";
    /**
     * 到账提醒
     * {{first.DATA}}
     * 到账金额：{{keyword1.DATA}}
     * 到账时间：{{keyword2.DATA}}
     * 手续费：{{keyword3.DATA}}
     * 到账类型：{{keyword4.DATA}}
     * {{remark.DATA}}
     */
    String GOT_FEE ="oHOj24ewl4-39KhVTikGLUKG9oGmmJrRwtqSJVr6WgE";
    /**
     * 拍摄订单提醒
     * {{first.DATA}}
     * 拍摄产品：{{keyword1.DATA}}
     * 拍摄时间：{{keyword2.DATA}}
     * 订单总额：{{keyword3.DATA}}
     * 订单状态：{{keyword4.DATA}}
     * {{remark.DATA}}
     */
    String PHOTOORDER_RECOMAIND="ogm201Zrxw9ZsOBhuBd_dmz0e9cH9bWdhhU0EfNq-W0";
    /**
     * 新预约通知
     * {{first.DATA}}
     * 顾客姓名：{{keyword1.DATA}}
     * 顾客电话：{{keyword2.DATA}}
     * 预约项目：{{keyword3.DATA}}
     * 预约时间：{{keyword4.DATA}}
     * 其他信息：{{keyword5.DATA}}
     * {{remark.DATA}}
     */
    String NEW_ORDER_RECOMAIND="wRPiI9nJAwCeuliPErwgqpnQuXQDhSRHKWq0obwYzOU";

}
