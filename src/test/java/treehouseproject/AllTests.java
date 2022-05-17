package treehouseproject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import com.bolton.treehouseproject.domains.Item;
import com.bolton.treehouseproject.domains.User;
import com.bolton.treehouseproject.itemfactory.ItemFactory;
import com.bolton.treehouseproject.repositories.ItemRepository;
import com.bolton.treehouseproject.repositories.UserRepository;
import com.bolton.treehouseproject.services.DiscountService;
import com.bolton.treehouseproject.services.ModelAttributeService;
import com.bolton.treehouseproject.services.UserService;

class AllTests {
	
	@Rule
    public MockitoRule rule = MockitoJUnit.rule();
	
	User userEntity = new User();
	
	private Set<Item> shoppingCart = new HashSet<Item>();
	
	double Total = 0;
	
	Item item = new Item();
	
	@Mock
	UserService userService;
	
	@Mock
	ModelAttributeService modelAttributeService;
	
	@Mock
	DiscountService discountService;
	
	@Mock
	ItemFactory itemFactory;
	
	@Mock
	PasswordEncoder passwordEncoder;
	
	public void setUp() {
		userService = mock(UserService.class);
		modelAttributeService = mock(ModelAttributeService.class);
		discountService = mock(DiscountService.class);
		itemFactory = mock(ItemFactory.class);
		passwordEncoder = mock(PasswordEncoder.class);
		
		item.setItemTitle("Item 1");
		item.setItemPrice(5.99);
		
		userEntity.setUserName("Cameron");
		userEntity.setUserEmail("cfpixel11@gmail.com");
		userEntity.setUserPass("14289kat!2D");
	}

	@Test
	public void LoginTestCase() {
		setUp();
		
		when(userService.validateUserDetails(userEntity.getUserEmail(), userEntity.getUserPass())).thenReturn((userEntity.getUserName()));
		String userName = userService.validateUserDetails(userEntity.getUserEmail(), userEntity.getUserPass());
		
		if (userName == null) {
			
			fail("Invalid login input");
		}
		
		return;
		
	}
	
	@Test
	public void AddToCartTest() {
		setUp();
		
		if (item.getItemTitle().equalsIgnoreCase("Item 1")){
	
			shoppingCart.add(item);
			Total += item.getItemPrice();
		}
		
		return;
	}
	
	@Test
	void DisplayCartTest() {
		setUp();
		
		AddToCartTest();
		
		System.out.println(shoppingCart);
	}
	
	@Test
	void RemoveFromCartTest() {
		setUp();
		
		if (item.getItemTitle().equalsIgnoreCase("Item 1")){
	
			shoppingCart.remove(item);
			Total = Total - item.getItemPrice();
		}
		
		return;
	}
}
