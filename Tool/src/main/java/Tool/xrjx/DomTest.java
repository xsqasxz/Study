package Tool.xrjx;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomTest {
    public static void main(String[] args) {
        //创建DocumentBuilderFactory对象
        DocumentBuilderFactory a = DocumentBuilderFactory.newInstance();
        try {
            //创建DocumentBuilder对象
            DocumentBuilder b = a.newDocumentBuilder();
            //通过DocumentBuilder对象的parse方法返回一个Document对象
            Document document = b.parse("src\\record.xml");
            //通过Document对象的getElementsByTagName()返根节点的一个list集合
            NodeList booklist = document.getElementsByTagName("multirecord");
            for(int i =0; i<booklist.getLength(); i++){

                //循环遍历获取每一个book
                Node book = booklist.item(i);
                //通过Node对象的getAttributes()方法获取全的属性值
                NamedNodeMap bookmap = book.getAttributes();
                //循环遍每一个book的属性值
                for(int j = 0; j<bookmap.getLength(); j++){
                    Node node = bookmap.item(j);
                    //通过Node对象的getNodeName()和getNodeValue()方法获取属性名和属性值
                    if(StringUtils.equals("multimedia",node.getNodeName())) {
                        System.out.println(node.getNodeValue());
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }

}
