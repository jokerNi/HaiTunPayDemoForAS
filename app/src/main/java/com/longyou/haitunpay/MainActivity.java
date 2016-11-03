package com.longyou.haitunpay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.longyou.haitunsdk.HaiTunPay;
import com.longyou.haitunsdk.model.PaymentBean;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText priceEdit, desEdit;
    private Button wechatPayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceEdit = (EditText) findViewById(R.id.edit_price);
        desEdit = (EditText) findViewById(R.id.edit_des);
        wechatPayBtn = (Button) findViewById(R.id.btn_pay_wechat);
        wechatPayBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (TextUtils.isEmpty(priceEdit.getText())) {
            Toast.makeText(this, "请输入金额", Toast.LENGTH_SHORT).show();
            return;
        }
        double price = Double.valueOf(priceEdit.getText().toString());

        String orderId = "HT" + System.currentTimeMillis();
        PaymentBean paymentBean = new PaymentBean(orderId/**商户自己的唯一订单号*/,
                price/**支付金额，单位:元*/,
                TextUtils.isEmpty(desEdit.getText().toString()) ? "测试商品" : desEdit.getText().toString()/**订单描述*/,
                "http://www.haitunpay.com/"/**服务端回调地址*/);
        //paymentBean.setSjt_UserName("");// 备用参数，可用于设置渠道等其他
        //paymentBean.setSjt_Paytype("");// 备用参数
        HaiTunPay.getInstance().openWeChatPay(this, paymentBean);
    }
}
