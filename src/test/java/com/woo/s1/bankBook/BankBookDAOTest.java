package com.woo.s1.bankBook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.woo.s1.MyTestCase;

public class BankBookDAOTest extends MyTestCase {

	@Autowired
	private BankBookDAO bankBookDAO;
	
//	@Test
//	public void getBankBookListTest() throws Exception {
//		List<BankBookDTO> ar = bankBookDAO.getBankBookList();
//		System.out.println(ar.size()>0);
//		
//		assertNotEquals(0, ar.size());
//		
//	}
//	
//	@Test
//	public void getBankBookDetailTest() throws Exception {
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBookNumber(2L);
//		bankBookDTO = bankBookDAO.getBankBookDetail(bankBookDTO);
//		assertNotNull(bankBookDTO);
//	}
	
//	@Test
//	public void setBankBookAddTest() throws Exception {
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBookNumber(3L);
//		bankBookDTO.setBookName("신한");
//		bankBookDTO.setBookRate(5.0);
//		bankBookDTO.setBookSale(1L);
//		bankBookDTO.setBookDetail("신한은행입니다.");
//		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void setBankBookDeleteTest() throws Exception {
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		
//	}

	@Test
	public void setBankBookAddTest2() throws Exception {
		for(int i=0;i<30;i++) {
			Random r = new Random();
			double d = r.nextDouble();
			int num = (int)(d*1000);
			d = num/100.0;
			
			BankBookDTO bankBookDTO = new BankBookDTO();		
			bankBookDTO.setBookName("신한적금");
			bankBookDTO.setBookRate(d);
			bankBookDTO.setBookSale(1);
		}
		System.out.println("Finish");
	}
	
}

