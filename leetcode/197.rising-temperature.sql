# Write your MySQL query statement below
select w2.Id
from Weather w1, Weather w2
where w1.Date=subdate(w2.Date,1) and w1.Temperature<w2.Temperature
