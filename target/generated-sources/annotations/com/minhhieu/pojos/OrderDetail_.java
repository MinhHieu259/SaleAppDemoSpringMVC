package com.minhhieu.pojos;

import com.minhhieu.pojos.Product;
import com.minhhieu.pojos.SaleOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-24T00:52:28")
@StaticMetamodel(OrderDetail.class)
public class OrderDetail_ { 

    public static volatile SingularAttribute<OrderDetail, Long> unitPrice;
    public static volatile SingularAttribute<OrderDetail, Product> productId;
    public static volatile SingularAttribute<OrderDetail, SaleOrder> orderId;
    public static volatile SingularAttribute<OrderDetail, Integer> num;
    public static volatile SingularAttribute<OrderDetail, Integer> id;

}