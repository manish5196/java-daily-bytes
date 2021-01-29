package com.example.uri;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(fluent = true)
@Getter
@EqualsAndHashCode
public final class StringCaseIdentifier implements CaseIdentifier{

    private final String id;

    @Override
    public String toString() {
        return id;
    }
}
