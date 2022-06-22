package br.com.cassunde.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.inject.Named;

import br.com.cassunde.bean.model.ProductCart;
import redis.clients.collections.ListStructure;
import redis.clients.collections.RedisStrutureBuilder;
import redis.clients.collections.SetStructure;
import redis.clients.jedis.Jedis;

@Named
public class SalesServices implements Serializable {


	private static final long serialVersionUID = 1L;

	public void save() {
		Jedis jedis = new Jedis("localhost");
//		jedis.set("foo", "bar");
//		String value = jedis.get("foo");
//		
//		System.out.println(value);
//		
		SetStructure<ProductCart> prdo = RedisStrutureBuilder.ofSet(jedis, ProductCart.class).withNameSpace("DRE").build();
//		Set<ProductCart> users = prdo.createSet("estrutura");
//
//		users.add(new ProductCart("Jurema", "Rua E 28", BigDecimal.TEN));
//		users.add(new ProductCart("Tadeu", "Rua E27", BigDecimal.valueOf(12.00)));
//		
//		System.out.println(users.size());		
		
		Set<ProductCart> createSet = prdo.createSet("estrutura");
		System.out.println(createSet.size());
	}
	
}
