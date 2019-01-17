package org.dc.util;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Constants {

	private static Logger logger = Logger.getLogger(Constants.class);
	public static String PARAM_ACTION = "action" ;
	public static String WEB_IP = "WebIP";
	
	public static Properties p = new Properties();
	static {
		try {
			String proFilePath = System.getProperty("user.home") + "/constants.properties"; 
			File proFile = new File(proFilePath);
			InputStream in;
			if(proFile.exists()) {
				in = new BufferedInputStream(new FileInputStream(proFilePath));
			}else {
				in = Constants.class.getClassLoader().getResourceAsStream("constants.properties");
			}
			p.load(in);
			in.close();
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}  
	}

	public static String get(String key) {
		return p.getProperty(key, "");
	}
	
	public static String get(String key,String defaultValue) {
		return p.getProperty(key, defaultValue);
	}
	
	public static void set(String key, String value){
		try{
			Writer w=new FileWriter(Constants.class.getResource("").getFile());
			p.setProperty(key, value);
			p.store(w, key);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}

	}
}
