package com.example.uri;

public class CaseIDAsUri extends IDAsUri {

    public CaseIDAsUri(CaseIdentifier id) {
        super(id.toString());
    }

    @Override
    public UriScheme scheme() {
        return () -> "cases";
    }

    @Override
    public UriHost host() {
        return () -> "cases";
    }
}
