package in.sampath.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sampath.binding.Order;
import in.sampath.service.Service;

@RestController
public class orderrestcontroller {

	@Autowired
	private Service service;

	@PostMapping("/order")
	public String createOrder(@RequestBody Order order) {
		String msg = service.addMsg(order);
		return msg;
	}

}
