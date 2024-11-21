package com.globox.ali.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class GzipUtils {

    public static InputStream decompressGzip(InputStream inputStream) throws IOException {
        return new GZIPInputStream(inputStream);
    }
}