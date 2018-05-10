# Cafe-billing

## Pre-requisite
* Java 1.8 +
* Scala 2.12.6
* sbt 1.1.4

## Running tests
In terminal run following command   
```sbt test```
## Assumptions
1. For this exercise data type of food price is selected as BigDecimal and not a DomainObject such as Money. Creating a domain object looks over engineering for this exercise.
2. BillGenerator code ignores the non-available menu items and continue processing.
3. A maximum £20 service charge will apply in any case.

### Note
Kept both functions totalBillWithServiceCharge() and totalBill() available to public use

## Test Specification
Cafe X menu consists of the following items:
* Cola - Cold - 50p
* Coffee - Hot - £1.00
* Cheese Sandwich - Cold - £2.00
* Steak Sandwich - Hot - £4.50
Customers don’t know how much to tip and staff need tips to survive!

#### Step 1 : Standard Bill
Pass in a list of purchased items that produces a total bill. e.g. [“Cola”, “Coffee”, “Cheese Sandwich”] returns 3.5

#### Step 2: Service Charge
Add support for a service charge :
* When all purchased items are drinks no service charge is applied
* When purchased items include any food apply a service charge of 10% to the total bill
(rounded to 2 decimal places)
* When purchased items include any hot food apply a service charge of 20% to the total bill
with a maximum £20 service charge

