package io.kimmking.rpcfx.demo.consumer;

import io.kimmking.rpcfx.api.RpcInvoker;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResolver;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.kimmking.rpcfx.client.Rpcfx;
import io.kimmking.rpcfx.demo.api.Order;
import io.kimmking.rpcfx.demo.api.OrderService;
import io.kimmking.rpcfx.demo.api.User;
import io.kimmking.rpcfx.demo.api.UserService;
import io.kimmking.rpcfx.server.RpcfxInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class RpcfxClientApplication {

	public static void main(String[] args) throws Exception {

		// UserService service = new xxx();
		// service.findById
//		UserService userService = Rpcfx.create(UserService.class, "http://localhost:8090/");
		OrderService orderService = RpcInvoker.create(OrderService.class, "http://localhost:8080/");
		Order order = orderService.findOrderById(1992129);
		System.out.printf("find order name=%s, amount=%f%n", order.getName(), order.getAmount());

//		OrderService orderService = Rpcfx.create(OrderService.class, "http://localhost:8090/");
//		Order order = orderService.findOrderById(1992129);
//		System.out.println(String.format("find order name=%s, amount=%f",order.getName(),order.getAmount()));

		// 新加一个OrderService

//		SpringApplication.run(RpcfxClientApplication.class, args);
	}

}
