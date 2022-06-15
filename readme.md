### Before Batch

    3116100 nanoseconds spent preparing 16 JDBC statements;
    4915600 nanoseconds spent executing 16 JDBC statements;
    0 nanoseconds spent executing 0 JDBC batches;

### After Batch

    1690800 nanoseconds spent preparing 9 JDBC statements;
    2349700 nanoseconds spent executing 8 JDBC statements;
    1844000 nanoseconds spent executing 2 JDBC batches;

### Note
Hibernate disables insert batching at the JDBC level transparently if you use an IDENTITY identifier generator - [refer](https://docs.jboss.org/hibernate/orm/4.3/manual/en-US/html/ch15.html)

#### Reference
https://www.baeldung.com/spring-data-jpa-batch-inserts

https://stackoverflow.com/questions/50772230/how-to-do-bulk-multi-row-inserts-with-jparepository
