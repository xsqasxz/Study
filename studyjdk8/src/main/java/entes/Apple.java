package entes;

import java.util.List;
import java.util.Random;

/**
 * @Authoc xueshiqi
 * @Date 2018/4/16 14:20
 * 苹果类型
 */
public class Apple {
    /**
     * 唯一标示
     */
    Long id;
    /**
     * 形状
     */
    String shape;
    /**
     * 颜色
     */
    String colour;
    /**
     * 重量
     */
    Double weight;
    /**
     * 品种
     */
    String type;

    public Apple() {
    }

    public Apple(Long id, String shape, String colour, Double weight, String type) {
        this.id = id;
        this.shape = shape;
        this.colour = colour;
        this.weight = weight;
        this.type = type;
    }

    /**
     * 对数据进行简单封装
     * @return
     */
    public static void getAppleList(List<Apple> appleList){
        Random r = new Random();
        String [] colours = new String[]{"红色","绿色","黄色"};
        for(int i = 0; i<100;i++) {
            appleList.add(new Apple(System.nanoTime(),"圆形",colours[r.nextInt(3)],Math.random()*100,"红富士"));
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
