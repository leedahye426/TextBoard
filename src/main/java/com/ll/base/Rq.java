package com.ll.base;

import com.ll.standard.util.Ut;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rq {
    private String cmd;
    private String queryString;
    @Getter
    private String action;

    private Map<String, String> paramsMap;

    public Rq(String cmd) {
        //삭제?id=23&age=55
        paramsMap = new HashMap<>();

        this.cmd = cmd;

        String[] cmdBits = cmd.split("\\?", 2);
        action = cmdBits[0].trim(); //삭제

        if(cmdBits.length == 1) {
            return;
        }

        queryString = cmdBits[1].trim(); //id=23&age=55


        String[] queryStringBits = queryString.split("&"); //["id=23","age=55"]

        for (int i = 0; i < queryStringBits.length; i++) {
            String queryParamStr = queryStringBits[i];
            String[] queryParamStrBits = queryParamStr.split("=", 2);

            String paramName = queryParamStrBits[0]; //id
            String paramValue = queryParamStrBits[1]; //22

            paramsMap.put(paramName, paramValue);
        }
    }


    public int getParamAsInt(String paramName, int defaultValue) {
        return Ut.str.parseInt(paramsMap.get(paramName), defaultValue);
    }
}
