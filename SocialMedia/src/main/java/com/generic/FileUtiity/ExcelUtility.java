package com.generic.FileUtiity;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataExcel(String shetname,int rownum, int celnum) throws Throwable, IOException
	{
	 FileInputStream fss=new FileInputStream("./Data/Book2.xlsx");
     Workbook wh=WorkbookFactory.create(fss);
     String data=wh.getSheet(shetname).getRow(rownum).getCell(celnum).toString();
      wh.close();
      return data;
      
	}

}
