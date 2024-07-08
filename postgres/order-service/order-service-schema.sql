-- SELECT 'CREATE DATABASE orderservice'
-- WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'orderservice')\gexec
create database orderservice;