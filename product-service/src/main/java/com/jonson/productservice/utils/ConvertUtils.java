package com.jonson.productservice.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ConvertUtils {

    private final ModelMapper modelMapper;

    public ConvertUtils() {
        this.modelMapper = new ModelMapper();
    }

    public <T> T convert(Object source, Class<T> type) {
        return modelMapper.map(source, type);
    }
}
