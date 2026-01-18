create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

insert ignore into `users` values('user','{noop}dPsS89108!','1');
insert ignore into `authorities` values('user','read');

insert ignore into `users` values('admin','{bcrypt}$2a$12$jP8bH79517IpVRpTbrHBo.LK4QKiEBpMTgv0CffmKlUEt0O6M0Zay','1');
insert ignore into `authorities` values('admin','admin');

