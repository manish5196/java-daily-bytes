package com.example.uri;

import java.util.UUID;

public class TestUri {

    public static void main(String[] args) {
//        CaseIDAsUri caseIDAsUri = new CaseIDAsUri(new StringCaseIdentifier(UUID.randomUUID().toString()));
//        System.out.println(String.format(
//                    "Id: [%s] \n" +
//                            "scheme: [%s] \n" +
//                            "host: [%s] \n" +
//                            "path: [%s] \n" +
//                            "uriString: [%s]",
//                caseIDAsUri.id(), caseIDAsUri.scheme().value(),
//                caseIDAsUri.host().value(), caseIDAsUri.path(), caseIDAsUri.uriString()));
        UUID processId = UUID.randomUUID();
        CaseIdentifier caseIdentifier = new StringCaseIdentifier(UUID.randomUUID().toString());
        String encodedString  = ProcessIdEncoder.encode(new ProcessId(caseIdentifier, processId));
        System.out.println(encodedString);
        System.out.println(ProcessIdDecoder.decode(encodedString));

    }
}
