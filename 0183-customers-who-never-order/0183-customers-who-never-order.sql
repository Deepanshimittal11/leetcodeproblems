# Write your MySQL query statement below

#we have to find the customer id which is not present in customerId of orders list.
#vo customer ki jo orders ki customerid list me nhi h

select c.name as Customers
from Customers c
where c.id not in (
    select o.customerId
    from Orders o
)