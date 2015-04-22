/*package com.tianyi.bph.service.system;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MybatisGeneratorUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {  
	            System.out.println("start generator ...");  
	            List<String> warnings = new ArrayList<String>();  
	            boolean overwrite = true;  
	            File configFile = new File(MybatisGeneratorUtil<span style="font-family: Arial, Helvetica, sans-serif;">.class.getResource("/generator.xml").getFile());</span>  
	            ConfigurationParser cp = new ConfigurationParser(warnings);  
	            Configuration config = cp.parseConfiguration(configFile);  
	            DefaultShellCallback callback = new DefaultShellCallback(overwrite);  
	            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);  
	            myBatisGenerator.generate(null);  
	            System.out.println("end generator!");  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } catch (XMLParserException e) {  
	            e.printStackTrace();  
	        } catch (InvalidConfigurationException e) {  
	            e.printStackTrace();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        }  
	    }  
*/