package com.example.javaspring.chap02;

import java.io.IOException;

public interface BufferedReaderCallback<T> {
    T doSomethingWithReader(String line, T val) throws IOException;
}
