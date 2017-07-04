package com.cinema.web;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator {

    public boolean isValidPassword(String password) {
        if (password.length() < 6) {
            return  false;
        }
        boolean letterFlag = false;
        boolean numFlag = false;
        boolean noFlag = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) <= 'Z' && password.charAt(i) >= 'A' ||
                password.charAt(i) <= 'z' && password.charAt(i) >= 'a') {
                letterFlag = true;
            } else if (password.charAt(i) <= '9' && password.charAt(i) >= '0') {
                numFlag = true;
            } else if (password.charAt(i) == '.' || password.charAt(i) == '/') {
            	noFlag = true;
            }
        }
        return (letterFlag && numFlag && noFlag);
    }

}
