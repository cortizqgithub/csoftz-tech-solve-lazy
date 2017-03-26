-- Mar.25/2017
CREATE KEYSPACE IF NOT EXISTS lazy_worker WITH replication = {'class':'SimpleStrategy', 'replication_factor':3};