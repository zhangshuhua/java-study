package com.zsh.generic;

import org.junit.Test;

/**
 * Created by zsh7040 on 2018-3-30.
 */
public class GenericTests {

    @Test
    public void testE(){
        Favorites<Number> f = new Favorites<>();
        f.putFavorite1(long.class,120L);
        f.putFavorite1(int.class,102);
        System.out.println(f.getFavoite1(long.class));
        System.out.println(f.getFavoite1(int.class));

        /*f.putFavorite(String.class,"zhangsh2");
        f.putFavorite(Integer.class,111);
        System.out.println(f.getFavoite(String.class));
        System.out.println(f.getFavoite(Integer.class));*/
    }
}
