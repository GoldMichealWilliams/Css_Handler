package com.zgx.css;

/**
 * Unique flags generator factory
 * Created by zhouguoxin3 on 2017/9/8.
 */
public class UniqueFlagGeneratorFactory {

    public static String getUniqueFlagWithDifferentMethods(UniqueGeneratorsEnum uniqueGeneratorsEnum){
       if(uniqueGeneratorsEnum == UniqueGeneratorsEnum.RANDOM_CHARS){
           return  UniqueFlagGenerator.getUniqueFlagWithRandomMethod();
       }else{
           return UniqueFlagGenerator.getUniqueFlagWithUUID();
       }
    }
}
