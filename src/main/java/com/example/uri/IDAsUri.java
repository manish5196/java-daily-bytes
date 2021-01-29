package com.example.uri;

import java.net.URI;
import java.net.URISyntaxException;

public abstract class IDAsUri implements UniversalId {
    private final String id;

    private URI __uri;

    public IDAsUri(final String id) {
        this.id = id;
    }

    @Override
    public String path() {
        return uri().getPath();
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String uriString() {
        return uri().toString();
    }

    private URI uri() {
        if (__uri == null) {
            try {
                __uri = new URI(scheme().value(), host().value(), "/" + id, null);
            } catch (final URISyntaxException e) {
                throw new RuntimeException(
                        String.format(
                                "Fail to create uri from parts: %s, %s, %s",
                                scheme().value(),
                                host().value(),
                                id
                        ),
                        e
                );
            }
        }
        return __uri;
    }
}
