package com.java.leetcode;


/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class t121买卖股票的最佳时机 {

    public static void main(String[] args) {

        int[] prices={7,6,4,3,1};
        int i = maxProfit(prices);
        System.out.println(i);
    }
    //[7,1,5,3,6,4]
    /**
     * 执行用时：
     * 216 ms
     * , 在所有 Java 提交中击败了
     * 20.25%
     * 的用户
     * 内存消耗：
     * 39.9 MB
     * , 在所有 Java 提交中击败了
     * 5.32%
     * 的用户
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int max=0;
        for(int i=0;i<prices.length;i++){
            int buy=prices[i];
            for(int j=i+1;j<prices.length;j++){
               int sale=prices[j];
               if(sale-buy>max){
                   max=sale-buy;
               }
            }
        }
        return max;
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 98.89%
     * 的用户
     * 内存消耗：
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 5.32%
     * 的用户
     * @param prices
     * @return
     */
    public static int maxProfitv2(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int max=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(min>prices[i]){
                min=prices[i];
            }else{
                max=Math.max(max,prices[i]-min);
            }
        }
        return max;
    }
}
