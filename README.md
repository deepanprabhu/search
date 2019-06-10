# ZenDesk Search

This application allows you to query and search organizations, tickets and users of the homework.

###### Prerequisites
* Java 12
* Maven 3.6.1

###### Libraries and General Design

The project consists of data spread across three json files, with associations between them 
to represent the relation amongst them.

* Organizations - Lists all organizations.
* Users - Lists all users - Each user is linked to an organization.
* Tickets - Tickets of an organization, with a Submitter and an Assignee.

A User belongs to an organization. A Ticket belongs to an organization and Has a Submitter who is a user
and an Assignee who is also a user. 
Each of the above objects have a set of properties like email, tags. 

To allow detailed and rich querying capabilities on top of above schema, I have implemented 
the project using Apache JXPath.

The search language is XPath and when a query is supplied, the appropriate object/Properties
are displayed to the screen.

The sample queries in the upcoming section will give a glimpse of the query language and ways to query the Objects.

###### Compiling The Application

`mvn clean compile test assembly:single`

The above command compiles, runs tests and packages the application as a single jar artifact. The search application and
json files are bundled inside them.

###### Executing the Application

* After you have created the jar, go to target folder,
* Execute `java -jar search-1.0-jar-with-dependencies.jar`
    * `Usage: help` is displayed
* Execute `java -jar search-1.0-jar-with-dependencies.jar help`
    * Search command and Schema are displayed
    
            Usage: search <search-query-xpath>
            Organization
                id
                url
                name
                domainNames
                createdAt
                details
            
            Ticket
                id
                url
                createdAt
                type
                subject
                description
                priority
                status
                submitter - A User Object
                assignee - A User Object
                organization - An Organization Object
                tags
                hasIncidents
                dueAt
                via
            
            User
                id
                url
                name
                alias
                createdAt
                active
                verified
                shared
                locale
                timezone
                lastLoginAt
                email
                signature
                organization - An Organization Object
                tags
                suspended
                role`
                
###### Usage Examples

* General Information - **doc** refers to the document. Its a placeholder and mandatory on 
all queries to begin as below.
    * `doc/users` - Refers to all users
    * `doc/organizations` - Refers to all organizations
    * `doc/tickets` - Refers to all tickets
* Print all Users
    * `java -jar search-1.0-jar-with-dependencies.jar search 'doc/users'`
    
* Print first 5 Tickets
    * `java -jar search-1.0-jar-with-dependencies.jar search 'doc/tickets[position() < 6]'`
    
* Print first 5 Ticket's Url
    * `java -jar search-1.0-jar-with-dependencies.jar search 'doc/tickets[position() < 6]/@url'`
    
* Print Tickets - With Empty Type
    * `java -jar search-1.0-jar-with-dependencies.jar search 'doc/tickets[@type=""]'`
    
* Invalid Query
    * `java -jar search-1.0-jar-with-dependencies.jar search 'docs'`
    
* Print Submitter's name of First 4 tickets - Association
    * `java -jar search-1.0-jar-with-dependencies.jar search 'doc/tickets[position() < 5]/submitter/@email'`