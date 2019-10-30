# Write your MySQL query statement below

# Solution 1
select max(Salary) as SecondHighestSalary
from Employee
where
Salary < (select max(Salary) from Employee)

# Solution 2
# select(select distinct Salary
# from Employee
# order by Salary desc
# limit 1 offset 1) as SecondHighestSalary
