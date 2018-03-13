package com.family.Test;

import java.util.*;

/**
 * Created by Q_先森 on 2017/12/5.
 */
public class CollectionReview {
    public static void main(String[] args) {
        test();
    }

    /*
    ---| Collection: 单列集合

        ---| List: 有存储顺序(存储顺序和取出顺序一致), 可重复

            ---| ArrayList: 数组实现, 查找快, 增删慢.由于是数组实现, 在增和删的时候会牵扯到数组,
                        增容, 以及拷贝元素. 所以慢。数组是可以直接按索引查找, 所以查找时较快
                        List第一次创建的时候，会有一个初始大小，随着不断向List中增加元素，
                        当List 认为容量不够的时候就会进行扩容。Vector缺省情况下自动增长原来一倍的数组长度，
                        ArrayList增长原来的50%。

            ---| LinkedList: 链表实现, 增删快, 查找慢
                        由于链表实现, 增加时只要让前一个元素记住自己就可以, 删除时让前一个元素
                        记住后一个元素, 后一个元素记住前一个元素. 这样的增删效率较高但查询时需要
                        一个一个的遍历, 所以效率较低

            ---| Vector: 和ArrayList原理相同, 但线程安全, 效率略低
                        和ArrayList实现方式相同, 但考虑了线程安全问题, 所以效率略低

        ---| Set:无存储顺序, 不可重复

            ---| HashSet: 底层是由HashMap实现的，通过对象的hashCode方法与equals方法来保证插入元素的唯一性，无序(存储顺序和取出顺序不一致)。

                ---| LinkedHashSet: 底层数据结构由哈希表和链表组成。哈希表保证元素的唯一性，链表保证元素有序。(存储和取出是一致)

            ---| TreeSet: 基于 TreeMap 的 NavigableSet 实现。使用元素的自然顺序对元素进行排序，或者根据创建 set 时提供的 Comparator 进行排序

    ---| Map: 键值对
        ---| HashMap:
        ---| TreeMap:
        ---| HashTable:
        ---| LinkedHashMap:




    */


    private static void test() {
        // Collection<E>为接口，使用多态进行创建
        Collection<String> collection = new Vector<>();
        collection.add("德玛西亚之力");
        collection.add("诺克萨斯之手");
        collection.add("卡特琳娜");

        Collection<String> coll = new ArrayList();
        coll.add("卡牌大师");
        coll.add("光辉女郎");
        coll.add("蛮族之王");

        // collection.clear(); // 清空集合
        // boolean empty = collection.isEmpty(); // 集合是否为空
        // System.out.println(collection.isEmpty());

        // int size = collection.size(); // 获取集合大小
        // System.out.println(size);

        // boolean contains = collection.contains("阿木木"); // 是否包含另一个元素
        // System.out.println(contains);

        // boolean containsAll = collection.containsAll(coll); //是否完全包含另一个集合
        // System.out.println(containsAll);

        // boolean remove = collection.remove("卡特琳娜");// 删除第一个匹配项，删除了匹配项则返回true
        // boolean removeAll = collection.removeAll(coll);  // 删除与指定集合有交集的部分，原集合有改变就返回true
        // System.out.println(removeAll);

        // boolean retainAll = collection.retainAll(coll);// 保留与指定集合有交集的部分，原集合有改变就返回true
        // System.out.println(retainAll);

        // 方式1 (后面会研究一下具体内容,这里只做展示)
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("--------割-----------");

        // 方式2 ，for循环完iter就会被销毁，节约内存提高效率
        for (Iterator<String> iter = collection.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());

        }
        System.out.println("--------割-----------");

        Object[] array = collection.toArray();  // 转化为object数组
        for (Object string : array) {
            System.out.println(string);
        }
        System.out.println("--------割-----------");

        String[] arr = new String[collection.size()];
        String[] array2 = collection.toArray(arr);  // 指定要转化的数组类型
        for (String string : array2) {
            System.out.println(string);
        }
        System.out.println("--------割-----------");

        // Stream(JAVA 8) 大家可以把Stream当成一个高级版本的Iterator。这里只举了一个例子,后面会详细研究一下
        System.out.println(collection.stream().count()); // 3
        System.out.println(collection.stream().filter(str -> !str.equals("卡特琳娜")).count()); // 过滤掉'卡特琳娜' 2
        System.out.println("--------割-----------");

        // parallelStream其实就是一个并行执行的流.它通过默认的ForkJoinPool,可能提高你的多线程任务的速度.
        collection.parallelStream().forEach(System.out::println);// 打印顺序不一样,不多做解释,待后面慢慢来研究
        System.out.println("--------割-----------");

        collection.removeIf(str -> str.startsWith("德玛")); // 移除集合中满足给定条件的所有元素
        collection.forEach(System.out::println);
        System.out.println("--------割-----------");

        // 这里只举了一个例子,后面会详细研究一下
        collection.retainAll(coll); // 求交集(1.首先调用retainAll的方法 2、通过判断集合的大小，来确定是否存在交集。)
        if (collection.size() > 0) {
            System.out.println("这两个集合有相同的交集");
        } else {
            System.out.println("这两个集合没有相同的交集");
        }
        System.out.println("--------割-----------");


    }

}
