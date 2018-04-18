package 语法优化;

import java.io.File;
import java.io.FileFilter;

/**
 * @Authoc xueshiqi
 * @Date 2018/4/16 14:46
 */
public class 方法引用 {

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
}
