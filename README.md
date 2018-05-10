# Cafe-billing

## Pre-requisite
* Java 1.8 +
* Scala 2.12.6

## Running tests
In terminal run following command   
```sbt test```
## Assumptions
1. For this exercise data type of food price is selected as BigDecimal and not a DomainObject such as Money. Creating a domain object looks over engineering for this exercise.
2. BillGenerator code ignores the non-available menu items and continue processing.
