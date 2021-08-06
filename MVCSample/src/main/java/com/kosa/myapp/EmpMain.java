package com.kosa.myapp;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new GenericXmlApplicationContext("application-config.xml");
		IEmpService service = context.getBean(IEmpService.class);
//		int empCount = service.getEmpCount();
//		System.out.println("전체 사원의 수 : " + empCount);
//		
//		System.out.println("부서의 사원의 수 : " + service.getEmpCount(50));
////		System.out.println(service.getEmpList());
//		List<EmpVO> empList = service.getEmpList();
//		for(EmpVO emp : empList) {
//			System.out.println(emp);
//		}
//		EmpVO emp1 = service.getEmpInfo(300);
//		System.out.println(emp1);
//		emp1.setEmail("A123456");
//		emp1.setSalary(9998);
//		try {
//			service.updateEmp(emp1); //사원 정보 수정
//		}catch(RuntimeException e) {
//			System.out.println(e.getMessage()); //트리거에 의해 두번 이상 사원의 직무 변경 안됨
//		}
//		System.out.println(service.getEmpInfo(300));
//		EmpVO newEmp = new EmpVO(321, "aaa", "bbb", "aabc", "010",
//				new java.sql.Date(2020,8,2), "IT_PROG", 8888, 0.1, 103, 50);
//		try {
//			service.insertEmp(newEmp);
//			System.out.println("Insert OK!");
//		}catch(RuntimeException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(service.getEmpInfo(321));
//		try {
//			service.deleteEmp(321, "aabc");
//			System.out.println("사원정보가 삭제되었습니다.");
//		}catch(RuntimeException e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			System.out.println(service.getEmpInfo(321));
//		}catch(RuntimeException e) {
//			System.out.println("삭제할 사원정보가 없습니다."); //이 메시지가 출력되어야 정상
//		}
		List<Map<String, Object>> deptInfo = service.getAllDeptId();
		for(Map<String, Object> deptId : deptInfo) {
			System.out.println(deptId.get("DEPARTMENTID"));
			System.out.println(deptId.get("DEPARTMENTNAME"));
		}
		context.close();
	}
}
