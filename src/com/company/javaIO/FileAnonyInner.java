package com.company.javaIO;

import java.io.File;
import java.io.FilenameFilter;
import java.net.SocketPermission;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by zsh7040 on 2017-8-16.
 */
public class FileAnonyInner {
    //使用匿名内部类

    public static FilenameFilter filter(final String regex) {
        //final的形参的作用：匿名内部类就得这样
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        /*File path = new File("E:\\chrome下载");
        String[] list;
        list = path.list(filter(".*.doc"));
        Arrays.sort(list);
        // FilenameFilter dirFilter = new DirFilter("");
        for (String fileName:list){
                System.out.println(fileName);
        }*/

        SortedDirList sortedDirList = new SortedDirList("E:\\chrome下载",String.CASE_INSENSITIVE_ORDER);

        String[] allList = sortedDirList.getList();

        String[] matchList = sortedDirList.getList(".*.doc");

        int a = 1;


    }
}
