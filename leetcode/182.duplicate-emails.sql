# Write your MySQL query statement below
select distinct Email
from Person p
group by Email
having count(*)>1
