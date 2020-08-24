package leetCode.mytest;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        String s = big(chineseNumber2Int("九千五百三十亿七千三百二十万四百三十万三十二万零四千五百五十"));
        System.out.println(s);
    }

    private static String big(double d) {
        NumberFormat nf = NumberFormat.getInstance();
        // 是否以逗号隔开, 默认true以逗号隔开,如[123,456,789.128]
        nf.setGroupingUsed(true);
        //设置小数位数
        nf.setMaximumFractionDigits(5);
        nf.setRoundingMode(RoundingMode.UP);
        // 结果未做任何处理
        return nf.format(d);
    }

    private static double chineseNumber2Int(String chineseNumber) {
        double result = 0;
        char[] cnArr = new char[]{'一', '二', '三', '四', '五', '六', '七', '八', '九'};
        char[] chArr = new char[]{'亿', '万', '千', '百', '十'};
        int start = 0;//数字的起点
        int end = 0;//数字断点
        int integerLen = chineseNumber.length();
        boolean hasMinus = false;
        boolean hasPoint = false;//判断是否是小数
        boolean hasLast = false;//判断是否有个位数
        //数字分段（通过从大到小分割）
        Map<Character, String> mapNum = new HashMap<>();

        if (chineseNumber.charAt(0) == '负') {
            hasMinus = true;
            start = 1;
        }
        if (chineseNumber.contains("点")) {
            hasPoint = true;
            integerLen = chineseNumber.indexOf("点");
        }
        for (int i = 0; i < chArr.length; i++) {
            char c = chineseNumber.charAt(integerLen - 1);
            if (c == chArr[i]) {
                hasLast = true;
                break;
            }
        }

        //循环单位判断字符串的单位
        for (int i = 0; i < chArr.length; i++) {
            for (int j = start; j < integerLen; j++) {
                char c = chineseNumber.charAt(j);
                if (c == chArr[i]) {
                    end = j;
                    if (start == end) {
                        mapNum.put(chArr[i], "零");
                    } else {
                        mapNum.put(chArr[i], chineseNumber.substring(start, end));
                    }
                    start = j + 1;//下个数字开始位置是去除上个数字段的单位的（十七万八千五百：分成十七，八，五）
                    continue;
                } else {
                    //表示后面已没有单位（个位数）
                    if (!hasLast && i == chArr.length - 1 && start < integerLen) {
                        mapNum.put('个', chineseNumber.substring(start, integerLen));
                    }
                }
            }
        }

        //遍历分隔的数字段
        for (Map.Entry<Character, String> entry : mapNum.entrySet()) {
            int temp = 1;//存放一个单位的数字
            int count = 0;//判断是否有单位
            long nums = 0;
            for (int i = 0; i < entry.getValue().length(); i++) {
                boolean b = true;//判断是否是单位
                char c = entry.getValue().charAt(i);
                for (int j = 0; j < cnArr.length; j++) {//非单位，即数字
                    if (c == cnArr[j]) {
                        if (0 != count) {//添加下一个单位之前，先把上一个单位值添加到结果中
                            nums += temp;
                            temp = 1;
                            count = 0;
                        }
                        // 下标+1，就是对应的值
                        temp = j + 1;
                        b = false;
                        break;
                    }
                }
                if (b) {//单位{'亿','万','千','百','十'}
                    for (int j = 0; j < chArr.length; j++) {
                        if (c == chArr[j]) {
                            switch (j) {
                                case 4:
                                    temp *= 10;
                                    break;
                                case 3:
                                    temp *= 100;
                                    break;
                                case 2:
                                    temp *= 1000;
                                    break;
                                case 1:
                                    temp *= 10000;
                                    break;
                                case 0:
                                    temp *= 100000000;
                                    break;
                                default:
                                    break;
                            }
                            count++;
                        }
                    }
                }
                if (i == entry.getValue().length() - 1) {//遍历到最后一个字符
                    nums += temp;
                    for (int j = 0; j < chArr.length; j++) {
                        if (entry.getKey() == chArr[j]) {
                            switch (j) {
                                case 4:
                                    nums *= 10;
                                    break;
                                case 3:
                                    nums *= 100;
                                    break;
                                case 2:
                                    nums *= 1000;
                                    break;
                                case 1:
                                    nums *= 10000;
                                    break;
                                case 0:
                                    nums *= 100000000;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    result += nums;
                }
            }
        }
        if (hasPoint) {
            String num = "0.";
            for (int i = integerLen + 1; i < chineseNumber.length(); i++) {
                char c = chineseNumber.charAt(i);
                for (int j = 0; j < cnArr.length; j++) {
                    if (c == cnArr[j]) {
                        num += (j + 1);
                    }
                }
            }
            result += Double.parseDouble(num);
        }
        if (hasMinus) {
            result *= -1;
        }
        return result;
    }
}

