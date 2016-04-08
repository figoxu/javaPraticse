package me.figoxu.lang.cache.ttl.udf;

/**
 * Created by figo on 4/8/16.
 */
public class Entry {
    private final Object value;
    private final Long expiration;
    private Long lastUseTime;

    public Entry(Object value, Long expiration) {
        this.value = value;
        this.expiration = expiration;
        this.lastUseTime = System.currentTimeMillis();
    }

    public boolean isExpired() {
        return (lastUseTime + expiration) < System.currentTimeMillis();
    }

    public Object getValue() {
        return this.value;
    }

    public void updateUseTime() {
        this.lastUseTime = System.currentTimeMillis();
    }
}
