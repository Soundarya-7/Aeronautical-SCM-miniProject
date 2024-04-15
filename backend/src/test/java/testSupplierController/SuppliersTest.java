package testSupplierController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.controller.SupplierController;
import com.example.demo.model.Suppliers;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(SupplierController.class)
@AutoConfigureMockMvc
public class SuppliersTest {
	
	

	@Test
    public void testConstructorAndGetters() {
        // Arrange
        Integer id = 1;
        String name = "SupplierName";
        String address = "SupplierAddress";
        Long phoneNumber = 1234567890L;

        // Act
        Suppliers supplier = new Suppliers(id, name, address, phoneNumber);

        // Assert
        assertNotNull(supplier);
        assertEquals(id, supplier.getId());
        assertEquals(name, supplier.getName());
        assertEquals(address, supplier.getAddress());
        assertEquals(phoneNumber, supplier.getPhoneNumber());
    }

    @Test
    public void testSetters() {
        // Arrange
        Suppliers supplier = new Suppliers();
        Integer id = 1;
        String name = "SupplierName";
        String address = "SupplierAddress";
        Long phoneNumber = 1234567890L;

        // Act
        supplier.setId(id);
        supplier.setName(name);
        supplier.setAddress(address);
        supplier.setPhoneNumber(phoneNumber);

        // Assert
        assertEquals(id, supplier.getId());
        assertEquals(name, supplier.getName());
        assertEquals(address, supplier.getAddress());
        assertEquals(phoneNumber, supplier.getPhoneNumber());
    }
    
	
    
     @Test
     public void update() {
    	 Integer supplierId = 1;
         Suppliers supplier = new Suppliers(supplierId, "Supplier Name", "Supplier Address", 1234567890L);
         Suppliers updatedSupplier = new Suppliers(supplierId, "Updated Supplier Name", "Updated Supplier Address", 9876543210L);
  
         
         SupplierService  service = new SupplierService() {
        	 @Override
        	 public Suppliers updateSuppliers(Integer id,Suppliers supplier) {
        		 return updatedSupplier;
        	 }
         };
         
         
         SupplierController controller = new SupplierController(service);
         ResponseEntity<Suppliers> response = controller.updateSuppliers(supplierId, updatedSupplier);
         
         assertEquals(HttpStatus.OK, response.getStatusCode());

         assertNotNull(response.getBody());
         assertEquals(updatedSupplier, response.getBody());
     
     }
     

     
     
 }


