Readme to follow
Download Scala plugin intellij

Clone Repository

`git clone git@github.com:lukem-kainos/EnstarSparkTutorial.git`

Intellij File > Open > Cloned folder
It will automatically download dependencies

[Download Docker](https://www.docker.com/products/docker)

`docker pull cloudera/quickstart:latest`

`docker images`

IMAGE ID of cloudera/quickstart

using bash

`docker run --hostname=quickstart.cloudera --privileged=true -v ~:/shared -t -i -p 8888 -p 7180 -p 80 -p3552 IMAGE_ID /usr/bin/docker-quickstart`

in docker cli

`cd shared/Downloads`

`rpm -Uvh AttunityReplicate_Express_Linux_X64.rpm`

Set Attunity Replicate password

`cd /opt/attunity/replicate/bin/`

`source arep_login.sh`

`./repctl SETSERVERPASSWORD pass`

`/opt/attunity/replicate/bin/arep.ctl stop`

`/opt/attunity/replicate/bin/arep.ctl start`

Now run 

`docker ps`

Which will list fowarded ports, find which port was forwarded to 3552 and make note

Then in a browser

`localhost:forwardport/attunityreplicate`

login admin
password pass

**Set up DB**

[Download DB](https://launchpad.net/test-db/employees-db-1/1.0.6/+download/employees_db-dump-files-1.0.5.tar.bz2)

`mysql -uroot < employees_partitioned.sql` (NEED TO VERIFY)