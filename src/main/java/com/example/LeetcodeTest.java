package com.example;


import java.util.ArrayList;
import java.util.Collections;

public class LeetcodeTest {

    public static void main(String[] args) {
//        String a = "1234567891011121314151617181920";
//        String b = "2019181716151413121110987654321";

//        String a = "999999999999";
//        String b = "999999999999";

        String a = "24566";
        String b = "452053";

//        String a = "98";
//        String b = "21";

        char[] charArr1 = a.trim().toCharArray();
        char[] charArr2 = b.trim().toCharArray();

        // 字符数组转换为int[]数组
        int[] arr1 = new int[charArr1.length];
        int[] arr2 = new int[charArr2.length];
        for(int i = 0; i < charArr1.length; i++){
            arr1[i] = charArr1[i] - '0';
        }
        for(int i = 0; i < charArr2.length; i++){
            arr2[i] = charArr2[i] - '0';
        }

        // 开始计算
//        int[] result = LeetcodeTest.bigNumberMultiply2(arr1, arr2);
//        System.out.println(a + " * " + b + " = " + Arrays.toString(result).replace(", ", ""));
        System.out.println(LeetcodeTest.karatsuba(24566  , 452053));
    }


    /**
     * 大数相乘 - 模拟乘法手算累加
     */
    public static Integer[] bigNumberMultiply(int[] arr1, int[] arr2){
        ArrayList<Integer> result = new ArrayList<>();  //中间求和的结果

        //arr2 逐位与arr1相乘
        for(int i = arr2.length - 1; i >= 0; i--){
            int carry = 0;
            ArrayList<Integer> singleList = new ArrayList<>();

            //arr2 逐位单次乘法的结果
            for(int j = arr1.length - 1; j >= 0; j--){
                int r = arr2[i] * arr1[j] + carry;
                int digit = r % 10;
                carry = r / 10;

                singleList.add(digit);
            }
            if(carry != 0){
                singleList.add(carry);
            }

            int resultCarry = 0, count = 0;
            int k = 0;
            int l = 0;
            int offset = arr2.length - 1 - i;       //加法的偏移位
            ArrayList<Integer> middleResult = new ArrayList<>();

            //arr2每位乘法的结果与上一轮的求和结果相加，从右向左做加法并进位
            while (k < singleList.size() || l < result.size()) {
                int kv = 0, lv = 0;
                if (k < singleList.size() && count >= offset) {
                    kv = singleList.get(k++);
                }
                if (l < result.size()) {
                    lv = result.get(l++);
                }
                int sum = resultCarry + kv + lv;
                middleResult.add(sum % 10);     //相加结果从右向左（高位到低位）暂时存储，最后需要逆向输出
                resultCarry = sum / 10;
                count++;
            }
            if(resultCarry != 0){
                middleResult.add(resultCarry);
            }
            result.clear();
            result = middleResult;
        }

        Collections.reverse(result);    //逆向输出结果
        return result.toArray(new Integer[result.size()]);
    }


    /**
     * 大数相乘 - 模拟乘法手算累加
     */
    public static int[] bigNumberMultiply2(int[] num1, int[] num2){
        // 分配一个空间，用来存储运算的结果，num1长的数 * num2长的数，结果不会超过num1+num2长
        int[] result = new int[num1.length + num2.length];

        // 先不考虑进位问题，根据竖式的乘法运算，num1的第i位与num2的第j位相乘，结果应该存放在结果的第i+j位上
        for (int i = 0; i < num1.length; i++){
            for (int j = 0; j < num2.length; j++){
                result[i + j + 1] += num1[i] * num2[j];
            }
        }

        //单独处理进位
        for(int k = result.length-1; k > 0; k--){
            if(result[k] > 10){
                result[k - 1] += result[k] / 10;
                result[k] %= 10;
            }
        }
        return result;
    }

    /**
     * Karatsuba乘法
     */
    public static long karatsuba(long num1, long num2){
        if(num1 < 10 || num2 < 10) return num1 * num2;

        // 计算拆分长度
        int size1 = String.valueOf(num1).length();
        int size2 = String.valueOf(num2).length();
        int halfN = Math.max(size1, size2) / 2;

        /* 拆分为a, b, c, d */
        long a = Long.valueOf(String.valueOf(num1).substring(0, size1 - halfN));
        long b = Long.valueOf(String.valueOf(num1).substring(size1 - halfN));
        long c = Long.valueOf(String.valueOf(num2).substring(0, size2 - halfN));
        long d = Long.valueOf(String.valueOf(num2).substring(size2 - halfN));

        // 计算z2, z0, z1, 此处的乘法使用递归
        long z2 = karatsuba(a, c);
        long z0 = karatsuba(b, d);
        long z1 = karatsuba((a + b), (c + d)) - z0 - z2;

        return (long)(z2 * Math.pow(10, (2*halfN)) + z1 * Math.pow(10, halfN) + z0);
    }

}
