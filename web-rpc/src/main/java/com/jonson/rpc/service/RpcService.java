package com.jonson.rpc.service;

import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

import java.util.Map;

@JsonRpcService("/api/rpc")
public interface RpcService {

    @JsonRpcMethod("hello.world")
    String getHello(@JsonRpcParam(value = "request") Map<String, String> request);
}
