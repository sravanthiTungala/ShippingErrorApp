package spring.mongo.shipping.errors.ShippingErrorApp.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import spring.mongo.shipping.errors.ShippingErrorApp.entity.ShippingErrors;

import java.util.List;


@Repository
public interface ShippingErrorRepo extends MongoRepository<ShippingErrors,String> {
@Query(value="{order:?0}", fields="{_id: 0, order: 1, date_time: 1, message: 1, error_code: 1, closed_date: 1, location: 1,'metadata.opid': 1}")
List<ShippingErrors> findByOrder(String orderId);
}
