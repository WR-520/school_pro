package com.edu.lingnan.util;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class XmlParser {
  public static HashMap<String,String> parser(String xmlPath) throws ParserConfigurationException, SAXException, IOException {
      HashMap<String,String> hm = new HashMap<String,String>();
//      实例化一个SAXParserFactory对象
    SAXParserFactory factory = SAXParserFactory.newInstance();
//      通过factory获得一个SAXParser对象 即SAX解析器
    SAXParser saxParser = factory.newSAXParser();
//    创建参数
      File f = new File(xmlPath);
      XmlHandler xh = new XmlHandler();
//    saxParser对象调用parse方法解析XML文件
    saxParser.parse( f,xh );
    hm = xh.getHashMap();
    return hm;
  }
  public static void main(String []args) throws IOException, SAXException, ParserConfigurationException {
    String xmlPath = "out//production//MyProject//database.conf.xml";
    HashMap<String,String> hm = XmlParser.parser(xmlPath);
    System.out.println(hm);
  }
}

