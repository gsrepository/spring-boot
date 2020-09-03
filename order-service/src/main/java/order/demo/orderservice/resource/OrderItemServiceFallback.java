package order.demo.orderservice.resource;

import feign.FeignException;
import feign.hystrix.FallbackFactory;
import order.demo.orderservice.entity.OrderItemData;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class OrderItemServiceFallback implements FeignClientProxy{
    @Override
    public OrderItemData getItemsByOrderId(String orderid) {
        return failover();
    }

    private OrderItemData failover(){
        OrderItemData item = new OrderItemData();
        item.setOrderItems(Arrays.asList());
        return item;
        }

    }


    //    @Override
//    public FeignClientProxy create(Throwable throwable){
//        return new FeignClientProxy(){
//            @Override
//            public OrderItemData getItemsByOrderId(String orderid) {
//                return failover();
//            }
//
//            private OrderItemData failover(){
//                if(throwable.getClass() == FeignException.class){
//                    FeignException exception = (FeignException) throwable;
//                    HttpStatus status = HttpStatus.resolve(exception.status());
//                    if(status == null){
//                        status = HttpStatus.INTERNAL_SERVER_ERROR;
//                    }
//                    OrderItemData item = new OrderItemData();
//                    item.setOrderItems(Arrays.asList());
//                    return item;
//
//                }else{
//                    OrderItemData item = new OrderItemData();
//                    item.setOrderItems(Arrays.asList());
//                    return item;
//                }
//
//            }
//        };
//    }



