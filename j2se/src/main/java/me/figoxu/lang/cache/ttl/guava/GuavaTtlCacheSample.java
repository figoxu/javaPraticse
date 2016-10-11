package me.figoxu.lang.cache.ttl.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 固定时常的cache
 * http://ifeve.com/google-guava-cachesexplained/
 * Created by figo on 16-4-8.
 */
public class GuavaTtlCacheSample {

    private static GuavaTtlCacheSample gt = new GuavaTtlCacheSample();

    public static GuavaTtlCacheSample getInstance(){
        return gt;
    }
    private LoadingCache<String,String> cache;

    private GuavaTtlCacheSample() {
        cache = CacheBuilder
                .newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS)  //important configure
                .build(new CacheLoader<String, String>(){
                    @Override
                    public String load(String key) throws Exception {
                        System.out.print("   --> load from db   [result] ==> ");
                        return key.toUpperCase();
                    }
                });
    } 

    public String getCache(String args) throws ExecutionException {
        System.out.print("current cache size:"+cache.size()+" current cache val : ");
        return cache.get(args);
    }

    public static void main(String[] args) {
        GuavaTtlCacheSample gt = GuavaTtlCacheSample.getInstance();
        try {
            System.out.println(gt.getCache("java"));
            System.out.println(gt.getCache("figo"));
            System.out.println(gt.getCache("java"));
            System.out.println(gt.getCache("figo"));
            Thread.sleep(2100);
            System.out.println(gt.getCache("java"));
            System.out.println(gt.getCache("figo"));
            Thread.sleep(1000);
            System.out.println(gt.getCache("java"));
            System.out.println(gt.getCache("figo"));

        } catch (ExecutionException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
