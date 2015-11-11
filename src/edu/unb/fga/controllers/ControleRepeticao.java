package edu.unb.fga.controllers;

import java.util.ArrayList;
import java.util.Arrays;

public class ControleRepeticao<T> extends ArrayList<T> {

    private static final long serialVersionUID = 1L;

    public ControleRepeticao() {
        super();
    }

    public boolean contains(Object[] obj) {
        for (T aThi : this) {
            Object[] toCompare = (Object[]) aThi;
            if (Arrays.equals(obj, toCompare)) {
                return true;
            }
        }
        return false;
    }
}
