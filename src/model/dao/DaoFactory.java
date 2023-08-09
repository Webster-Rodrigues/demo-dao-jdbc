package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	//Operações estáticas p/ intânciar os DAOs
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
		/*A classe expõe um método que retorna o tipo da interface. Mas internamente instância uma implementação
		 *Ou seja, não precisa expor a implementação direto, pois no programa basta instânciar um SellerDao por meio deste método */
	}

}
