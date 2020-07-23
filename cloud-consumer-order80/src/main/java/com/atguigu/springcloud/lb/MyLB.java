package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyLB
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/18 21:53
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        for (; ; ) {
            current = this.atomicInteger.get();
            next = current > 2147483647 ? 0 : current + 1;
            if (atomicInteger.compareAndSet(current, next)) {
                System.out.println(next);
                return next;
            }
        }
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int andIncrement = getAndIncrement();
        int index = andIncrement % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
