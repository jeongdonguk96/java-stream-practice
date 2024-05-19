package problem.medium;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import problem.medium.resources.Customer2;
import problem.medium.resources.Employee;
import problem.medium.resources.Order;
import problem.medium.resources.Product;

public class Problem60 {

    /**
     * 주어진 고객(Customer) 리스트와 직원(Employee) 리스트를 사용하여,
     * 'IT' 부서 직원들이 주문한 'Electronics' 제품의 총 가격을 계산합니다.
     * 이때, 고객 이름과 직원 이름이 일치하는 경우에만 해당 고객의 주문을 고려합니다.
     *
     * @param customers 고객 리스트
     * @param employees 직원 리스트
     * @param products 제품 리스트 (제품 이름과 가격 정보 포함)
     * @return 'IT' 부서 직원들이 주문한 'Electronics' 제품의 총 가격
     */
    public static double calculateTotalPriceOfElectronicsOrderedByITEmployees(List<Customer2> customers,
                                                                              List<Employee> employees,
                                                                              List<Product> products) {
        // it 부서 사람들
        List<String> itPeople = employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .map(Employee::getName)
                .toList();


        // 전가기기 상품 가격
        Map<String, Double> productPrices = products.stream()
                .filter(product -> product.getName().equals("Laptop") || product.getName().equals("Smartphone"))
                .collect(Collectors.toMap(
                        Product::getName,
                        Product::getPrice
                ));

        return customers.stream()
                .filter(customer -> itPeople.contains(customer.getName())) // 구매자와 it부서 사람을 일치
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> productPrices.containsKey(order.getProduct()))
                .mapToDouble(order -> productPrices.get(order.getProduct()) * order.getQuantity())
                .sum();

    }
}
