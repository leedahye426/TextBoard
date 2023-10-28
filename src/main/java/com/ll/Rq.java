package com.ll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rq {
    String cmd;
    String queryString;
    String action;

    List<String> paramNames;
    List<String> paramValues;

    Rq(String cmd) {
        //삭제?id=23&age=55
        paramNames = new ArrayList<>();
        paramValues = new ArrayList<>();

        this.cmd = cmd;

        String[] cmdBits = cmd.split("\\?", 2);
        action = cmdBits[0].trim(); //삭제
        queryString = cmdBits[1].trim(); //id=23&age=55

        String[] queryStringBits = queryString.split("&"); //["id=23","age=55"]

        for (int i = 0; i < queryStringBits.length; i++) {
            String queryParamStr = queryStringBits[i];
            String[] queryParamStrBits = queryParamStr.split("=", 2);

            String paramName = queryParamStrBits[0]; //id
            String paramValue = queryParamStrBits[1]; //22

            paramNames.add(paramName);
            paramValues.add(paramValue);

        }


    }

    String getAction() {
        return action;
    }


    int getParamAsInt(String paramName, int defaultValue) {
        int index = paramNames.indexOf(paramName);

        if (index == -1) return defaultValue;

        String paramValue = paramValues.get(index);

        try {
            return Integer.parseInt(paramValue);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
