package com.zsh.javaIO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by zsh7040 on 2017-8-16.
 */
public class FileStudy {
    //oo模式中有main方法的就是客户类，客户类可以随便改
    public static void main(String[] args) {
        File path = new File("E:\\chrome下载");
        String[] list;
        list = path.list();
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        FilenameFilter dirFilter = new DirFilter(".*.doc");
        for (String fileName:list){
            if (dirFilter.accept(null,fileName)){
                System.out.println(fileName);
            }
        }
    }
}

/**
 * 这是一个文档过滤类，使用这个类在构造方法中直接指定regex就行，
 * 而不是在这里面硬编码，硬生生写出regex
 */
class DirFilter implements FilenameFilter{


    //有点策略模式的感觉，委托pattern去处理，而不是自己
    private Pattern pattern;
    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
