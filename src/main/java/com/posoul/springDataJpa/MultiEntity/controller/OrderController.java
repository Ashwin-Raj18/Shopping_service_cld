package com.posoul.springDataJpa.MultiEntity.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.posoul.springDataJpa.MultiEntity.dto.CustomerCart;
import com.posoul.springDataJpa.MultiEntity.dto.OrderRequest;
import com.posoul.springDataJpa.MultiEntity.dto.OrderResponse;
import com.posoul.springDataJpa.MultiEntity.dto.ProductDetails;
import com.posoul.springDataJpa.MultiEntity.entities.Customer;
import com.posoul.springDataJpa.MultiEntity.entities.Product;
import com.posoul.springDataJpa.MultiEntity.repository.CustomerRepository;
import com.posoul.springDataJpa.MultiEntity.repository.ProductRepository;

@RestController
public class OrderController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/placeOrder")
	public void placeOrder(@RequestBody OrderRequest order) {
		final Customer customer = new Customer();
		customer.setEmail(order.getCustomer().getEmail());
		customer.setGender(order.getCustomer().getGender());
		customer.setName(order.getCustomer().getName());
		List<Product> products = new ArrayList<Product>();
		for(Product p : order.getCustomer().getProducts()) {
			Product prod = new Product();
			prod.setPrice(p.getPrice());
			prod.setProductName(p.getProductName());
			prod.setQuantity(p.getQuantity());
			prod.setCustomer(customer);
			products.add(prod);
		}
		customer.setProducts(products);
		customerRepository.save(customer);
		
	}
	
	@GetMapping("/findAllOrders")
	public List<CustomerCart> findAllOrders(){
		List<Customer> cl = customerRepository.findAll();
		List<CustomerCart> ol = new  ArrayList<CustomerCart>();
		
		for(Customer c : cl) {
			CustomerCart cc = new CustomerCart();
			cc.setcId(c.getCustId());
			cc.setCustomerName(c.getName());			
			List<ProductDetails> pdl = new ArrayList<ProductDetails>();
			for(Product p : c.getProducts()) {
				ProductDetails pd= new ProductDetails(); 
				pd.setpId(p.getPId());
				pd.setpName(p.getProductName());
				pd.setpQuantity(p.getQuantity());
				pdl.add(pd);
			}
			cc.setpDetails(pdl);
			ol.add(cc);
		}

		return ol;
		
	}
	
	@GetMapping("/getCart/{custId}")
	public CustomerCart getCartByCustId(@PathVariable("custId") int custId) {
		 Optional<Customer> customer = customerRepository.findById(custId);
		 CustomerCart cc= new CustomerCart();
		 
		 if(customer.isPresent()) {
			 cc.setcId(customer.get().getCustId());
			 cc.setCustomerName(customer.get().getName());
			 List<ProductDetails> pds = new ArrayList<ProductDetails>();
			 for(Product p : customer.get().getProducts()) {
				 ProductDetails pd = new ProductDetails();
				 pd.setpId(p.getPId());
				 pd.setpName(p.getProductName());
				 pd.setpQuantity(p.getQuantity());
				 pds.add(pd);
			 }
			 cc.setpDetails(pds);
		 }
		 return cc;
	}
	
	//pending work
	@PostMapping("/updatecart/{cId}")
	public void updateCart(@RequestBody List<ProductDetails> pd, @PathVariable int cId ) {
		Optional<Customer> customer = customerRepository.findById(cId);
		
		//customer.get().getProducts().add();
		
	}
	@GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return (List<OrderResponse>) customerRepository.getJoinInformation();
    }
	
}
