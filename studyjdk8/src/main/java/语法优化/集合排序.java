package 语法优化;

import entes.Apple;

import java.util.*;

/**
 * @Authoc xueshiqi
 * @Date 2018/4/16 14:13
 * 集合排序，简单使用
 */
public class 集合排序 {
    public static void main(String [] os){
        List<Apple> list = new ArrayList<>();
        //得到数据
        Apple.getAppleList(list);
        //按重量进行排序
        getSort(list);
        list.forEach(apple -> {System.out.println("这个苹果id为："+apple.getId()+"  重量："+apple.getWeight()+"  颜色："+apple.getColour());});
        //按id进行排序 1.8以后使用的
        getSort8(list);
        System.out.println("-----------------下面按照id排序----------------------");
        list.forEach(apple -> {System.out.println("这个苹果id为："+apple.getId()+"  重量："+apple.getWeight()+"  颜色："+apple.getColour());});
    }

    /**
     * 在jdk 1.8 之前的排序方法使用
     * @param appleList
     */
    private static void getSort(List<Apple> appleList){
        Collections.sort(appleList, new Comparator<Apple>() {
            public int compare(Apple o1, Apple o2) {
                //比较那个苹果重
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
    }

    /**
     * 到jdk1.8后排序
     * @param appleList
     */
    private static void getSort8(List<Apple> appleList){
        appleList.sort(Comparator.comparing(Apple :: getId));
    }
}
