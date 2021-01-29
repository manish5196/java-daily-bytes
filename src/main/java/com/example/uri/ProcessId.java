package com.example.uri;

import lombok.Getter;

import java.util.StringJoiner;
import java.util.UUID;

@Getter
public class ProcessId {

    private final String SEPARATOR = "|";

    private final CaseIdentifier caseIdentifier;
    private final UUID processId;

    public ProcessId(CaseIdentifier caseIdentifier, UUID processId) {
        this.caseIdentifier = caseIdentifier;
        this.processId = processId;
    }

    @Override
    public String toString() {
        return new StringJoiner(SEPARATOR, "", "")
                .add(caseIdentifier.id())
                .add(processId.toString())
                .toString();
    }
}
