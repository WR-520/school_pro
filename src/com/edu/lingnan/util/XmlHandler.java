package com.edu.lingnan.util;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import java.util.HashMap;
import org.xml.sax.Attributes;


public class XmlHandler extends DefaultHandler {
  //StringBuffer是可变长字符串 StringBuffer和String不能直接进行强制转换
  private StringBuffer sb = new StringBuffer();
  private HashMap<String,String> hm = new HashMap<String,String>();

//   元素开始
 public void startElement(String uri, String localName, String qName, Attributes attributes)
  throws SAXException{
    //public StringBuffer delete(int start,int end):删除从指定位置开始到指定位置结束的内容，并返回本身
    sb.delete(0,sb.length());
 }

//  元素结束
  public void endElement(String uri,String localName, String qName)throws SAXException
  {
    //存，元素名，元素内容
    hm.put(qName.toLowerCase(), sb.toString().trim());
  }

//  字符处理
  public void characters(char ch[], int start,int length)
  throws SAXException{
//   Stringbuffer是动态字符串数组，append( )是往动态字符串数组添加
   sb.append(ch,start,length);
  }
  public HashMap<String,String> getHashMap(){
   return hm;
  }
}
