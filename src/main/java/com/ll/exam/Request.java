package com.ll.exam;

import java.util.HashMap;
import java.util.Map;

public class Request {
    String cmd;
    String path;
    Map<String, String> queryParams;
    public Request(String cmd) {
        this.cmd = cmd;
        String[] cmdBits = cmd.split("\\?", 2);
        this.path = cmdBits[0];

        queryParams = new HashMap<>();

        if(cmdBits.length == 2) {
            String queryStr = cmdBits[1];

            String[] paramBits = queryStr.split("&");
            for(String paramBit : paramBits) {
                String[] paramNameAndValue = paramBit.split("=", 2);

                if(paramNameAndValue.length == 1) {
                    continue;
                }

                String paramName = paramNameAndValue[0].trim();
                String paramValue = paramNameAndValue[1].trim();

                queryParams.put(paramName, paramValue);
            }
        }
    }

    public int getIntParam(String paramName, int defaultValue) {
        if(queryParams.containsKey(paramName) == false) {
            return defaultValue;
        }
        String paramValue = queryParams.get(paramName);

        if(paramValue.length() == 0) {
            return defaultValue;
        }
        return Integer.parseInt((paramValue));
    }

    public String getPath() {
        return path;
    }
}
