package com.demo2.demo2.IService;

public interface IService<T> {
    public T post(T t);
    public T[] get();
    public String test();
}
