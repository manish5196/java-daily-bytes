package com.example.concurrency;

import org.hibernate.internal.util.collections.ConcurrentReferenceHashMap;

import java.util.concurrent.ConcurrentMap;

public class XMutexFactory<KeyT> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    private static final ConcurrentReferenceHashMap.ReferenceType DEFAULT_REFERENCE_TYPE =
            ConcurrentReferenceHashMap.ReferenceType.WEAK;

    private final ConcurrentMap<KeyT, XMutex<KeyT>> map;

    /**
     * Create a mutex factory with default settings
     */
    public XMutexFactory() {
        this.map = new ConcurrentReferenceHashMap<>(DEFAULT_INITIAL_CAPACITY,
                DEFAULT_LOAD_FACTOR,
                DEFAULT_CONCURRENCY_LEVEL,
                DEFAULT_REFERENCE_TYPE,
                DEFAULT_REFERENCE_TYPE,
                null);
    }

    /**
     * Creates and returns a mutex by the key.
     * If the mutex for this key already exists in the weak-map,
     * then returns the same reference of the mutex.
     */
    public XMutex<KeyT> getMutex(KeyT key) {
        return this.map.computeIfAbsent(key, XMutex::new);
    }

    /**
     * @return count of mutexes in this factory.
     */
    public long size() {
        return this.map.size();
    }

    /**
     * Remove any entries that have been garbage collected and are no longer referenced.
     * Under normal circumstances garbage collected entries are automatically purged
     * when new items are created by a factory. This method can be used to force a purge.
     */
    public void purgeUnreferenced() {
        ((ConcurrentReferenceHashMap) this.map).purgeStaleEntries();
    }
}
