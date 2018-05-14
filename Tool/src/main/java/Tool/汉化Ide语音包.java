package Tool;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class 汉化Ide语音包 {

    public static void hanhuas(){
        百度翻译接口 b = new 百度翻译接口();
        String filter = "{}&#|[]<>?\\";
        File file = new File("C:\\Users\\xuesq\\Desktop\\messages");
        if(file.exists() && file.isDirectory()){//判断读取的文件不为空且为文件夹
            File[] files = file.listFiles();//得到文件夹里面的全部文件
            for (File f: files) {
                try {
                    List<String> list = FileUtils.readLines(f, "UTF-8");
                    List<String> stringArrayList =new ArrayList<>();
                    String string = "";
                    for(String s:list){
                        string=s;
                        if(StringUtils.isNotBlank(s)){
                            String[] split= StringUtils.split(s,"=");
                            if(split.length==2){
                                String t =split[1];
                                char[] chars = filter.toCharArray();
                                if(StringUtils.indexOfAny(t,chars)==-1){
                                    string = split[0]+"="+gbEncoding(b.fanyi(t));
                                    System.out.println(string);
                                }
//                                if(StringUtils.indexOf(t,"{0}")!=-1){
//                                    string = split[0]+"="+b.fanyi(t);
//                                    string = StringUtils.replace(StringUtils.replace(string,"{ ","{")," }","}");
//                                    System.out.println(string);
//                                }
                            }
                        }
                        stringArrayList.add(string);
                    }
                    FileUtils.writeLines(f,stringArrayList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String gbEncoding(final String gbString) {   //gbString = "测试"
        char[] utfBytes = gbString.toCharArray();   //utfBytes = [测, 试]
        String unicodeBytes = "";
        for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
            String hexB = Integer.toHexString(utfBytes[byteIndex]);   //转换为16进制整型字符串
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
//        System.out.println("unicodeBytes is: " + unicodeBytes);
        return unicodeBytes;
    }


    public static void main(String [] s){
        hanhuas();
//        System.out.println(gbEncoding("无法创建目录"));
//        System.out.println(StringUtils.replace("无法创建目录“{ 0 }”。","{ ","{"));
    }
}
