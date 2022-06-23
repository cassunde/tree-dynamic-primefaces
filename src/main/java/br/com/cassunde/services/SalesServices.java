package br.com.cassunde.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.cassunde.bean.model.ItemOrcamento;
import redis.clients.collections.RedisStrutureBuilder;
import redis.clients.collections.SetStructure;
import redis.clients.jedis.Jedis;

@Named
public class SalesServices implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Inject
	private Jedis jedis;

	
	public void createData() {
		
		List<ItemOrcamento> itensRetornadosDoBanco =  new ArrayList<ItemOrcamento>();
		
		SetStructure<ItemOrcamento> itemDreStructure = RedisStrutureBuilder.ofSet(jedis, ItemOrcamento.class).withNameSpace("CACHE_DRE").build();
		Set<ItemOrcamento> itensDre = itemDreStructure.createSet("20");

		itensRetornadosDoBanco.stream().forEach(i -> itensDre.add(i));

	}
	
	public void getAllData() {
		SetStructure<ItemOrcamento> itemDreStructure = RedisStrutureBuilder.ofSet(jedis, ItemOrcamento.class).withNameSpace("CACHE_DRE").build();
		Set<ItemOrcamento> products = itemDreStructure.createSet("20");
		System.out.println(products.size());
	}
}
