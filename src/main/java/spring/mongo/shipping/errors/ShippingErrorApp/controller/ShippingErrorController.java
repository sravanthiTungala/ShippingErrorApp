package spring.mongo.shipping.errors.ShippingErrorApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.mongo.shipping.errors.ShippingErrorApp.entity.ShippingErrors;
import spring.mongo.shipping.errors.ShippingErrorApp.service.ShippingErrorService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/shippingErrors")
public class ShippingErrorController {
    @Autowired
    private ShippingErrorService shippingErrorService;
    @RequestMapping("/getShippingErrorsById/{id}")
    private List<ShippingErrors> getErrorsByOrderId(@PathVariable(name = "id")String orderId){
        return shippingErrorService.getShippingErrorByOrderId(orderId);
    }
}
