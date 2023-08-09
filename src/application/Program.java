package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: seller findAll =====");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 4: seller SellerInsert =====");
		Seller newSeller = new Seller(null, "Matias", "mtslreg@gmail.com", new Date(), 4000.30, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserção concluida! Novo id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller SellerUpdate =====");
		seller = sellerDao.findById(1);
		seller.setName("Marina Silva");
		sellerDao.update(seller);
		System.out.println("Update concluido");
		
		
		
	}

}
