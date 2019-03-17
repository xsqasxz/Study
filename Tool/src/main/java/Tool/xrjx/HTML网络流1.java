package Tool.xrjx;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HTML网络流1 {
    public static void main(String args[]) throws IOException {
        Map<String,String> map = getUrls();
        for(String name : map.keySet()) {
            String url = map.get(name);
            String url1= url.substring(0,url.lastIndexOf("/")+1);
            InputStream inputStream;//接收字节输入流
            InputStreamReader inputStreamReader;//将字节输入流转换成字符输入流
            BufferedReader bufferedReader;//为字符输入流加缓冲
            FileOutputStream fileOutputStream;//字节输出流
            OutputStreamWriter outputStreamWriter;//将字节输出流转换成字符输出流

            URL wangyi = new URL(url);
            inputStream = wangyi.openStream();
            inputStreamReader = new InputStreamReader(inputStream, "gb2312");
            bufferedReader = new BufferedReader(inputStreamReader);
            String s;
            File dest = new File("src/record.xml");
            fileOutputStream = new FileOutputStream(dest);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gb2312");
            while ((s = bufferedReader.readLine()) != null) {
                outputStreamWriter.write(s);
            }
            outputStreamWriter.close();
            fileOutputStream.close();
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            getGrf(name,url1);
        }
    }

    public static Map<String,String> getUrls() throws IOException {
        File file = new File("src/易投经精英版.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        int line = 1;
        String key = "";
        Map<String,String> map = new HashMap<>();
        while ((tempString = reader.readLine()) != null) {
             // 显示行号
            if(StringUtils.isNotBlank(tempString)) {
                if (StringUtils.contains(tempString, "第"))
                    key = tempString;
                else {
                    map.put(key,tempString);
                }
            }
             line++;
         }
         reader.close();
        return map;
    }
    public static void getUrl(String urlString,String name,int i) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);
        File dest1 = new File("E:\\易投经精英版\\"+name);
        dest1.mkdirs();
        File dest = new File("E:\\易投经精英版\\"+name+"\\"+i+".grf");
        FileOutputStream fos = new FileOutputStream(dest);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }


    }

    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static void getGrf(String name,String url){
        //创建DocumentBuilderFactory对象
        DocumentBuilderFactory a = DocumentBuilderFactory.newInstance();
        try {
            //创建DocumentBuilder对象
            DocumentBuilder b = a.newDocumentBuilder();
            //通过DocumentBuilder对象的parse方法返回一个Document对象
            Document document = b.parse("src\\record.xml");
            //通过Document对象的getElementsByTagName()返根节点的一个list集合
            NodeList booklist = document.getElementsByTagName("multirecord");
            int k = 1;
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
                        getUrl(url+node.getNodeValue(),name,k);
                        k++;
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
