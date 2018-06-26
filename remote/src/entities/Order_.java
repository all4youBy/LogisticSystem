package entities;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Date> dateDelivery;
	public static volatile SingularAttribute<Order, Customer> customerByCustomerId1;
	public static volatile SingularAttribute<Order, String> address;
	public static volatile SingularAttribute<Order, Truck> truckByTruckId1;
	public static volatile SingularAttribute<Order, Date> dateOrder;
	public static volatile SingularAttribute<Order, Integer> cargoQuantity;
	public static volatile SingularAttribute<Order, Integer> id;
	public static volatile SingularAttribute<Order, String> orderState;

}

