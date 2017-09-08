package com.zgx.css;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;

/**
 * A css handler utils that have rich methods to add scope to each css flag.
 * {@link Annotation}.
 * <p>For example, a {@code CssScopeUtils} might create a formatter
 * @author Guoxin Zhou
 * @Email zhou871358982@163.com
 * @since 3.0
 * Created by zhouguoxin3 on 2017/9/8.
 */
public class CssScopeUtils {

    public static String autoHandleCssWithScope(String cssContent, UniqueGeneratorsEnum generator){
       if(generator == null){
           generator = UniqueGeneratorsEnum.UUID;
       }
       String parentId = UniqueFlagGeneratorFactory.getUniqueFlagWithDifferentMethods(generator);
       return  handleCssWithUniqueFlag(parentId,cssContent);
    }

    public static String handleCssWithParentId(Integer templateId,String cssContent){
        return handleCssWithParentFlagAndId("",templateId,cssContent);
    }



    public static String handleCssWithParentFlagAndId(String parentFlag,Integer templateId,String cssContent){
        if(StringUtils.isEmpty(parentFlag)){
            parentFlag = ".parent"+templateId;
        }else{
            parentFlag = parentFlag+templateId;
        }
        return handleCssWithUniqueFlag(parentFlag,cssContent);
    }

    public static String handleCssWithUniqueFlag(String parentId,String cssContent){
        String cssContentResult = "";
        if(parentId == null || StringUtils.isEmpty(cssContent)){
            return cssContentResult;
        }
        cssContentResult = handleCssReplace(cssContent, parentId+" $1$2");
        cssContentResult = cssContentResult.replaceAll("("+parentId+")"+"\\s*\\\\1(?=[\\s\\\\r\\\\n,{])","$1");
        cssContentResult = cssContentResult.replaceAll("("+parentId+")"+"\\s*:host","$1");
        cssContentResult = cssContentResult.replaceAll(parentId+"\\s*@","@");
        cssContentResult = cssContentResult.replaceAll("("+parentId+")"+"\\s*(to|from|\\\\d+%)","$2");
        return cssContentResult;
    }

    /**
     * 处理CSS部分
     * @param cssContent
     * @param replacer
     * @return
     */
    private static String  handleCssReplace(String cssContent,String replacer){
        cssContent.replaceAll("/\\*([\\p{Z}\\t\\n\\cK\\f\\r\\S]*?)\\*/","");
        return cssContent.replaceAll("([^\\r\\n,{}]+)(,(?=[^}]*\\{)|[\\t\\n\\cK\\f\\r ]*\\{)",replacer);
    }
}
