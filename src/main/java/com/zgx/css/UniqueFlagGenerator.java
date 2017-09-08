package com.zgx.css;


import java.lang.annotation.Annotation;
import java.util.Random;
import java.util.UUID;

/**
 * A unique flag generator  that can generate a unique flag to use.
 * {@link Annotation}.
 * <p>For example, a {@code CssScopeUtils} might create a formatter
 * @author Guoxin Zhou
 * @Email zhou871358982@163.com
 * @since 3.0
 * Created by zhouguoxin3 on 2017/9/8.
 */
public class UniqueFlagGenerator {
    private static final String Character_Prefix = "Z";
    private static String[] charactersDictionary = new String[] { "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9" };

    public static String getUniqueFlagWithUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getUniqueFlagWithRandomMethod(){
        return getUniqueString(14);
    }


    private static String getUniqueString(int len){
        Random ran = new Random();
        int num = 0;
        int dn =Math.abs(ran.nextInt()%7)+len;
        StringBuilder returnString =new StringBuilder();
        String str = "";
        for (int i = 0; i < dn;) {
            num = ran.nextInt(61);
            str = charactersDictionary[num];
            if (!(returnString.indexOf(str) >= 0)) {
                returnString.append(str);
                i++;
            }
        }
        return Character_Prefix+returnString.toString();
    }

}
