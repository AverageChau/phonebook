# phonebook

 
A phonebook program that add, find, delete and sort contacts.
focus on query performace, using array to store contacts using phone number as index.
using Hashmap to help quickly find the contacts with a name.

basic query function: "add NAME NUMBER", "find NAME" or "find NUMBER", "del NAME", "del NUMBER", "print" and "sort".
ex: "add 9166200602 Joe" - add contact name Joe number 9166200602
    "find 9166200601" - find contact with number, return name or NotFound
    "find joe" - find contact with name, return num or NotFound
    "print" - print the phone book sort by phone number
    "sort" - sort phone book by name then print. 
