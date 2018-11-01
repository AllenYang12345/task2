package com.system.util;

import junit.framework.TestCase;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * @author AllenYang
 * @date 18-10-18 上午12:03
 */
public class MessageSourceTest extends TestCase {
    public void testResourceBundleMessageSource(){
        MessageSource messageSource=new ClassPathXmlApplicationContext("app-context.xml");
        String username_us=messageSource.getMessage("userName_lable",new Object[1],Locale.US);
        String username_chinese=messageSource.getMessage("userName_lable",new Object[0],Locale.CHINESE);
        System.out.println("chinese:"+username_chinese);
        System.out.println("english:"+username_us);
    }
}