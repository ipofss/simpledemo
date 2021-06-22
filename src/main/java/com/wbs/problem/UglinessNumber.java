package com.wbs.problem;

import java.util.*;

/**
 * 丑数解法
 *
 * @author: wangbingshuai
 * @create: 2020-02-07 10:09
 **/
public class UglinessNumber {
    //评测题目: 无
    //把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
    //习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " == " + getUgly(i));
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
    }

    /**
     * 获取第index个丑数
     *
     * @param index
     * @return
     */
    public static Integer getUgly(Integer index) {
        final int indexNum = index;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (index.equals(1)) {
            return list.get(0);
        } else {
            int uglyNum = 2;
            while (index > 1) {
                if (isUgly(uglyNum)) {
                    list.add(uglyNum);
                    index--;
                }
                uglyNum++;
            }
            return list.get(indexNum - 1);
        }
    }

    /**
     * 是否是丑数
     *
     * @param num
     * @return
     */
    public static Boolean isUgly(Integer num) {
        Set<Integer> uglySet = new HashSet<>(Arrays.asList(2, 3, 5));
        List<Integer> elementList = getElements(num);
        uglySet.addAll(elementList);
        return uglySet.size() == 3;
    }

    /**
     * 获取所有因子
     *
     * @param num
     * @return
     */
    public static List<Integer> getElements(Integer num) {
        List<Integer> list = new ArrayList<>();
        int factor = 2;
        do {
            if (num % factor == 0) {
                list.add(factor);
                num = num / factor;
                factor = 1;
            }
            factor++;
        } while (num >= factor);
        return list;
    }
}
