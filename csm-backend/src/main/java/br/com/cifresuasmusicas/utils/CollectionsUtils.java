package br.com.cifresuasmusicas.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class CollectionsUtils {

    private CollectionsUtils() {
        throw new IllegalStateException("Collections Utility class");
    }

    public static <T> Set<T> convertListToSet(List<T> list) {
        return new HashSet<>(list);
    }

    public static <T> List<T> convertSetToList(Set<T> set) {
        return new ArrayList<>(set);
    }
}