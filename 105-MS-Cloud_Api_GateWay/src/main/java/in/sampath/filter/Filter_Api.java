package in.sampath.filter;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class Filter_Api implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		
		System.out.println("Filter executed...............");

		HttpHeaders headers = request.getHeaders();
		Set<String> keySet = headers.keySet();
		
		if(!keySet.contains("secret")) {
			throw new RuntimeException("You have provided invalid request");
		}

		List<String> list2 = headers.get("secret");
		if(!list2.get(0).equals("sampath@123")) {
			throw new RuntimeException("Invalid Token");
		}
		
		keySet.forEach(key -> {
			List<String> list = headers.get(key);
			System.out.println(key + "::" + list);
		});
		
		System.out.println("------------------------------------------------------");

		return chain.filter(exchange);
	}

}
