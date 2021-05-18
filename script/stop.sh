PID=$(ps -ef | grep service-stu-0.0.1-SNAPSHOT.jar | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
    echo Application is already stopped
else
	echo kill $PID
	kill -9 $PID
fi

