package testSupplierController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Suppliers;
import com.example.demo.service.SupplierService;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class updateSupplierTests {

	
	 @Autowired
	    private SupplierService supplierService;

	    @Test
	    public void testUpdateSuppliers() {
	        // Create a sample Suppliers object
	        Suppliers supplier = new Suppliers(2, "Supplier Name", "Supplier Address", 1234567890L);
	        
	        
	        Suppliers result = supplierService.updateSuppliers(2, supplier);
	        
	        // Retrieve the updated Suppliers object from the database
	        Suppliers updatedSupplier = supplierService.getSupplierByID(2).orElse(null);
	        
	        
	        
	        assertEquals(supplier.getId(), updatedSupplier.getId());
	        assertEquals(supplier.getName(), updatedSupplier.getName());
	        assertEquals(supplier.getAddress(), updatedSupplier.getAddress());
	        assertEquals(supplier.getPhoneNumber(), updatedSupplier.getPhoneNumber());
	    }
	    
	    
	    
	    @Test
	    public void testDeleteSuppliers() {
	        // Create a sample Suppliers object
//	        Suppliers supplier = new Suppliers(2, "Supplier Name", "Supplier Address", 1234567890L);
//
//	        // Add the sample Suppliers object to the database
//	        supplierService.createSupplier(supplier);

	        // Delete the Suppliers object
	        supplierService.deleteSuppliers(2);

	        // Retrieve the Suppliers object after deletion
	        Optional<Suppliers> deletedSupplier = supplierService.getSupplierByID(2);

	        // Assert that the Suppliers object does not exist in the database
	        assertFalse(deletedSupplier.isPresent());
	    }
}
