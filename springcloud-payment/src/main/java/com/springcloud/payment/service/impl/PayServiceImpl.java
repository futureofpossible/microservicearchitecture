package com.springcloud.payment.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.common.entity.Payment;
import com.springcloud.payment.dao.PaymentDao;
import com.springcloud.payment.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class PayServiceImpl implements PayService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int savePayment(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> getPayments() {
        return paymentDao.getPayments();
    }

    @Override
    public String pay() {
        return "线程id为" + Thread.currentThread().getId() + ",线程名称为" + Thread.currentThread().getName() + ",pay";
    }

    @Override
    @HystrixCommand(fallbackMethod = "payTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),//线程隔离策略
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String payTimeout() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程id为" + Thread.currentThread().getId() + ",线程名称为" + Thread.currentThread().getName() + ",payTimeout";
    }

    public String payTimeoutHandler() {
        return "支付超时,正在处理中,系统繁忙,请稍后再试";
    }

    @Override
    @HystrixCommand(fallbackMethod = "payCircuitBreakerHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
            @HystrixProperty(name = "circuitBreaker.forceOpen", value = "false"),
            @HystrixProperty(name = "circuitBreaker.forceClosed", value = "false")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "2"),//核心线程数大小
            @HystrixProperty(name = "maximumSize", value = "4"),//最大线程数大小
            @HystrixProperty(name = "maxQueueSize", value = "4"),//最大队列数大小
            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "5"),//队列大小拒绝阈值
            @HystrixProperty(name = "keepAliveTimeMinutes", value = "1"),//线程在被释放之前将被闲置多长时间
            @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "false"),//允许maximumSize 的配置生效。 然后该值可以等于或高于 coreSize
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"),//统计滚动窗口的持续时间，以毫秒为单位。
            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "10")
    })
    public String payCircuitBreaker() {
        return null;
    }

    public String payCircuitBreakerHandler() {
        return "断路器";
    }
}
