# Write your MySQL query statement below
select Name
from Customers
where Id not in (select Orders.CustomerId
                 from Orders)
