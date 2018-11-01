package com.system.util;

import org.springframework.context.MessageSource;

/**
 * @author AllenYang
 * @date 18-10-18 下午11:23
 */
public class Example {
    private MessageSource messages;

    public void setMessages(MessageSource messages) {
        this.messages = messages;
    }

    public void execute(){
        String message = this.messages.getMessage("argument.required",new Object [] {"userDao"},"Required",null);
        System.out.println(message);
    }
}
