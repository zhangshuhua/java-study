package com.zsh.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zsh7040 on 2018-3-30.
 */
public  class  Favorites<E> {


    private Map<Class<?>,Object> favorites1 = new HashMap<>();
    private Map<Class<? extends E>,E> favorites = new HashMap<>();

    /*public <T> void putFavorite(Class<T> type,T instance){
        if(type==null){
            throw new NullPointerException("type=null");
        }
        favorites1.put(type,instance);
    }

    public <T> T getFavoite(Class<T> type){
        return type.cast(favorites1.get(type));
    }*/

    public <Sub extends E> void  putFavorite1(Class<Sub> type,Sub instance){
        if(type==null){
            throw new NullPointerException("type=null");
        }
        favorites.put(type,instance);
    }

    public <Sub extends E> E getFavoite1(Class<Sub> type){
        return favorites.get(type);
    }
}
