package Tool;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 汉化语言包增强版 {
    public static void hanhua() throws IOException {
        //先读取需要汉化的文件夹
        File fileEn = new File("C:\\Users\\xuesq\\Desktop\\messages_en");
        File fileCn = new File("C:\\Users\\xuesq\\Desktop\\messages_cn");
        //这里目前存放的就是全部需要汉化的文件了
        File[] fileEns = fileEn.listFiles();
        File[] fileCns = fileCn.listFiles();
        Map<String , Map<String ,String >> mapCn = new HashMap<>();
        for(File cn : fileCns){
            Map<String , String> mapCnls = new HashMap<>();
            List<String> list = FileUtils.readLines(cn, "UTF-8");
            for(String s:list){
                if(StringUtils.isNotBlank(s)){
                    String[] split= StringUtils.split(s,"=");
                    if(split.length==2){
                        mapCnls.put(split[0],split[1]);
                    }
                }
            }
            mapCn.put(cn.getName(),mapCnls);
        }

        for(File en : fileEns) {
            List<String> stringArrayList = new ArrayList<>();
            List<String> list = FileUtils.readLines(en, "UTF-8");
            Map<String, String> mapCnls = mapCn.get(en.getName());
            if (MapUtils.isNotEmpty(mapCnls)) {
                for (String s : list) {
                    if (StringUtils.isNotBlank(s)) {
                        String[] split = StringUtils.split(s, "=");
                        if (split.length == 2) {
                            String cnLien = mapCnls.get(split[0]);
                            if (StringUtils.isNotBlank(cnLien))
                                stringArrayList.add(split[0] + "=" + cnLien);
                            else
                                stringArrayList.add(split[0] + "=" + split[1]);
                        } else {
                            stringArrayList.add(s);
                        }
                    }
                }
                FileUtils.writeLines(en, stringArrayList);
            }
        }
    }


    public static void main(String[] args){
        try {
            hanhua();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
