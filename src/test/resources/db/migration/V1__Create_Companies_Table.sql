create table if not exists "companies" (
  "id" integer primary key,
  "uuid" uuid unique,
  "name" varchar(50),
  "cnpj" varchar(40) unique,
  "phone" varchar(20) unique,
  "created_at" timestamp default current_timestamp,
  "updated_at" timestamp default current_timestamp
);