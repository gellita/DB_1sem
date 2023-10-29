select id, full_name, birth_date, gender
from customers
order by birth_date asc;

select id, customer_name, order_date, total_price, payment_method, delivery_address
from orders
where payment_method = 'cash'
limit 3;

select * from onlineShop order by id desc;

select onlineShop.name, count(*) as num_orders from orders
join onlineShop on orders.onlineShop_id = onlineShop.id
group by onlineShop.name;