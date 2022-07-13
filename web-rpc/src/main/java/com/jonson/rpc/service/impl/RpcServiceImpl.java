package com.jonson.rpc.service.impl;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.jonson.rpc.service.RpcService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@Service
@Validated
@AutoJsonRpcServiceImpl
public class RpcServiceImpl implements RpcService {

    @Override
    public String getHello(Map<String, String> request) {
        return "Hello world from " + request.get("name");
    }
}
