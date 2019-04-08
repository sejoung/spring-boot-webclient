package com.github.sejoung;

import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WebclientTest {


	public static void main(String[] args) throws InterruptedException {
		ExchangeStrategies strategies = ExchangeStrategies.builder()
				.codecs(configurer -> {
					configurer.defaultCodecs().enableLoggingRequestDetails(true);
				})
				.build();

		WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080")
				.exchangeStrategies(strategies)
				.build();

		Mono<ClientResponse> result = webClient.get().uri("/hello").retrieve().bodyToMono(String.class).doOnSuccess();
		result.subscribe(clientResponse -> clientResponse.bodyToMono(String.class).subscribe(WebclientTest::handleResponse)).;
		System.out.println("aaaa");

		Thread.sleep(1000);
	}

	private static void handleResponse(String body) {
		System.out.println("handle response");
		System.out.println(body);
	}


}
