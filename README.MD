
USERNAME = User1

PASSWORD = nimda



**Project topic:** Electricity billing system

**Project idea:** The project aims at serving the department of electricity by computerizing the billing system. It mainly focuses on the calculation of Units consumed during the specified time and the money to be paid to electricity offices. This computerized system will make the overall billing system easy, accessible, comfortable and effective for consumers.

**Project description:** To make the billing system more service-oriented and simple, the following features should be implemented in the project.
•	The application has high speed of performance with accuracy and efficiency.
•	The software provides facility of data sharing.
•	It doesn’t require any staffs as in the conventional system. Once it is installed on the system, only the meter readings are to be given by the customer.
•	The electricity billing software calculates the units consumed by the customer and makes bills.
•	It has the provision of security restriction.
•	It requires small storage for installation and functioning.
•	There is provision for debugging if any problem is encountered in the system.

**We have 6 models:** Admin, Consumer, Region, Inspector, Doc, Bank account.

Consumer - Region one to many

Consumer - Bank account one to one

Consumer - Inspector many to many

Admin - Doc one to one

**Functionalities:**
    
Consumer:
* CRUD
* When we creating consumer it checks region of this new consumer. If there is no such region it will not add to Database. Or if exists consumer like this first name and last name, it also don't add to database. And when we create consumer successfully, it automatically creates the Bank account for this Consumer. By default money in this bank account will be 0.0
* Find Consumers By Region ID. It lists all consumer in this region
* Make bill to consumer by personal account. This func. gets personal account and meter reading. After then consumer say what he wants check payment or pay bill for this month.
After this we have 3 lvl of payment. First lvl is less than 180. Second lvl in the middle of 180 and 320. And Third lvl more that 320. It means if Consumer used electricity more that 180 or 320 it pays this other cost.After all of this the field "Last meter reading" will change in database
* When consumer checks the bill, it just show payment for this month(current meter reading-last meret reading). and if consumer want to pay, it will calculate payment by 3 lvl payment and automatically takes money on his bank account.
* Consumer can fill up his bank account
* If the meter reading is broken Consumer can call Inspector for check this meter reading. After this INspector will sent his service cost by JMS message
* And Consumer can pay this service by his bank account
  
Bank account:
* list of bank accounts
* CRUD
* we can fill up bank account
* it automatically fill down the money when it pay bill for month or pay for service
    
    
Inspector:
* list inspectors
* crud
* inspector set his service cost by jms message
    
   
    
Region:
* list regions
* crud
* it doesn't crete region if region like this already exists
* There 3 lvl of payment, different for any region

Doc:
* we can download or upload doc file

    


