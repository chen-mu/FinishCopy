package com.example.yuan.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yuan.Dao.EffectDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Effect;

public class EditXiao extends AppCompatActivity {
    private Button XiuGai,ShanChu;
    private ImageView fanhui;
    private EditText XiaoName,XiaoFeng,XiaoMian,XiaoHu,
            XiaoOne,XiaoTwo,XiaoThree,XiaoFour,XiaoFive,
            XiaoSum,XiaoDes;
//    private Spinner spinnerH,spinnerA,spinnerT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_xiao);
        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(EditXiao.this, ChangeXiao.class);
                startActivity(intent);
                finish();
            }
        });
        item();


        final Intent intent = getIntent();
        final String id = intent.getStringExtra("id");
        final EffectDAO effectDAO = new EffectDAO(EditXiao.this);
        final Effect effect = effectDAO.find(id);

        XiaoName.setText(effect.getEffect_name());
        XiaoFeng.setText(effect.getEffect_stytle());
        XiaoMian.setText(effect.getEffect_area());
        XiaoHu.setText(effect.getEffect_type());
        XiaoOne.setText(effect.getEffect_PriceOne());
        XiaoTwo.setText(effect.getEffect_PriceTwo());
        XiaoThree.setText(effect.getEffect_PriceThree());
        XiaoFour.setText(effect.getEffect_PriceFour());
        XiaoFive.setText(effect.getEffect_PriceFive());
        XiaoSum.setText(effect.getEffect_PriceSum());
        XiaoDes.setText(effect.getEffect_describe());

//        spinnerH = (Spinner)findViewById(R.id.spinnerT);
//        spinnerH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String resule = parent.getItemAtPosition(position).toString();
//                XiaoHu.setText(resule);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        spinnerA = (Spinner)findViewById(R.id.spinnerA);
//        spinnerA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String resule = parent.getItemAtPosition(position).toString();
//                XiaoMian.setText(resule);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        spinnerT = (Spinner)findViewById(R.id.spinnerF);
//        spinnerT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String resule = parent.getItemAtPosition(position).toString();
//                XiaoFeng.setText(resule);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        /**
         * 修改
         */
        XiuGai = (Button)findViewById(R.id.xiugai);
        XiuGai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item();
                String XiaoName1 = XiaoName.getText().toString();
                effect.setEffect_name(XiaoName1);

                String XiaoFeng1 = XiaoFeng.getText().toString();
                effect.setEffect_stytle(XiaoFeng1);

                String XiaoArea1 = XiaoMian.getText().toString();
                effect.setEffect_area(XiaoArea1);

                String XiaoHu1 = XiaoHu.getText().toString();
                effect.setEffect_type(XiaoHu1);

                String XiaoOne1  = XiaoOne.getText().toString();
                effect.setEffect_PriceOne(XiaoOne1);

                String XiaoTwo1  = XiaoTwo.getText().toString();
                effect.setEffect_PriceTwo(XiaoTwo1);



                String XiaoTheee1  = XiaoThree.getText().toString();
                effect.setEffect_PriceThree(XiaoTheee1);

                String XiaoFour1  = XiaoFour.getText().toString();
                effect.setEffect_PriceFour(XiaoFour1);

                String XiaoFive1  = XiaoFive.getText().toString();
                effect.setEffect_PriceFive(XiaoFive1);

                String XiaoSum1  = XiaoSum.getText().toString();
                effect.setEffect_PriceSum(XiaoSum1);

                String XiaoDes1  = XiaoDes.getText().toString();
                effect.setEffect_describe(XiaoDes1);


                effectDAO.update(effect);

                Toast.makeText(EditXiao.this,"修改成功",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent();
                intent1.setClass(EditXiao.this ,ChangeXiao.class);
                startActivity(intent1);
                finish();

            }
        });

        /**
         * 删除
         */
        ShanChu = (Button)findViewById(R.id.shanchu);
        ShanChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                effectDAO.deleteById(id);
                Toast.makeText(EditXiao.this,"删除成功",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent();
                intent1.setClass(EditXiao.this ,ChangeXiao.class);
                startActivity(intent1);
                finish();

            }
        });
    }

    private void item(){
        XiaoName = (EditText)findViewById(R.id.XiaoName);
        XiaoFeng=(EditText)findViewById(R.id.XiaoFeng);
        XiaoMian=(EditText)findViewById(R.id.XiaoMian);
        XiaoHu=(EditText)findViewById(R.id.XiaoHu);
        XiaoOne=(EditText)findViewById(R.id.XiaoOne);
        XiaoTwo=(EditText)findViewById(R.id.XiaoTwo);
        XiaoThree=(EditText)findViewById(R.id.XiaoThree);
        XiaoFour=(EditText)findViewById(R.id.XiaoFour);
        XiaoFive=(EditText)findViewById(R.id.XiaoFive);
        XiaoSum=(EditText)findViewById(R.id.XiaoSum);
        XiaoDes=(EditText)findViewById(R.id.XiaoDes);
    }
}
