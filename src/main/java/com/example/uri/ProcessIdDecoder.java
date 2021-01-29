package com.example.uri;

import com.google.common.io.BaseEncoding;

public class ProcessIdDecoder {

    public static String decode(String encodeProcessId) {
        return new String(
                BaseEncoding
                        .base64Url()
                        .omitPadding()
                        .decode(encodeProcessId)
        );
    }
}
