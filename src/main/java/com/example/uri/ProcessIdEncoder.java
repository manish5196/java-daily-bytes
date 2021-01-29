package com.example.uri;

import com.google.common.io.BaseEncoding;

public class ProcessIdEncoder {

    public static String encode(ProcessId processId) {
        return BaseEncoding
                .base64Url()
                .omitPadding()
                .encode(processId.toString().getBytes());
    }
}
