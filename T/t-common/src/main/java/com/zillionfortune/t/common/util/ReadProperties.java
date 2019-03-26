package com.zillionfortune.t.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
 
/**
 * ClassName: ReadProperties <br/>
 * Function: 读取Properties文件的工具类. <br/>
 * Date: 2017年1月9日 下午3:33:00 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class ReadProperties {
 
    public static void main(String[] args) throws IOException {
 
        Map<String,Object> map = new HashMap<String, Object>();
        ReadProperties r = new ReadProperties();
        map = r.loadToMap("configurations.properties");
        
        System.out.println(map.get("app.debug"));
        
//        for (Map.Entry<String,Object> entry : map.entrySet()) {  
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
//        }  
        
    }
     
    /**
     *  得到properties文件的map形式
     * @param propertiesFilePath  properties文件的路径
     * @return Map<String,Object> 对应资源文件转换成map
     */
    public Map<String,Object> loadToMap(String propertiesFilePath) {
         
        //1.加载资源文件
        InputStream in;
        Properties pro = new Properties();
        try {
        	String confPath = System.getenv().get("T_CNF");  
            in = new FileInputStream(new File(confPath + File.separator + propertiesFilePath));
            pro.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
         
        //获取配置文件的所有键值
        Set<String> keys = pro.stringPropertyNames();
 
        //文件的内容为空
        if(keys.size() == 0){
            throw new RuntimeException("资源文件:"+propertiesFilePath+"的内容为空");
        }
         
        //把键值对放入map中
        Map<String,Object> map = new HashMap<String,Object>();
        for(String key : keys){
            map.put(key, pro.getProperty(key));
        }
        return map;
    }
}
