package spring.mongo.shipping.errors.ShippingErrorApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.mongo.shipping.errors.ShippingErrorApp.entity.ShippingErrors;
import spring.mongo.shipping.errors.ShippingErrorApp.repo.ShippingErrorRepo;

import java.util.List;

@Service
public class ShippingErrorService {
    @Autowired
    private ShippingErrorRepo shippingErrorRepo;
    List<ShippingErrors> shippingErrorsList;

    public List<ShippingErrors> getShippingErrorByOrderId(String orderId) {
        shippingErrorsList=shippingErrorRepo.findByOrder(orderId);
        System.out.println(shippingErrorsList);
        return shippingErrorsList;
    }

}
