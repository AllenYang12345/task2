package com.system.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author AllenYang
 * @date 18-10-20 下午9:07
 */
public class ResultCode {

    public static String getValueByKey(String propertyBaseName,String key){
        Locale locale = Locale.getDefault();
        ResourceBundle localResource = ResourceBundle.getBundle(
                propertyBaseName,locale
        );
        String value = localResource.getString(key);
        return value;
    }


}
