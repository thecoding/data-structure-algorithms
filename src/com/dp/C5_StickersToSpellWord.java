package com.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/stickers-to-spell-word
 */
public class C5_StickersToSpellWord {

    public static void main(String[] args) {
        String[] strArr = {"niaad","aabbc"};
        String target = "bbccc";
        System.out.println("minSticker1 -> "  + minStickers1(strArr, target));
        System.out.println("minSticker2 -> " + minStickers2(strArr, target));
        System.out.println("minSticker2 -> " + minStickers3(strArr, target));
    }


    public static int minStickers1(String[] stickers, String target) {
        int ans = process1(stickers, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // 一次用第一张去减，看看目标有没有减少
    private static int process1(String[] stickers, String target) {
        if (target.length() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String sticker : stickers) {
            String rest = reduce(target, sticker);
            if (rest.length() != target.length()) {
                min = Math.min(min, process1(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    private static String reduce(String target, String sticker) {
        char[] targetChar = target.toCharArray();
        char[] stickerChar = sticker.toCharArray();
        int[] count = new int[26];
        for (char c : targetChar) {
            count[c - 'a']++;
        }
        for (char c : stickerChar) {
            count[c - 'a']--;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    builder.append((char) (i + 'a'));
                }
            }
        }
        return builder.toString();
    }


    private static int minStickers2(String[] stickers, String target) {
        int[][] stickerArr = new int[stickers.length][26];
        for (int i = 0; i < stickerArr.length; i++) {
            for (char stickerChar : stickers[i].toCharArray()) {
                stickerArr[i][stickerChar - 'a']++;
            }
        }
        int ans = process2(stickerArr, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    // 目的：将target逐次消除？
    // target每次都是减少的，
    public static int process2(int[][] stickers, String target) {
        // base case
        if (target.length() == 0) {
            return 0;
        }
        char[] targetArr = target.toCharArray();
        int[] targetNums = new int[26]; // 序号对应的字母个数
        for (char c : targetArr) {
            targetNums[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stickers.length; i++) {
            // 取出第i个sticker，一次去扣减target
            int[] sticker = stickers[i];
            // targetArr[0] - 'a' 表示目标target第一个字母
            // sticker[targetArr[0] - 'a'] > 0 表示当前字母可以去消除target中的第一个
            if (sticker[targetArr[0] - 'a'] > 0) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (targetNums[j] > 0) {
                        int nums = targetNums[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            builder.append((char) (j + 'a'));
                        }
                    }
                }
                String rest = builder.toString();
                min = Math.min(min, process2(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }


    // 根据minStickers2改成dp
    private static int minStickers3(String[] stickers, String target) {
        int[][] stickerArr = new int[stickers.length][26];
        for (int i = 0; i < stickerArr.length; i++) {
            for (char stickerChar : stickers[i].toCharArray()) {
                stickerArr[i][stickerChar - 'a']++;
            }
        }
        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        int ans = process3(stickerArr, target, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int process3(int[][] stickers, String target, Map<String,Integer> dp) {
        if(dp.containsKey(target)){
            return dp.get(target);
        }
        char[] targetArr = target.toCharArray();
        int[] targetNums = new int[26]; // 序号对应的字母个数
        for (char c : targetArr) {
            targetNums[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stickers.length; i++) {
            int[] sticker = stickers[i];
            if (sticker[targetArr[0] - 'a'] > 0) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (targetNums[j] > 0) {
                        int nums = targetNums[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            builder.append((char) (j + 'a'));
                        }
                    }
                }
                String rest = builder.toString();
                min = Math.min(min, process2(stickers, rest));
            }
        }
        int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(target, ans);
        return ans;
    }



}
