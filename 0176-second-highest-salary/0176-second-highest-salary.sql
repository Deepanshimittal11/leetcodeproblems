# Write your MySQL query statement below

#agr inner quesry se koi value nhi aaegi to outer query usse null return kr degi
#maan lo sirf ek hi salary given to us testcase me hme yeh use krna pdega

select(
    select distinct salary
    from Employee
    order by salary desc
    limit 1 offset 1
) as SecondHighestSalary