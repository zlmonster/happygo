package com.happygo.common.service;

public interface Function<T, E> {

    public T callback(E e);

}
