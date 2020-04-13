#!/bin/bash
#
# Copyright (c) Microsoft Corporation
# All rights reserved.
#
# MIT License
#
# Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
# documentation files (the "Software"), to deal in the Software without restriction, including without limitation
# the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
# to permit persons to whom the Software is furnished to do so, subject to the following conditions:
# The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
# BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
# NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
# DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

#dirname "$0"显示当前目录
pushd $(dirname "$0") > /dev/null       #/dev/null是一个垃圾回收站

if kubectl get deployment | grep -q "order-service-deployment"; then
    kubectl delete deployment order-service-deployment || exit $?
fi

if kubectl get svc | grep -q "order-service-service"; then
    kubectl delete svc order-service-service || exit $?
fi

if kubectl get cm | grep -q "order-service"; then
    kubectl delete cm order-service || exit $?
fi

if kubectl get  ClusterRoleBinding | grep -q "fabric8-rbac"; then
    kubectl delete ClusterRoleBinding fabric8-rbac || exit $?
fi

sleep 5

popd > /dev/null