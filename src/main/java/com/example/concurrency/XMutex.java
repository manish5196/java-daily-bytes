package com.example.concurrency;

import java.util.Objects;

public class XMutex<KeyT> {

    private final KeyT key;

    public XMutex(KeyT key) {
        this.key = key;
    }


    public static <KeyT> XMutex<KeyT> of(KeyT key) {
        return new XMutex<>(key);
    }

    public KeyT getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XMutex<?> xMutex = (XMutex<?>) o;
        return Objects.equals(key, xMutex.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
