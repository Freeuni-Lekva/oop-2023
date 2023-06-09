[Stream.reduce() ფუნქციის დეტალური guide](https://www.baeldung.com/java-stream-reduce)

ამოცანა:

გვაქვს Employees კლასი.
EmployeeCatalog კლასში შეინახეთ თანაშრომლების სია და დაწერეთ 3 ფუნქციის იმპლემენტაცია map, reduce და filter ფუნქციების გამოყენებით:
* public Employee findEmployeeWithHighestSalary();
    * იპოვეთ ყველაზე მაღალანაზღაურებადი თანამშრომელი
* public int getSalaryGapInDepartment(Employee.Department department);
    * იპოვეთ მოცემულ დეპარტამენტში მაქსიმალურ და მინიმალურ ხელფასებს შორის სხვაობა
* public Employee.Department findDepartmentWithHighestCumulativeSalary();
    * იპოვეთ დეპარტამენტი მაქსიმალური ჯამური ხელფასით

