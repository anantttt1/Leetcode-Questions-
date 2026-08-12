SELECT Employees.name , EmployeeUNI.unique_ID
FROM Employees
LEFT JOIN EmployeeUNI
ON Employees.id=EmployeeUNI.id;