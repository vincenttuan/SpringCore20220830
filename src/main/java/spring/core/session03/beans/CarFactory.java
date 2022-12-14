package spring.core.session03.beans;

import java.util.Random;

import org.springframework.beans.factory.FactoryBean;

public class CarFactory implements FactoryBean<Car> {

	@Override
	public Car getObject() throws Exception {
		Random random = new Random();
		Car car = new Car();
		car.setName("BMW");
		car.setPrice(random.nextInt(600_0000));
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return true; // false 支援 Prototype
	}
	
}
