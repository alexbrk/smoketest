## smoketest
This simple smoketest has been developed as a training project to learn UI automation with Selenium WebDriver (Java).
The website under test "1949deal.com" runs on Magento and has been chosen for 2 reasons: order can be completed without
actual payment, no captcha input required.
The website itself is very slow and server errors occur frequently, so needed improvements were implemented in code to
deal with it.
Tests can be run via command line. Type `test mvn -Dtestsuite=testng.xml` or `test mvn -Dtestsuite=testngfast.xml` to
run just one quick search test.
