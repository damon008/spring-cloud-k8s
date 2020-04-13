# spring-cloud-k8s
利用k8s实现微服务架构设计，包括网关、鉴权、负载均衡、配置管理、熔断、流控等。

# 环境准备

1. K8S 环境

2. command test: order-servide ---->  admin-web

curl -i -H "Accept: application/json" -X GET http://10.10.1.80:5555/order-service/api/order/getUserInfo


3. 本次提供基于网关的限流功能、基于k8s ConfigMap实现配置管理、基于k8s的Service实现服务发现功能，以及基于Ribbon的LB 、基于Hystrix的熔断机制

4. 欢迎关注公众号：程序猿Damon
