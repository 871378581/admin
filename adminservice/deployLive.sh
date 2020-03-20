#!/usr/bin/env bash

export pidtokill=`ps aux | grep ege-0.0.1-SNAPSHOT.jar | awk 'NR==1{print $2}' | cut -d' ' -f1`;kill -9 $pidtokill || true
sleep 5
export pidtokill=`ps aux | grep ege-0.0.1-SNAPSHOT.jar | awk 'NR==1{print $2}' | cut -d' ' -f1`;kill -9 $pidtokill || true
sleep 5

#https://www.jianshu.com/p/c023083f51b4
nohup java -jar target/ege-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=live > log.txt 2> errors.txt < /dev/null & PID=$!

sleep 10

echo "preload checking..."
echo "============================================="
curl -i "http://localhost:8080/ege/api/test/preload"
echo "============================================="
echo "preload done"

#curl -i "http://localhost:8080/ege/api/car/getCarTypeInfo"
