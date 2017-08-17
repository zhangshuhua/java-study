package com.company.javaIO;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by zsh7040 on 2017-8-16.
 */
public class SortedDirList {

    String[] list;
    // String path;

    public SortedDirList(String path,Comparator<? super String> c){
        // this.path = path;
        File file = new File(path);
        if(file.exists()){
            list = file.list();
            Arrays.sort(list,c);
        }
    }


    public String[] getList(){
        return list;
    }

    public String[] getList(String regex){
        List<String> matchList = new LinkedList<>();
        for (String fileName :list){
            if (Pattern.matches(regex,fileName)){
                matchList.add(fileName);
            }
        }
        return matchList.toArray(new String[matchList.size()]);
    }
}
