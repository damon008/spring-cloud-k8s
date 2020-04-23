# spring-cloud-k8s
利用k8s实现微服务架构设计，包括网关、鉴权、负载均衡、配置管理、熔断、流控等。

# 环境准备

1. K8S 环境

2. command test: order-servide ---->  admin-web

curl -i -H "Accept: application/json" -X GET http://10.10.1.80:5555/order-service/api/order/getUserInfo


3. 本次提供基于网关的限流功能、基于k8s ConfigMap实现配置管理、基于k8s的Service实现服务发现功能，以及基于Ribbon的LB 、基于Hystrix的熔断机制


#### 参与贡献

## 欢迎关注

![输入图片说明](https://images.gitee.com/uploads/images/2020/0414/104902_aa07fda5_1459921.jpeg "qrcode_for_gh_5f5844a6d00e_344.jpg")
