package com.yc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;




public class ConfigManager extends Properties{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static ConfigManager cm=new ConfigManager();
	private ConfigManager() {
		InputStream is=ConfigManager.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			this.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
	
				}
			}
		}
	}
	public static ConfigManager getInstance() {
		return cm;
	}
	
}
