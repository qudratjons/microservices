# This is simple RPC example.
## Dependency
        <dependency>
            <groupId>com.github.briandilley.jsonrpc4j</groupId>
            <artifactId>jsonrpc4j</artifactId>
            <version>1.6</version>
        </dependency>
        <dependency>
            <groupId>javax.jws</groupId>
            <artifactId>jsr181-api</artifactId>
            <version>1.0-MR1</version>
        </dependency>

## Config
Inside JsonRpcConfig class created bean type of AutoJsonRpcServiceImplExporter

## Service
Created RpcService interface and annotated with @JsonRpcService("/api/rpc").
RpcServiceImpl implements RpcService and annotated with @Service @Validated @AutoJsonRpcServiceImpl

## RPC request body example
    {
        "id": 1,
        "jsonrpc": "2.0",
        "method": "hello.world",
        "params": {
            "request": {
                "name": "Jonsonbaby"
            }
        }
    }

## RPC response body example
    {
        "jsonrpc": "2.0",
        "id": 1,
        "result": "Hello world from Jonsonbaby",
        "error": null
    }