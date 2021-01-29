package com.example.uri;

public interface UniversalId {
    UriScheme scheme();

    UriHost host();

    String path();

    String id();

    String uriString();
}
