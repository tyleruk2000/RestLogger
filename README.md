# RestLogger
simple application to go out rest requests

# Usage
curl 127.0.0.1:8080/log?log=Hello%20World!
this will log 'Hello World!' to /var/tmp/spring.log

curl 127.0.0.1:8080/email?subject=Hello%20World!
This will email tyler.allen a blank email with the subject Hello World
