package 语法优化;

import entes.Apple;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Authoc xueshiqi
 * @Date 2018/4/16 14:46
 */
public class 方法引用 {

    public static void main(String [] os){
        List<Apple> list =new ArrayList<>();
//        //得到绿色的苹果
//        Apple.getAppleList(list);
//        list = filterGreenApples(list);
//        list.forEach(apple -> {System.out.println("这个苹果id为："+apple.getId()+"  重量："+apple.getWeight()+"  颜色："+apple.getColour());});
//        //得到重量大于50的苹果
//        Apple.getAppleList(list);
//        list = filterHeavyApples(list);
//        list.forEach(apple -> {System.out.println("这个苹果id为："+apple.getId()+"  重量："+apple.getWeight()+"  颜色："+apple.getColour());});

        //jdk8得到绿色苹果
        Apple.getAppleList(list);
        list = filterApples(list,Apple:: isGreenApple);
        list.forEach(apple -> {System.out.println("这个苹果id为："+apple.getId()+"  重量："+apple.getWeight()+"  颜色："+apple.getColour());});

        //得到重量大于50的苹果
        Apple.getAppleList(list);
        list = filterApples(list,Apple:: isHeavyApple);
        list.forEach(apple -> {System.out.println("这个苹果id为："+apple.getId()+"  重量："+apple.getWeight()+"  颜色："+apple.getColour());});

    }

    /**
     * jdk8以前如果需要找出文件夹中隐藏的文件需要实例化isHidden方法
     * @return
     */
    private static File[] screenHidden(){
        File[] hiddenFiles = new File(".").listFiles(new FileFilter(){
            public boolean accept(File file){
                return file.isHidden();
            }
        });
        return hiddenFiles;
    }

    /**
     * jdk8 中使用了 方法引用
     * 将File的isHidden的方法进行引用使用
     * @return
     */
    private static File[] screenHidden8(){
        File[] hiddenFiles = new File(".").listFiles(File :: isHidden);
        return hiddenFiles;
    }

    /**
     * jdk8以前使用普通方法得到绿色的苹果
     * @param appleList
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> appleList){
        //得到绿色的苹果
        List<Apple> list = new ArrayList<>();
        for(Apple apple: appleList){
            if("绿色".equals(apple.getColour())){
                list.add(apple);
            }
        }
        return list;
    }

    /**
     * 得到 重量大于150的苹果
     * @param appleList
     * @return
     */
    public static List<Apple> filterHeavyApples(List<Apple> appleList){
        //得到重量大于 150的苹果
        List<Apple> list = new ArrayList<>();
        for(Apple apple:appleList){
            if(50<apple.getWeight())
                list.add(apple);
        }
        return list;
    }

    /**
     * 封装好方法了
     * @param appleList
     * @param predicate
     * @return
     */
    public static List<Apple> filterApples(List<Apple> appleList,Predicate<Apple> predicate){
        return (List<Apple>) appleList.stream().filter(apple -> predicate.test(apple)).distinct().collect(Collectors.toList());
    }
}
