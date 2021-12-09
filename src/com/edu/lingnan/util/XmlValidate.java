package com.edu.lingnan.util;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import java.io.*;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

 public class XmlValidate {
  //    验证成功返回T 否则返回F
  public static boolean validate(String xmlPath, String xsdPath) {
    boolean flag = false;
    //创建模式工厂
    try {
      SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
      //    通过XSD文件创建模式Schema
      File f = new File(xsdPath);
      Schema s = factory.newSchema(f);
      //     由模式创建验证器Validator
      Validator v = s.newValidator();
//      使用验证器验证XML文件
      Source so = new StreamSource(xmlPath);
      v.validate(so);
      flag = true;
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("验证过程出现错误");
      e.printStackTrace();
    }
    return flag;
  }


    public static void main(String[] args){
       String xmlPath = "out//production//MyProject//database.conf.xml";
       String xsdPath= "out//production//MyProject//database.conf.xsd";
       System.out.println(XmlValidate.validate(xmlPath,xsdPath));

    }
}
