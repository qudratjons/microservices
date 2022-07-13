package com.jonson.productservice.utils;

import org.springframework.beans.BeanUtils;

public class ConvertUtils {

    private ConvertUtils() {
    }

    public static <T> T convert(Object source, T target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
