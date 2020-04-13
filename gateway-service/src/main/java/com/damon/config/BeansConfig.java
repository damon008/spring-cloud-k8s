package com.damon.config;

import javax.annotation.Resource;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import reactor.core.publisher.Mono;

/**
 * @author Damon
 * @date 2018年2月2日 下午7:15:53
 */
@Configuration
public class BeansConfig {
	@Resource
	private Environment env;
	
	@LoadBalanced//就不能用ip等形式来请求其他服务
	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setReadTimeout(env.getProperty("client.http.request.readTimeout", Integer.class, 15000));
		requestFactory.setConnectTimeout(env.getProperty("client.http.request.connectTimeout", Integer.class, 3000));
		RestTemplate rt = new RestTemplate(requestFactory);
		return rt;
	}
	
	/**
	 * 
	 * 处理springboot2.x 跨域
	 * 各路由服务中无需加@CrossOrigin来处理跨域
	 * @return
	 * @author Damon 
	 * @date 2019年11月12日
	 *
	 */
	@Bean
	public CorsWebFilter corsFilter() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true); // 允许cookies跨域
		config.addAllowedOrigin("*");// #允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
		config.addAllowedHeader("*");// #允许访问的头信息,*表示全部
		config.addAllowedMethod("*");
		//config.addExposedHeader("token");
		config.setMaxAge(18000L);// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return new CorsWebFilter(source);
	}
	
	
	/**
	* 自定义限流标志的key，多个维度可以从这里入手
	* exchange对象中获取服务ID、请求信息，用户信息等
	* 
	* 此方法IP限流
	*/
	@Primary
	@Bean(value = "ipKeyResolver")
	KeyResolver ipKeyResolver() {
	    return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
	    //return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
	    //return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
	}
	
	/**
	 * API限流
	 * @return
	 * @author Damon 
	 * @date 2020年3月18日
	 *
	 */
	@Bean(value = "apiKeyResolver")
	KeyResolver apiKeyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getPath().value());
	}
	
	/**
	 * 
	 * 用户限流
	 * @return
	 * @author Damon 
	 * @date 2020年3月18日
	 *
	 */
	@Bean(value = "userKeyResolver")
	KeyResolver userKeyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));//请求路径中必须携带userId参数
	}
	
	/**
	 * 或者直接在bootstrap.yaml文件配置
	 */
	/*
	@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //增加一个path匹配，以"/customize/hello/"开头的请求都在此路由
                .route(r -> r.path("/client/**")
                //表示将路径中的第一级参数删除，用剩下的路径与webdemo的路径做拼接，
                //这里就是"lb://webdemo/hello/"，能匹配到webdemo的HelloController类的路径
                .filters(f -> f.stripPrefix(1)
                //在请求的header中添加一个key&value
                .addRequestHeader("extendtag", "geteway-" + System.currentTimeMillis()))
                //指定匹配服务webdemo，lb是load balance的意思
                .uri("lb://springcloud-k8s-client-service")
                )
                .route(r -> r.path("/admin/**")
                .filters(f -> f.stripPrefix(1)
                .addRequestHeader("extendtag", "geteway-" + System.currentTimeMillis()))
                .uri("lb://cloud-admin-service-service")
                )
                .build();
    }
    */
	
	
}
