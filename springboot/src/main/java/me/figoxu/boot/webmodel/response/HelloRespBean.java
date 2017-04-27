package me.figoxu.boot.webmodel.response;

/**
 * Created by figo on 2/22/17.
 */
public class HelloRespBean {
    private String foo;
    private Integer bar;
    private Float money;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public Integer getBar() {
        return bar;
    }

    public void setBar(Integer bar) {
        this.bar = bar;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
}
