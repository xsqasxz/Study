package 语法优化;

import entes.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authoc xueshiqi
 * @Date 2018/4/16 15:11
 */
public class 代码传递 {

    public static List<Apple> filterGreenApples(List<Apple> appleList){
        Apple.getAppleList(appleList);

        return null;
    }
}
