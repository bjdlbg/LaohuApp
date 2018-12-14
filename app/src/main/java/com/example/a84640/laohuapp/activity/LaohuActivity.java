package com.example.a84640.laohuapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a84640.laohuapp.R;

/**
 * 老胡试验app
 * create pdf
 * @author jeremy
 */
public class LaohuActivity extends AppCompatActivity {

    private Button mButton,mButton2,mButton3,mButton4,mButton5,mButton6;

    /**
     * 创建菜单
     * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laohu);

        //声明控件
        mButton=(Button)findViewById(R.id.button);
        mButton2=(Button)findViewById(R.id.button2);
        mButton3=(Button)findViewById(R.id.button3);
        mButton4=(Button)findViewById(R.id.button4);
        mButton5=(Button)findViewById(R.id.button5);
        mButton6=(Button)findViewById(R.id.button6);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LinActivity.class);
                startActivity(intent);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButton3.setVisibility(View.VISIBLE);
                mButton2.setVisibility(View.GONE);
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButton4.setVisibility(View.VISIBLE);
                mButton3.setVisibility(View.GONE);
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButton5.setVisibility(View.VISIBLE);
                mButton4.setVisibility(View.GONE);
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButton6.setVisibility(View.VISIBLE);
                mButton5.setVisibility(View.GONE);
            }
        });
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButton2.setVisibility(View.VISIBLE);
                mButton6.setVisibility(View.GONE);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.create_pdf:
                showPDFactivity();
                return true;
            case R.id.other:
                showToast();
                //androidPDFactivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    private void androidPDFactivity() {
//        Intent intent=new Intent(this,RawPDFActivity.class);
//        startActivity(intent);
//    }

    private void showPDFactivity() {
        Intent intent=new Intent(this,PDFActivity.class);
        startActivity(intent);
    }

    /**
     * 出现一个字幕
     * */
    private void showToast() {
        Toast.makeText(getApplicationContext(),"this button no action",Toast.LENGTH_SHORT).show();
    }


}
