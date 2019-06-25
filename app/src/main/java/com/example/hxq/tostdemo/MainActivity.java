package com.example.hxq.tostdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnClickListener {
    Button btn1,btn2,btn3;
    NotificationManager notiManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        //得到服务
        notiManager=(NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn1){
            Builder  builder=new Notification.Builder(this);
            //设置图标
            builder.setSmallIcon(R.drawable.ic_launcher);
            //设置状态来提示
            builder.setTicker("紧急通知！");
            //设置主题
            builder.setContentTitle("通知栏");
            //设置通知内容
            builder.setContentText("我是来自远方的孤独的狼");
            //设置显示时间
            builder.setWhen(System.currentTimeMillis());

            //预制意图(预设好，等到某个时间点，再去执行该意图)
            PendingIntent pendingintent=PendingIntent.getActivity(this, 0, new Intent(this,MainActivity.class),0);
            //点击通知时，执行意图(启动MainAcitviyt)
            builder.setContentIntent(pendingintent);
//          //设置点击后取消通知
            builder.setAutoCancel(true);
            //取出通知对象
            Notification notification =builder.build();//4.1以上
            //Notification notification=builder.getNotification();//4.1之前

            //将notification添加到管理中
            notiManager.notify(1, notification);
        }if(v.getId()==R.id.btn2){
            notiManager.cancel(1);
        }if (v.getId()==R.id.btn3){
            Toast toast=Toast.makeText(this,"Tost",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
