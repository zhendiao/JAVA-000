package io.github.kimmking.gateway.router;

import java.util.List;

public class HttpEndpointRouterImpl implements HttpEndpointRouter {
    @Override
    public String route(String endpoint) {

            if (endpoint.contains("test")){
                return  endpoint+"/test";
            }else{
                return endpoint;
            }

    }
}
