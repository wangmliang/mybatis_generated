package com.generated.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.commons.lang3.StringUtils;

import com.generated.config.Configuration;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * XStream 操作帮助类
 * @author wml
 */
public class XmlUtil {
	
	/**
	 * java 转换成xml
	 * @param obj	对象实例
	 * @return	String xml字符串
	 * @author WML
	 * 2016年7月7日-下午4:34:39
	 */
    public static String toXml(Object obj){
//      XStream xstream=new XStream();
    	XStream xstream=new XStream(new DomDriver()); //直接用jaxp dom来解释
//      XStream xstream=new XStream(new DomDriver("utf-8")); //指定编码解析器,直接用jaxp dom来解释
         
        //如果没有这句，xml中的根元素会是<包.类名>；或者说：注解根本就没生效，所以的元素名就是类的属性
//      xstream.processAnnotations(obj.getClass()); //通过注解方式的，一定要有这句话。下面那句同理
        xstream.autodetectAnnotations(true);
        //注入转化器
//      xstream.registerConverter(new AuthorXmlConverter());
//      xstream.registerConverter(new DescriptionXmlConverter());
        return xstream.toXML(obj);
    }
     
    /**
     * 将传入xml文本转换成Java对象
     * @param xmlStr	xml格式字符串
     * @param cls  		xml对应的class类
     * @return T   		xml对应的class类的实例对象
     * @author WML
	 * 2016年7月7日-下午4:34:39
     */
	@SuppressWarnings("unchecked")
	public static <T> T  toBean(String xmlStr,Class<T> cls){
        //注意：不是new Xstream(); 否则报错：java.lang.NoClassDefFoundError: org/xmlpull/v1/XmlPullParserFactory
        XStream xstream=new XStream(new DomDriver());
        xstream.processAnnotations(cls);
        T obj = (T)xstream.fromXML(xmlStr);
        return obj;         
    } 

   /**
     * 写到xml文件中去
     * @param obj 		待操作的JAVA对象
     * @param absPath 	绝对路径
     * @param fileName  文件名
     * @param encoding  字符集编码 null:表示默认编码
     * @return boolean
     * @author WML
	 * 2016年7月7日-下午4:34:39
     */
    public static boolean toXMLFile(Object obj, String absPath, String fileName, String encoding){
    	String strXml = "<?xml version=\"1.0\" encoding=\"" + encoding +"\"?>\n";
//      String strXml = toXml(obj);
    	strXml += toXml(obj);
        String filePath = absPath + fileName;
        File file = new File(filePath);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            	System.out.println("创建{"+ filePath +"}文件失败!!!" + e.getMessage());
                return false ;
            }
        }// end if 
        OutputStream ous = null ;
        try {
            ous = new FileOutputStream(file);
            ous.write(strXml.getBytes());
            ous.flush();
        } catch (Exception e1) {
            e1.printStackTrace();
            System.out.println("写{"+ filePath +"}文件失败!!!" + e1.getMessage());
            return false;
        }finally{
            if(ous != null )
                try {
                    ous.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("写{"+ filePath +"}文件关闭输出流异常!!!" + e.getMessage());
                }
        }
        return true ;
    }
     
    /**
     * 从xml文件读取报文
     * @param absPath 	绝对路径
     * @param fileName 	文件名
     * @param cls 		映射java类
     * @param encodeing 字符集编码
     * @throws Exception 
     * @return T
     * @author WML
	 * 2016年7月7日-下午4:34:39
     */
    @SuppressWarnings({ "unchecked", "resource" })
	public static <T> T  toBeanFromFile(String absPath, String fileName, Class<T> cls, String encodeing) throws Exception{
        String filePath = absPath + fileName;
        if(StringUtils.isBlank(fileName)) {
            filePath = absPath;
        }
        InputStream ins = null ;
        try {
            ins = new FileInputStream(new File(filePath));
        } catch (Exception e) {
            throw new Exception("读{"+ filePath +"}文件失败！", e);
        }
        //--------- 通过流的方式把 InputStream 转化成字符串-----------
        String str = ""; 
        BufferedReader reader = null;
        if(StringUtils.isNotBlank(encodeing)) {
        	reader = new BufferedReader(new InputStreamReader(ins, encodeing));  
        }else{
        	reader = new BufferedReader(new InputStreamReader(ins));
        }
        StringBuffer sb = new StringBuffer();  
        while ((str = reader.readLine()) != null) {  
            sb.append(str).append("\n");  
        }  
        //---------------------
        XStream xstream=new XStream(new DomDriver());
        xstream.processAnnotations(cls);
        T obj =null;
        try {
            obj = (T)xstream.fromXML(sb.toString());
        } catch (Exception e) {
            throw new Exception("解析{"+ filePath +"}文件失败！",e);
        }
        if(ins != null)
            ins.close();
        return obj;         
    } 
    
    public static void main(String[] args) {
		try {
			Configuration configuration = XmlUtil.toBeanFromFile("E:\\JAVA\\java_demo\\test\\", "generatorConfig.xml", Configuration.class, "UTF-8");
			System.out.println(configuration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
