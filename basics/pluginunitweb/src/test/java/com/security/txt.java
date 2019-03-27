//package com.security;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// * @author xueshiqi
// * @since 2019/3/18
// */
//public class txt {
//
//    @Test
//    public void mergeMapValuesTest() {
//        Map<Integer, ListContainer> map = new HashMap();
//        List<AClass> aClassList1 = new ArrayList<>();
//        aClassList1.add(new AClass(1, "zhuoli1", "haha1"));
//        aClassList1.add(new AClass(2, "zhuoli2", "haha2"));
//        aClassList1.add(new AClass(3, "zhuoli3", "haha3"));
//
//        List<AClass> aClassList2 = new ArrayList();
//        aClassList2.add(new AClass(1, "zhuoli11", "haha11"));
//        aClassList2.add(new AClass(5, "zhuoli5", "haha5"));
//        aClassList2.add(new AClass(6, "zhuoli6", "haha6"));
//
//        /*交集*/
//        /*[AClass(id=1, name=zhuoli1, description=haha1)]*/
//        List<AClass> intersectResult = aClassList1.stream().filter(aClassList2::contains).collect(Collectors.toList());
//        System.out.println(intersectResult);
//
//        /*并集*/
//        List<AClass> unionResult = Stream.of(aClassList1, aClassList2).flatMap(Collection::stream).distinct().collect(Collectors.toList());
//
//        assertEquals(unionResult.size(), 6);
//        System.out.println(unionResult);
//
//        /*差集*/
//        /*[AClass(id=2, name=zhuoli2, description=haha2), AClass(id=3, name=zhuoli3, description=haha3)]*/
//        List<AClass> differenceResult = aClassList1.stream().filter(x -> !aClassList2.contains(x)).collect(Collectors.toList());
//        System.out.println(differenceResult);
//
//        map.put(1, new ListContainer(aClassList1));
//        map.put(2, new ListContainer(aClassList2));
//        /*合并多个list*/
//        List<AClass> aClassListResult = map.values().stream().flatMap(listContainer -> listContainer.getList().stream()).collect(Collectors.toList());
//
//        /*注意跟并集的区别*/
//        assertEquals(aClassListResult.size(), 6);
//        System.out.println(aClassListResult);
//    }
//}
