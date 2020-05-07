#!/usr/bin/env bash
echo "git checkout publish"
git checkout publish
echo "git pull"
git pull
echo "building package..."
mvn clean package -Dmaven.test.skip=true

export pidtokill=`ps aux | grep ege-0.0.1-SNAPSHOT.jar | awk 'NR==1{print $2}' | cut -d' ' -f1`;kill -9 $pidtokill || true
sleep 5
export pidtokill=`ps aux | grep ege-0.0.1-SNAPSHOT.jar | awk 'NR==1{print $2}' | cut -d' ' -f1`;kill -9 $pidtokill || true
sleep 5

nohup java -jar target/ege-0.0.1-SNAPSHOT.jar > log.txt 2> errors.txt < /dev/null & PID=$!

sleep 10

echo "preload checking..."
echo "============================================="
curl -i "http://localhost/ege/api/test/preload"
echo "============================================="
echo "preload done"

#curl -i "http://localhost:8080/ege/api/car/getCarTypeInfo"