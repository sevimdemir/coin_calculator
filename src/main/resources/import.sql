insert into coins (id, coin_type) values (1, 'BTC');
insert into coins (id, coin_type) values (2, 'ETH');

insert into currencies (id, currency) values (1, 'USD');
insert into currencies (id, currency) values (2, 'EUR');

insert into coin_currency_relations (id, coin_id, currency_id) values (1, 1, 1);
insert into coin_currency_relations (id, coin_id, currency_id) values (2, 1, 2);
insert into coin_currency_relations (id, coin_id, currency_id) values (3, 2, 1);
insert into coin_currency_relations (id, coin_id, currency_id) values (4, 2, 2);