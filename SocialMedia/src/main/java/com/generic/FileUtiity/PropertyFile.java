package com.generic.FileUtiity;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {
	
	public String getDataProperty(String Key) throws Throwable
	{
		FileInputStream fs=new FileInputStream("./Data/common.properties");
        Properties op=new Properties();
        op.load(fs);
        String data =op.getProperty(Key);
        return data;
	}

}
