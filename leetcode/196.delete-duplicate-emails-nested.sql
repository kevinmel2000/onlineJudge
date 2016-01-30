# Write your MySQL query statement below
delete from Person
where Id not in 
(
    # You can't specify target table 'Person' for update in FROM clause
    select min_id from (
        select min(Id) as min_id
        from Person
        group by Email
    ) as Cid # Every derived table must have its own alias
)
