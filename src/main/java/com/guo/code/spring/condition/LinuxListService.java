package com.guo.code.spring.condition;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class LinuxListService implements ListService {
    @Override
    public String getListCmd() {
        return "ls";
    }
}
