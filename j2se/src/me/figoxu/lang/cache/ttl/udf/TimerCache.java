package me.figoxu.lang.cache.ttl.udf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by figo on 4/8/16.
 */
public class TimerCache {
    //ConcurrentSkipListMap instead of ConcurrentHashMap
    private ConcurrentHashMap<String, Entry> cache = new ConcurrentHashMap<>();
    private Thread sentinelThread;

    private ITtlCallback callback;


    public TimerCache(){
        sentinelThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        for (String key : cache.keySet()) {
                            if (cache.get(key).isExpired()) {
                                System.out.println("过期自动移除 @key:" + key + " @val:" + cache.get(key));
                                if(callback!=null){
                                    //todo call back
                                }
                                cache.remove(key);
                            }
                        }
                        Thread.sleep(TimeUnit.MINUTES.toMillis(30));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        sentinelThread.start();
    }

    /**
     * Put a new object into cache, and speicify its expiration time. Everytime we
     * get the object from cache, its expiration time would be updated.
     */
    public void put(String key, Object value, Long expiration) {
        cache.put(key, new Entry(value, expiration));
    }

    /**
     * Get instance from cache, no need to be thread-safe.
     */
    public Object get(String key) {
        Entry entry = cache.get(key);
        if (!entry.isExpired()) {
            entry.updateUseTime();
            return entry.getValue();
        } else {
            cache.remove(key);
            return null;
        }
    }

}
