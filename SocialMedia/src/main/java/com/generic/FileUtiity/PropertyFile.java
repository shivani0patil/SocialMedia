package com.generic.FileUtiity;

import java.io.*;
import java.util.Properties;

public class PropertyFile  
{
	
	public String getDataProperty(String Key) throws IOException
	{
		FileInputStream fs=new FileInputStream("./Data/common.properties");
		
        Properties op=new Properties();
        op.load(fs);
        String data =op.getProperty(Key);
        return data;
	}


}
