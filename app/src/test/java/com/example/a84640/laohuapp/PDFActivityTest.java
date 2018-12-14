package com.example.a84640.laohuapp;

import com.example.a84640.laohuapp.activity.PDFActivity;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: J.xiang
 * @date: On 2018/12/11
 */
public class PDFActivityTest {

    public PDFActivity mPDFActivity=new PDFActivity();
    @Test
    public void createPDF() {
        Boolean outputValue=true;
        Assert.assertEquals(mPDFActivity.createPDF("C:\\Users\\84640\\Desktop\\中文.pdf"),outputValue);
    }
}