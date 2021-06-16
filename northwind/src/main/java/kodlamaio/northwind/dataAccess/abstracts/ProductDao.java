package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
	//veri tipi için(entity ile süslenmiş product için ) intelisense hazırlıyor>>CRUD gibi
	
	//EntityFrameworkBaseRepository burası
	
	Product getByProductName(String productName);
	//getBy ile tablolara bakıp where koşulu yapıyor
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	//and >> ikisine de uyacak
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
	//or>>ir tanesi gelse yeterli
	List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	//bizim entity miz olan product > product içindeki productName
	//=:  >>> parametre demek
	List<Product> getByNameAndCategory(String productName,int categoryId);
	//sorgu gönderiyoruz 
	
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
			+ "(p.id, p.productName,c.categoryName) "
			+ "From Category c inner join c.products p")
	//objeler üzerinden
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	//from la başlarsak tüm kolonları getirir
	

}
