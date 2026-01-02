CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    set n = n-1;
  RETURN (
      # Write your MySQL query statement below.
    --   distinct is used nth (dynamic) elements.
        select distinct salary 
        from Employee
        order by salary desc
        LIMIT 1 offset n       
  );
END