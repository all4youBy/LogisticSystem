package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Truck.class)
public abstract class Truck_ {

	public static volatile SingularAttribute<Truck, Integer> carryingCapacity;
	public static volatile SingularAttribute<Truck, Integer> currentCapacity;
	public static volatile SingularAttribute<Truck, String> onTheWay;
	public static volatile SingularAttribute<Truck, String> name;
	public static volatile SingularAttribute<Truck, Integer> id;
	public static volatile SingularAttribute<Truck, Stock> stockByStockId;

}

