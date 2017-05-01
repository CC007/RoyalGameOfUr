package com.github.cc007.royalgameofur;

import com.github.cc007.royalgameofur.model.Board;

/**
 * Created by Rik on 1-5-2017.
 */
public interface View {
    public void init(Board board);
    public void waitUntil(String waitCause);
    public <T> void setValue(String valueName, T value);
    public <T> T getValue(String valueName, Class<T> clazz);
}
