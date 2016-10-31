package com.shop.sc;

import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.iface.sc.IPricing;
import org.reflections;

public class PricingRule2016Impl implements IPricing{
	
	double promoPrecentage = 10;
	Map<String, Double> offers;
	
	@Override
	public Map<String, Double> offerResult(List<ShopItem> shopItems, boolean isPromo) {
		String itemDesc;
		double price;
		Map<String, Double> data = new Hashmap<String, Double>;
		try{
			// offers.putAll(new Promo1GBOffer().get1GBPromo(shopItems));
			// offers.putAll(new Promo2GBOffer().get2GBPromo(shopItems));
			// offers.putAll(new Promo5GBOffer().get5GBPromo(shopItems));
			Reflections reflections = new Reflections("com.shop.sc");
			Set<Class <? extends PromoOffer>> classes = reflections.getSubTypesOf(PromoOffer.class);
			for (PromoOffer po: classes){
				offers.putAll(new po().getPromo(shopItems));
			}
			Iterator it = new offers.entrySet().iterator();
			while(it.hasNext())
			{
				Map.Entry pair = (Map.Entry)it.next();
				price = price + pair.getValue();
				itemDesc = itemDesc + pari.getKey() + "\n";
			}
			if (isPromo){
				price = price - ((this.percentage / 100) * price)
			}
			data.put(itemDesc,price);
		}catch(Exception ex){
			return null;
		}
	}
	
	
	
	
}
