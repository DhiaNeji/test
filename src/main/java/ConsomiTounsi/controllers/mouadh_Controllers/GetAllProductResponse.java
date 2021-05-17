package ConsomiTounsi.controllers.mouadh_Controllers;

import ConsomiTounsi.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {

    public GetAllProductResponse(List<Product> p) {
		this.products=p;
	}

	List<Product> products;
}
