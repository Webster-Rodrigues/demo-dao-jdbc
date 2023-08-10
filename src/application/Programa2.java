package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Programa2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1: FindById ====");
		Department department = depDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: Department findAll =====");
		List<Department> list = depDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: Department DepartmentInsert =====");
		Department newDepartment = new Department(2, "Gestão");
		depDao.insert(newDepartment);	
		System.out.println("Inserção concluida! Novo id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: Department DepartmentUpdate =====");
		department = depDao.findById(1);
		department.setName("Jurídico");
		depDao.update(department);
		System.out.println("Update concluido");
		
		System.out.println("\n=== TEST 6: seller SellerUpdate =====");
		System.out.print("Informe o id para deletar: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Deleção completa!!");
		
		sc.close();


	}

}
