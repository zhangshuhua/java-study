package com.zsh.algorithm.chinese;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ChineseNumber<T> {

    public String value;

    private static final String[] digits = {"零","一","二","三","四","五","六","七","八","九"};

    private static final String[] levels = {"","十","百","千"};

    private static final String[] thousands = {"","万","亿"};

    public ChineseNumber(long value) {
        this.value = trimBeginZero(value+"");
    }

    public ChineseNumber(String value) {
        this.value = trimBeginZero(value);
    }

    @Override
    public String toString(){

        String[] tenThousands = generateList();
        String result = "";


        for (int i = 0; i <tenThousands.length ; i++) {

            String thisThousand = lowThanThousand(tenThousands[i]);
            if(i>0&&!thisThousand.equals("")&&!thisThousand.contains("千")){
                thisThousand = "零"+thisThousand;
            }
            result = result+thisThousand+thousands[tenThousands.length-1-i];
        }
        return result;
    }

    /**
     * 返回每组的汉语表示
     * @param value
     * @return
     */
    public String lowThanThousand(String value){
        value = trimBeginZero(value);
        String result = "";
        char[] thousand = value.toCharArray();

        int level = 0;
        for (int j = thousand.length-1; j>=0; j--, level++) {
            char c = thousand[j];
            int digit = (int)c-48;
            if (digits[digit].equals("零")) {
                if (!result.equals("")&&!result.startsWith("零")) {
                    result = digits[digit] + result;
                }
            } else {
                result = digits[digit] + levels[level] + result;
            }

        }
        return result;
    }

    private String trimBeginZero(String value){
        while (value.startsWith("0")){
            value = value.substring(1);
        }
        return value;
    }


    /**
     * 把值每4个分成一组
     * @return
     */
    public String[] generateList(){
        List<String> tenThousands = new ArrayList<>();
        for (int i = value.length(); i >0 ; i-=4) {
            int beginIndex = i-4>=0?i-4:0;
            int endIndex = i;
            tenThousands.add(0,value.substring(beginIndex,endIndex));
        }
        return tenThousands.toArray(digits);
    }

    public String getValue() {
        return value;
    }



}

class ChineseNumberTest{
    public static void main(String[] args) {
        ChineseNumber chineseNumber1 = new ChineseNumber("1000001");
        System.out.println(chineseNumber1);

        ChineseNumber chineseNumber2 = new ChineseNumber(0001);
        System.out.println(chineseNumber2);

        ChineseNumber chineseNumber3 = new ChineseNumber("0000001");
        System.out.println(chineseNumber3);

        ChineseNumber chineseNumber4 = new ChineseNumber(10);
        System.out.println(chineseNumber4);

        ChineseNumber chineseNumber5 = new ChineseNumber("10078970001");
        System.out.println(chineseNumber5);

        ChineseNumber chineseNumber6 = new ChineseNumber("100104564501");
        System.out.println(chineseNumber6);
    }


}
