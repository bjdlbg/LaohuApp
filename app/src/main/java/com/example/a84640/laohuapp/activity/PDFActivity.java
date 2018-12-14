package com.example.a84640.laohuapp.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a84640.laohuapp.R;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Activity for creating PDF
 * @author: J.xiang
 * @date: On 2018/12/11
 */

public class PDFActivity extends AppCompatActivity {

    public static String LOCAL_ADDRESS;


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        //文件夹地址
        LOCAL_ADDRESS= Environment.getExternalStorageDirectory().toString();
        //控件
        Button mButton=findViewById(R.id.btn_pdf);
        final EditText mEditText=findViewById(R.id.edit_pdf);
        //按钮点击事件
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().equals("")){
                    showMyToast("格式不规范");
                }else{
                    if (createPDF(LOCAL_ADDRESS+"/"+mEditText.getText().toString().trim()+".pdf")){
                        showMyToast("生成pdf成功");
                    }else{
                        showMyToast("生成pdf错误！！");
                    }

                }
            }
        });

    }

    /**
     * 对中文支持不好
     * */
    public boolean createPDF(String s){
        String h1="这是第一段话的标题";
        String h2="this is the title for the second p";
        Document document = new Document();
        // 文件保存地址，保存在外部存储（文件名也为s）
        try {
//            int permission = ActivityCompat.checkSelfPermission(getApplicationContext(),
//                    "android.permission.WRITE_EXTERNAL_STORAGE");
            PdfWriter.getInstance(document, new FileOutputStream(s));

            // 打开文件
            document.open();
            // Document Settings
            document.setPageSize(PageSize.A4);
            document.addCreationDate();
            //设置标题
            document.add(new Paragraph(s));
            //打印中文
            document.add(new Paragraph(h1));
            document.add(new Paragraph(h2));
            document.addAuthor("jixiang");
            document.addCreator("Pratik Butani");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        //关闭文件
        document.close();

        return true;
    }
    public void showMyToast(String s){
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }

}
