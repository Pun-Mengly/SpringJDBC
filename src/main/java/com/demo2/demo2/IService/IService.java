package com.demo2.demo2.IService;

public interface IService<K,T> {
    public K post(T t);
    public T[] get();
    public String welcome();
}
