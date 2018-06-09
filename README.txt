
-Problem Description-----
We'd like you to build a website that functions as a URL Shortener:

1. A user should be able to load the index page of your site and be presented with an input field where they can enter a URL.
2. Upon entering the URL, a "shortened" version of that url is created and shown to the user as a URL to the site you're building.
3. When visiting that "shortened" version of the URL, the user is redirected to the original URL.
4. Additionally, if a URL has already been shortened by the system, and it is entered a second time, the first shortened URL should be given back to the user.

For example, if I enter http://www.apple.com/iphone-7/ into the input field, and I'm running the app locally on port 9000, I'd expect to be given back a URL that looked something like http://localhost:9000/1. Then when I visit http://localhost:9000/1, I am redirected to http://www.apple.com/iphone-7/.

Expectations
Straight HTML. No need for any CSS.
Submit the project as a Git archive. Do not include artifacts. We might look at the history.
A small README is appreciated. A few words about your approach? How to compile/launch your application?
You may have to make some assumptions. It is expected. Please explain them.
Good developers write unit tests.
We do use Scala but it is not necessary here. Use the JVM stack (or node.js) you are most comfortable with. During the on-site interview, we will expect you to be an expert.
No project is ever done/complete. Your job is to convince us that you understood the problem and that we want to discuss your approach with you.
You really want to use a hash function? Think twice and motivate your choice.
You may want to use external dependencies e.g. database. It's totally fine! Just tell us more about your choice.


-----Problem Answer

This program implements a URL shortener using a REST API server implemented in JAVA which is a JVM language.

It accepts a URL as either a web browser URL, or as a command line curl input using REST POST as the interface.

I used a hash function to store each website URL in a Hashmap.

I did not use a database, because it made the design more elegant and simpler.

I used node.js with no need for CSS, and used the express fetch API. 

I considered use of the Jsp server pages, but didn't like the interface security for spring. 

Future work:

I might want to improve the output console message response, but no project is ever complete.

-----

How to build project:
-------------

mvn clean install

How to run the project:
-----------------------

mvn spring-boot:run

node form.js



Use case tests.

Command Line tests:

curl -vX POST localhost:8080/https://www.google.pl/search?q=henry+hottelet

curl -v localhost:8080/132b6aca

curl -vX POST localhost:8080/http://www.apple.com/iphone-7

curl -v localhost:8080/293da879


Browser tests:

localhost:8080/https://www.google.pl/search?q=henry+hottelet

localhost:8080/132b6aca

localhost:8080/http://www.apple.com/iphone-7

localhost:8080/293da879



REST Chrome Client tests:

localhost:8080/https://www.google.pl/search?q=henry+hottelet

localhost:8080/132b6aca


