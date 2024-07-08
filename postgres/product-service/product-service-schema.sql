--SELECT 'CREATE DATABASE productservice'
--WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'productservice')\gexec
create database productservice;