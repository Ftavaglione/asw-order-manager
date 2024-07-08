-- SELECT 'CREATE DATABASE ordervalidationservice'
-- WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'ordervalidationservice')\gexecc
create database ordervalidationservice;