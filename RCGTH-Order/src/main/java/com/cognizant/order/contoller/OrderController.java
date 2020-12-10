package com.cognizant.order.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.order.clients.ProfileClient;
import com.cognizant.order.entity.Orders;
import com.cognizant.order.entity.Product;
import com.cognizant.order.exception.ProductNotFoundException;
import com.cognizant.order.model.Profile;
import com.cognizant.order.repository.ProductRepository;
import com.cognizant.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ProfileClient profileClient;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/getAllProfile")
	public List<Profile>getAllProfile(){
		return profileClient.getAllProfiles();
	}
	
	@GetMapping("/{profileId}/{productId}")
	public Orders placeOrder(@PathVariable int profileId,@PathVariable int productId) throws ProfileNotFoundException, ProductNotFoundException {
		
		List<Profile> allProfiles = profileClient.getAllProfiles();
		System.out.println(allProfiles);
		Profile myProfile=null;
		Product myProduct=null;
		for (Profile profile : allProfiles) {
			if(profile.getProfileid()==profileId) {
				myProfile=profile;
				break;
			}
		}
		System.out.println(myProfile);
		if(myProfile==null)
			throw new ProfileNotFoundException("Profile Not found");
		Optional<Product> product = productRepository.findById(productId);
		
		if(product.isPresent())
			myProduct=product.get();
		else {
			throw new ProductNotFoundException("Product Not Found");			
		}
		
		System.out.println(myProduct);
		
		Orders myOrder=new
				Orders(myProduct.getProductId(), myProduct.getProductName(),
						myProduct.getProductPrice(), myProfile.getProfileid(), myProfile.getProfilename(), myProfile.getProfiletype());
		
		return orderService.saveOrders(myOrder);
		
		
	}
}
