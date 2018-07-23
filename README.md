## CI Build Statuses
| Linux          | macOS          | Windows          |License           |
|----------------|----------------|------------------|------------------|
|[![Linux][1]][2]|[![macOS][1]][2]|[![Windows][3]][4]|[![License][5]][6]|

[1]: https://travis-ci.org/illichso/courses.svg?branch=master
[2]: https://travis-ci.org/illichso/courses
[3]: https://ci.appveyor.com/api/projects/status/r4hcn0djn78cslbs/branch/master?svg=true
[4]: https://ci.appveyor.com/api/projects/status/r4hcn0djn78cslbs/branch/master
[5]: https://img.shields.io/github/license/srs/gradle-node-plugin.svg
[6]: http://www.apache.org/licenses/LICENSE-2.0.html

# Code Challenge
Design and implement a RESTful API (including data model and the backing implementation) for money transfers between internal users/accounts.


##  Explicit requirements:

##### 1
keep it simple and to the point (e.g. no need to implement any authentication, assume the APi is invoked by another internal system/service)
##### 2
use whatever frameworks/libraries you like (except Spring) but don't forget about the requirement #1
##### 3
the datastore should run in­memory for the sake of this test
##### 4
the final result should be executable as a standalone program (should not require a pre­installed container/server)
##### 5
demonstrate with tests that the API works as expected


## Implicit requirements:

##### 1
the code produced by you is expected to be of good quality.
##### 2
there are no detailed requirements, use common sense.

## How to run

run 

`mvn clean install`

then

` java -jar target/*.jar`



## Details

- we don't care about registering users: a user is created as soon as they post
  their first message
- we don't care about user authentication
- we don't care about frontend, only backend
- we don't care about storage: storing everything in memory is fine
