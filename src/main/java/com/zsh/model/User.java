package com.zsh.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zsh7040 on 2018-4-24.
 */
public class User {

    private Integer id;

    private String score;

    public User(Integer id, String score) {
        this.id = id;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}

class test{
    /**
     * list转map通用方法
     */
    public static Map list2Map(List<User> list) {
        Map<Integer, List<String>> map = new HashMap<>();
        if (list != null) {
            for (User user:list) {
                Integer id = user.getId();
                String score = user.getScore();
                if(map.containsKey(id)){
                    map.get(id).add(score);
                }else {
                    map.put(id,new ArrayList<>());
                    map.get(id).add(score);
                }

            }
        }
        return map;
    }

    public static void main(String[] args) {
        User user = new User(1,"5分");
        User user1 = new User(1,"8分");
        User user2 = new User(2,"5分");
        User user3 = new User(1,"10分");
        User user4 = new User(2,"20分");
        User user5 = new User(3,"5分");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        Map map = list2Map(users);
        System.out.println(map);
    }
}
